package beseenium.controller;

import java.net.MalformedURLException;
import java.util.List;

import beseenium.controller.*;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.model.actionData.ActionData;

public class Test 
{
	/**  **/
	private ActionFactory actionFactory;
	/**  **/
	private ActionDataFactory actionDataFactory;	
	/**  **/
	private ActionInvoker invoker;
	
	/**
	 * constructs the Test object
	 * @throws ActionDataFactoryException
	 * @throws MalformedURLException
	 */
	public Test() throws ActionDataFactoryException, MalformedURLException
	{
		actionDataFactory = new ActionDataFactory();
		actionFactory = new ActionFactory(actionDataFactory);
	}
	
	/**
	 * Set the browser that you want this test to run on
	 * @param BrowserDriver
	 * @throws ActionDataException
	 */
	public void setBrowser(String BrowserDriver) throws ActionDataException
	{
		ActionData actionData = actionDataFactory.makeActionData("firefox");	
		invoker = new ActionInvoker(actionData);
	}
	
	/**
	 * When using a 'remote' Driver set a capability of the driver i.e. key='os' value='windows'
	 * @param key
	 * @param value
	 */
	public void configureRemoteDriver(String key, String value)
	{
		actionDataFactory.setCapabilities(key, value);
	}
	
	/**
	 * Add an action to this test
	 * @param actionName the name of the Action to add
	 * @param inputParameter the input parameter (if applicable) of the action to add
	 * @param optionalIndex an optional index (if applicable) to specify the element that
	 * this action will be performed on(assuming one of the previous actions was a FindElement
	 * action)
	 * @throws ActionFactoryException
	 */
	public void addAction(String actionName, String inputParameter, int optionalIndex) 
			throws ActionFactoryException
	{
		invoker.add(actionFactory.makeAction(actionName), inputParameter, optionalIndex);
	}
	
	/**
	 * remove an action from this test.
	 * @param actionToRemove the index of the action to be removed from the test
	 */
	public void removeAction(int actionToRemove)
	{
		invoker.remove(actionToRemove);
	}
	
	/**
	 * executes all actions in this test, in the sequence they were added
	 * @return List<String> containing the results of each action
	 * @throws ActionDataException
	 * @throws ActionException
	 */
	public List<String> executeActions() throws ActionDataException, ActionException
	{
		return invoker.execute();
	}
	
	/**
	 * remove all actions from this test and close the browser instance associated with it.
	 * @throws ActionDataException
	 * @throws ActionException
	 */
	public void emergencyShutdown() throws ActionDataException, ActionException
	{
		for(int i = 0; i < invoker.size(); ++i)
		{
			invoker.remove(i);
		}
		invoker.add(actionFactory.makeAction("BrowserQuit"), "", 0);
		invoker.execute();
	}
}
