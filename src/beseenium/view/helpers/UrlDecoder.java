package beseenium.view.helpers;

import java.net.MalformedURLException;
import java.util.Arrays;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;

/**
 * 
 * @author orpheus
 *
 */
public class UrlDecoder 
{
	/** The Test to create **/
	Test test;
	/** End of line break **/
	static final String EOL = "\n";
	
	/**
	 * default constructor, initialise a test to operate on
	 * @throws ActionDataFactoryException
	 * @throws MalformedURLException
	 */
	public UrlDecoder() throws ActionDataFactoryException, MalformedURLException
	{
		super();
		test = new Test();
	}
	
	/**
	 * takes the URL parameters passed to it from the BeSeeniumServlet and uses it to populate and run a Test
	 * @param capabilities 
	 * @param browser
	 * @param addActions
	 * @param execute
	 * @return String representation of the aggregate results of the individual actions. will return
	 * an error message with appropriate content if an exception is caught
	 */
	public String decodeURL(String capabilities, String browser,
			String addActions, String execute) 
	{	
		String caps="" ;
		String brwsr="" ;
		String actns="";
		
		
		try 
		{
			caps = decodeCapabilities(capabilities);
			brwsr = decodeBrowser(browser);
			actns = decodeAddActions(addActions);
			String confirmationString = brwsr + caps + actns;
			return confirmationString + "TEST RESULTS: " + (test.executeActions().toString()) + EOL;
		} 
		
		catch (ActionDataException | ActionException | NullPointerException e) 
		{
			return "ERROR: trace -> \n"+caps+brwsr+actns + "TEST RESULTS: "
					+e.getMessage() + e.getStackTrace().toString()+shutdown(e) + EOL;
		}
	}
	
	/**
	 * takes an input from servlet in the form of string 'get' URL parameter 'capabilities' uses it to set the 
	 * remoteDriver configuration, this is only of use when the browser type is set as 'remote'
	 * @param capabilities String of the form "key:value|key:value|key:value|..."
	 * @return String of the form message + "[[key1, value1], [key2, value2], [key3, value3]]"
	 * will return an error message if the input string is badly formatted
	 */
	private String decodeCapabilities(String capabilities)
	{	
		try
		{
			String[][] caps = this.splitString(capabilities);
		
			for(String[] capabilitySet: caps)
			{
					if(capabilitySet.length == 2 )
					{
						this.test.configureRemoteDriver(capabilitySet[0], capabilitySet[1]);
					}
				
					else
					{
						shutdown(new Exception());
						return "ERROR: badly formatted capability string" + EOL;
					}
			}
		return "DESIRED CAPABILITIES: "+Arrays.deepToString(caps) + EOL;
		}
		
		catch(NullPointerException e)
		{return "DESIRED CAPABILITIES: NONE" + EOL;}
	}
	
	/**
	 * 
	 * @param browser
	 * @return
	 */
	private String decodeBrowser(String browser)
	{
		try 
		{
			this.test.setBrowser(browser);
			return "BROWSER SET AS: " + browser + EOL;
		} 
		
		catch (ActionDataException | NullPointerException e) 
		{
			
			return "could not set browser as \"" + browser +"\" "
					+ e.getMessage() +" " + e.getStackTrace().toString()+shutdown(e) + EOL;
		}
	}
	
	/**
	 * 
	 * @param addActions = name:inputParam:optional|name:inputParam:optional|name:inputParam:optional|...
	 * @return
	 */
	private String decodeAddActions(String addActions)
	{
		String[][] actions = splitString(addActions);
		
		for(String[] actionSet: actions)
		{
			try 
			{
				this.test.addAction(actionSet[0], actionSet[1], Integer.parseInt(actionSet[2]));
			} 
			
			catch (ActionFactoryException e) 
			{
				return "ERROR: "+ e.getMessage() +" " + e.getStackTrace() +shutdown(e) + EOL;
			}
			
			catch(NumberFormatException e)
			{
				return "ERROR: the url parameter 'optional' is not a number"+shutdown(e) + EOL;
			}
		}
		return "ACTIONS ADDED: " + Arrays.deepToString(actions) + EOL;
	}
	
	/**
	 * split a string of the form "V01:V02:...:V0n|V11:V12:...:V1n|Vm1:Vm2:...:Vmn" into a 
	 * 2d String array of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 * @param string of the form "V01:V02:...:V0n|V11:V12:...:V1n|Vm1:Vm2:...:Vmn"
	 * @return String[][] of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 */
	private String[][] splitString(String string)
	{
		String[] firstSplit = string.split("\\|"); //={"key:value", "key:value"}
		int split1Len = firstSplit.length;
		int split2Len = firstSplit[0].split(" ").length;
		String[][] resultArray = new String[split1Len][split2Len];// = {{"key","value"},{"key","value"}};
		
		for(int i = 0; i < firstSplit.length; ++i)
		{
			resultArray[i]=firstSplit[i].split(" ");
		}
		return resultArray;
	}
	
	private String shutdown(Exception e)
	{
		try {test.emergencyShutdown();} 
		catch (ActionDataException | ActionException e1) 
		{
			e1.getStackTrace();
			return EOL + "CRITICAL ERROR: CANNOT PERFORM EMERGENCY SHUTDOWN" + EOL;
		}
		return EOL + "could not run test";
	}
}
