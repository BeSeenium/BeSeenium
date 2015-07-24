package beseenium.controller;

import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.actionData.ActionData;

/**
 * This class is contains static methods for creating ActionData instances specific
 * to various browser types.
 * @author JPC Hanson
 * \todo change to factory method map implementation
 */
public class ActionDataCreator 
{
	/**
	 * create an ActionData instance for passing to the ActionController.add()
	 * generally only used by the ActionCreator class.
	 * @return ActionData containing no WebDriver
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
