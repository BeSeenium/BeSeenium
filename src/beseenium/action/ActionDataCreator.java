package beseenium.action;

import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.actionData.ActionData;

/**
 * This class is contains static methods for creating ActionData instances specific
 * to various browser types.
 * @author JPC Hanson
 *
 */
public class ActionDataCreator 
{
	/**
	 * create an ActionData instance for passing to the ActionController.add
	 * @return ActionData containing a no WebDriver
	 */
	public static ActionData createDefaultActionData()
	{
		return new ActionData();
	}
	
	/**
	 * create an ActionData instance for performing actions using the 
	 * firefox browser
	 * @return ActionData containing a FirefoxDriver
	 */
	public static ActionData createFirefoxActionData()
	{
		return new ActionData(new FirefoxDriver());
	}
}
