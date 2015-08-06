package beseenium.controller;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.model.actionData.ActionData;

/**
 * This Class conforms to a 'factory' pattern, it allows the creation of different
 * ActionData instances 
 * @author JPC Hanson
 *
 */
public class ActionDataFactory 
{
	/** container for string value pairs associated with this factory **/
	private  Map<String, Method> ActionDataMap;
	/** the  **/
	private  DesiredCapabilities capabilities;
	
	private  String URL;
	
	private ActionData emptyActionData;
	
	/**
	 * default constructor, initialises internal map and populates it
	 * @throws MalformedURLException 
	 */
	public ActionDataFactory() throws MalformedURLException
	{
		this.emptyActionData = new ActionData();
		this.ActionDataMap = new HashMap<String, Method>();
		
		try 
		{
			this.mapEntries();
		} 
		catch (NoSuchMethodException | SecurityException e) //reflection exceptions not throwing as user should never
		{													//ever see this, if these exceptions occur something has 
			e.printStackTrace();							//gone terribly wrong.
		}
	}
	
	/**
	 * when you wish to use the remote webdriver, then the capabilities must be set first, this method 
	 * provides a convenient way to set them.
	 * @param key the capability you wish to set
	 * @param value the value you wish to set it to.
	 */
	public void setCapabilities(String key, String value)
	{
		this.capabilities = new DesiredCapabilities();
		if (key != "auth")
		{
			this.capabilities.setCapability(key, value);
		}
		
		else
		{this.URL = "http://" + value + "@hub.browserstack.com/wd/hub";}
		System.out.println(capabilities.getCapability(key));
	}
	
	/**
	 * make a specific actionData containing a specific WebDriver.
	 * @param ActionDataKey the type of ActionData you wish to specify.
	 * @return ActionData containing no WebDriver
	 * @throws ActionDataFactoryException 
	 */
	public ActionData makeActionData(String ActionDataKey) throws ActionDataFactoryException
	{
		//if the ActionDataKey = "internal" then return the empty ActionData created at construction time
		if(ActionDataKey.contentEquals("internal")){return this.emptyActionData;}
		//otherwise grab the correct ActionData from the ActionDataMap
		else
		{
			//reference to this class
			Class<ActionDataFactory> actionDataFactory = ActionDataFactory.class;
		
			try {
					//instance of this class, needed to reflectivly invoke the method stored in the ActionDataMap
					Object action = actionDataFactory.newInstance();
					if(ActionDataMap.containsKey(ActionDataKey))
						//invoke the method returned from the ActionDataMap ON the Object defined above, i.e. this class
						//must be cast to ActionData as Method.invoke(Object) returns an Object, the cast is safe as this 
						//Object will always in reality be an ActionData.
					{return (ActionData) ActionDataMap.get(ActionDataKey).invoke(action);}
				} 
		
		
			//reflection exceptions
			catch (InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException e) 
				{
					throw new ActionDataFactoryException("you cannot reflectivly instanciate this type of ActionData"
							+ "	Check your spelling, or refer to documentation and pray!!" + e.getCause());
				}
		
			throw new ActionDataFactoryException("you cannot instanciate this type of ActionData"
					+ "	Check your spelling, or refer to documentation");
		}
	}
	
	
	
	/**
	 * Reflectively add 'Method' objects to the ActionDataMap, not normally the method I would chose to do this
	 * however calling 'new' on a WebDriver object automatically spools up a specific browser process, hence the need
	 * to store the method call but only invoke the method call when the map entry is needed.
	 * @throws MalformedURLException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private void mapEntries() throws MalformedURLException, NoSuchMethodException, SecurityException
	{
		//ActionDataMap.put("firefox", new ActionData( new FirefoxDriver() ));
		this.ActionDataMap.put("firefox", ActionDataFactory.class.getDeclaredMethod("makeFirefoxData"));
		//ActionDataMap.put("chrome", new ActionData( new ChromeDriver() ));
		this.ActionDataMap.put("noWindows",  ActionDataFactory.class.getDeclaredMethod("makeHTMLDriverData"));
		//ActionDataMap.put("remote", new ActionData(new RemoteWebDriver(new URL(URL), capabilities )));
	}
	
	/**
	 * 
	 * @return
	 */
	private ActionData makeFirefoxData()
	{
		return new ActionData(new FirefoxDriver());
	}
	
	/**
	 * 
	 * @return
	 */
	private ActionData makeHTMLDriverData()
	{
		return new ActionData(new HtmlUnitDriver());
	}
}
