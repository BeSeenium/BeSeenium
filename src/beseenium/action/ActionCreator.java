package beseenium.action;

import beseenium.action.pageActions.*;

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
