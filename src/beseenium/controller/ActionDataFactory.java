package beseenium.controller;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataFactoryException;

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
			{throw new ActionDataFactoryException();}
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
	}
}
