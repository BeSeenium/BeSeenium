package beseenium.controller;

import java.util.HashMap;
import java.util.Map;

import beseenium.action.AbstractAction;
import beseenium.action.pageActions.*;
import beseenium.exceptions.ActionDataFactoryException;

/**
 * 
 * @author JPC Hanson
 *\todo change to factory method map implementation
 */
public class ActionFactory 
{
	/**  **/
	private static Map<String, AbstractAction> actionMap;
	/**  **/
	private static final String internal = "internal";

	/**
	 * @throws ActionDataFactoryException 
	 * 
	 */
	public ActionFactory() throws ActionDataFactoryException
	{
		@SuppressWarnings("unused")
		ActionDataFactory actionDataFactory = new ActionDataFactory();
		ActionFactory.actionMap = new HashMap<String, AbstractAction>();
		populateActionMap();
	}
	
	/**
	 * creates an Action
	 * @return  AbstractAction
	 * @throws ActionDataFactoryException 
	 */
	public static AbstractAction makeAction(String action)
	{
		return actionMap.get(action);
	}
	
	/**
	 * @throws ActionDataFactoryException 
	 * 
	 */
	private void populateActionMap() throws ActionDataFactoryException
	{
		actionMap.put( "PageGet", new PageGet(ActionDataFactory.makeActionData(internal)));
	}
}
