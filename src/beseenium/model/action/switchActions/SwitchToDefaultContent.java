package beseenium.model.action.switchActions;

import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

public class SwitchToDefaultContent extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public SwitchToDefaultContent(ActionData context) 
	{super(context);}
	
	/**
	 * Executes the switch to the currently active element.
	 * @param n meaningless variable 
	 * @return String confirming the element that has been switched to 
	 */
	@Override
	public String execute(int n) throws ActionDataException
	{
		super.context.setDriver(super.context.getDriver().switchTo().defaultContent());
		return "switched to: "+ super.context.getDriver().toString();
	}
}
