package beseenium.controller;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import beseenium.exceptions.ActionDataFactoryException;
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
	private static Map<String, ActionData> ActionDataMap;
	/**  **/
	private static final String USERNAME = "jonjackson";
	private static final String BSKEY = "WDaudZN5Y1eTGPUUozty";
	private static final String URL = "http://" + USERNAME + ":" + BSKEY + "@hub.browserstack.com/wd/hub";
	
	/**
	 * default constructor, initialises internal map and populates it
	 */
	public ActionDataFactory()
	{
		ActionDataFactory.ActionDataMap = new HashMap<String, ActionData>();
		mapEntries();
	}
	
	
	
	/**
	 * make a specific actionData containing a specific WebDriver.
	 * @param ActionDataKey the type of ActionData you wish to specify.
	 * @return ActionData containing no WebDriver
	 * @throws ActionDataFactoryException 
	 */
	public static ActionData makeActionData(String ActionDataKey) throws ActionDataFactoryException
	{
		if(ActionDataMap.containsKey(ActionDataKey))
			{return ActionDataMap.get(ActionDataKey);}
		else
			{throw new ActionDataFactoryException("you cannot instanciate this type of ActionData"
					+ "	Check your spelling, or refer to documentation");}
	}
	
	
	
	
	
	/**
	 * add appropriate entries to the factoryMap.
	 */
	private void mapEntries()
	{
		//for use internally within the ActionController
		ActionDataMap.put("internal", new ActionData());
		
		//for public use
		ActionDataMap.put("firefox", new ActionData( new FirefoxDriver() ));
		//ActionDataMap.put("chrome", new ActionData( new ChromeDriver() ));
		ActionDataMap.put("noWindows", new ActionData(new HtmlUnitDriver() ));
		//ActionDataMap.put("remote", new ActionData(new RemoteWebDriver() ));
	}
}
