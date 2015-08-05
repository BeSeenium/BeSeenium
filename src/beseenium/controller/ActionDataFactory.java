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
	/**  **/
	private  DesiredCapabilities capabilities;
	
	private  String URL;
	
	/**
	 * default constructor, initialises internal map and populates it
	 * @throws MalformedURLException 
	 */
	public ActionDataFactory() throws MalformedURLException
	{
		
		this.ActionDataMap = new HashMap<String, Method>();
		try 
		{
			mapEntries();
		} 
		catch (NoSuchMethodException | SecurityException e) 
		{
			e.printStackTrace();
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
			capabilities.setCapability(key, value);
		}
		
		else
		{URL = "http://" + value + "@hub.browserstack.com/wd/hub";}
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
		Class cls = ActionDataFactory.class;
		Object obj;
		try {
				obj = cls.newInstance();
				if(ActionDataMap.containsKey(ActionDataKey))
				{return (ActionData) ActionDataMap.get(ActionDataKey).invoke(obj);}
			} 
		
		catch (InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException e) 
		{
			throw new ActionDataFactoryException("you cannot instanciate this type of ActionData"
					+ "	Check your spelling, or refer to documentation" + e.getCause());
		}
		
			throw new ActionDataFactoryException("you cannot instanciate this type of ActionData"
					+ "	Check your spelling, or refer to documentation");
	}
	
	
	
	
	/**
	 * add appropriate entries to the factoryMap.
	 * @throws MalformedURLException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private void mapEntries() throws MalformedURLException, NoSuchMethodException, SecurityException
	{
		//for use internally within the ActionController
		ActionDataMap.put("internal", ActionDataFactory.class.getDeclaredMethod("makeEmptyData"));
		
		//for public use
		//ActionDataMap.put("firefox", new ActionData( new FirefoxDriver() ));
		ActionDataMap.put("firefox", ActionDataFactory.class.getDeclaredMethod("makeFirefoxData"));
		//ActionDataMap.put("chrome", new ActionData( new ChromeDriver() ));
//		ActionDataMap.put("noWindows", new ActionData(new HtmlUnitDriver() ));
		//ActionDataMap.put("remote", new ActionData(new RemoteWebDriver(new URL(URL), capabilities )));
	}
	
	/**
	 * 
	 * @return
	 */
	private ActionData makeEmptyData()
	{
		return new ActionData();
	}
	
	/**
	 * 
	 * @return
	 */
	private ActionData makeFirefoxData()
	{
		return new ActionData(new FirefoxDriver());
	}
}
