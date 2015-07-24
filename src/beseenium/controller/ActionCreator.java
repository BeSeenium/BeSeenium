package beseenium.controller;

import beseenium.action.AbstractAction;
import beseenium.action.pageActions.*;

/**
 * 
 * @author JPC Hanson
 *\todo change to factory method map implementation
 */
public class ActionCreator 
{

	/**
	 * creates a PageGet Action
	 * @return PageGet Action
	 */
	public static AbstractAction createPageGetAction()
	{
		return new PageGet(ActionDataCreator.createDefaultActionData());
	}
	
}
