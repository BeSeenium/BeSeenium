package beseenium.controller;

import java.net.MalformedURLException;
import java.util.List;

import beseenium.controller.*;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.model.actionData.ActionData;

public class ActionController 
{
	/**  **/
	private ActionFactory actionFactory;
	/**  **/
	private ActionDataFactory actionDataFactory;	
	/**  **/
	private ActionInvoker invoker;
	
	/**
	 * 
	 * @throws ActionDataFactoryException
	 * @throws MalformedURLException
	 */
	public ActionController() throws ActionDataFactoryException, MalformedURLException
	{
		actionDataFactory = new ActionDataFactory();
		actionFactory = new ActionFactory();
	}
	
	/**
	 * 
	 * @param BrowserDriver
	 * @throws ActionDataException
	 */
	public void setBrowser(String BrowserDriver) throws ActionDataException
	{
		ActionData actionData = ActionDataFactory.makeActionData("firefox");	
		invoker = new ActionInvoker(actionData);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void configureRemoteDriver(String key, String value)
	{
		ActionDataFactory.setCapabilities(key, value);
	}
	
	/**
	 * 
	 * @param actionName
	 * @param inputParameter
	 * @param optionalIndex
	 * @throws ActionFactoryException
	 */
	public void addAction(String actionName, String inputParameter, int optionalIndex) 
			throws ActionFactoryException
	{
		invoker.add(ActionFactory.makeAction(actionName), inputParameter, optionalIndex);
	}
	
	/**
	 * 
	 * @param actionToRemove
	 */
	public void removeAction(int actionToRemove)
	{
		invoker.remove(actionToRemove);
	}
	
	/**
	 * 
	 * @return
	 * @throws ActionDataException
	 * @throws ActionException
	 */
	public List<String> executeActions() throws ActionDataException, ActionException
	{
		return invoker.execute();
	}
	
	/**
	 * 
	 * @throws ActionDataException
	 * @throws ActionException
	 */
	public void emergencyShutdown() throws ActionDataException, ActionException
	{
		for(int i = 0; i < invoker.size(); ++i)
		{
			invoker.remove(i);
		}
		invoker.add(ActionFactory.makeAction("BrowserQuit"), "", 0);
		invoker.execute();
	}
}
