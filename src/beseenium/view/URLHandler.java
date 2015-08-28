/** Copyright(C) 2015 Jan P.C. Hanson & BeSeen Marketing Ltd
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package beseenium.view;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;

/**
 * The sole responsibility of this class is to translate parameters representing URL query 
 * strings from an http request into 'Test' functionality. 
 *
 * @author Jan P.C. Hanson
 *
 */
public class URLHandler 
{
	/** The Test to create **/
	Test test;
	/** End of line break **/
	static final String EOL = "\n";
	
	private static final Logger logger = LogManager.getLogger("BeSeenium.URLHandler");
	
	/**
	 * default constructor, initialise a test to operate on
	 * @throws ActionDataFactoryException
	 * @throws MalformedURLException
	 */
	public URLHandler() throws ActionDataFactoryException, MalformedURLException
	{
		super();
		test = new Test();
	}
	
	/**
	 * takes the URL parameters passed to it from the BeSeeniumServlet and uses it to populate and run a Test
	 * @param capabilities String of the form "key+value|key+value|key+value|..."
	 * @param browser String representation of the 'browser' query string can take the values: firefox,
	 * noWindows or remote(more to be added).
	 * @param addActions String of the form: 
	 * "name+inputParam+index|name+inputParam+index|name+inputParam+index|..."
	 * @return String representation of the aggregate results of the individual actions. will return
	 * an error message with appropriate content if an exception is caught
	 * \todo add more browser drivers
	 */
	public String handleURL(String capabilities, String browser,
			String addActions) 
	{	
		String caps="" ;
		String brwsr="" ;
		String actns="";
		
		
		try 
		{
			caps = handleCapabilities(capabilities);
			brwsr = handleBrowser(browser);
			actns = handleAddActions(addActions);
			String confirmationString = brwsr + caps + actns;
			return confirmationString + "TEST RESULTS: " + (test.executeActions().toString()) + EOL;
		} 
		
		catch (ActionDataException | ActionException | NullPointerException e) 
		{
			logger.warn("trace -> \n"+brwsr+caps+actns + "TEST RESULTS: ", e);
			return "ERROR: trace -> \n"+brwsr+caps+actns + "TEST RESULTS: "
					+e.getMessage() + e.getStackTrace().toString()+shutdown(e) + EOL;
		}
	}
	
	/**
	 * takes an input from servlet(via handleURL method) in the form of string 'get' URL parameter 
	 * 'capabilities' uses it to set the remoteDriver configuration, this is only of use when the 
	 * browser type is set as 'remote'
	 * @param capabilities String of the form "key+value|key+value|key+value|..."
	 * @return String of the form "DESIRED CAPABILITES:" + "[[key1, value1], [key2, value2], [key3, value3]]"
	 * will return an error message if the input string is badly formatted
	 */
	private String handleCapabilities(String capabilities)
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
		
		catch(MalformedURLException e1)
		{return "DESIRED CAPABILITIES: BAD URL"+EOL;}	
	}
	
	/**
	 * takes an input from servlet(via handleURL method) in the form of string 'get' URL parameter 
	 * 'browser' ancd uses it to set the Test's WebDriver.
	 * @param browser String representation of the WebDriver to use ("firefox"/"noWindows"/"remote"...etc)
	 * @return String of the form: "BROWSER SET AS" + "<name of browser>" + newline
	 */
	private String handleBrowser(String browser)
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
	 * takes an input from servlet(via handleURL method) in the form of string 'get' URL parameter 
	 * 'addActions' and uses it to add actions to the test.
	 * @param addActions String of the form:
	 * "name+inputParam+optional|name+inputParam+optional|name+inputParam+optional|..."
	 * @return String of the form:
	 * "ACTIONS ADDED:"+"[[action1, inputParam1, index1],[action2, inputParam2, index2]...[actionN, inputParamN, indexN]]
	 */
	private String handleAddActions(String addActions)
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
		String[] firstSplit = string.split("\\|"); //={"key|value", "key:value"}
		int split1Len = firstSplit.length;
		int split2Len = firstSplit[0].split(" ").length;
		String[][] resultArray = new String[split1Len][split2Len];// = {{"key","value"},{"key","value"}};
		
		for(int i = 0; i < firstSplit.length; ++i)
		{
			resultArray[i]=firstSplit[i].split(" ");
		}
		return resultArray;
	}
	
	/**
	 * in case something goes wrong the test should be able to shut down the current browser instance,
	 * or else there could potentially be many, for all intents and purposes, orphan processes floating
	 * about eating up memory....remember: always kill the orphans.
	 * @param e
	 * @return verification string
	 */
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
