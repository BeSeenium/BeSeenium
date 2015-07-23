package beseenium.action.switchActions;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;

/**
 * this is a SwitchToActiveElement, it Switches to the element that currently 
 * has focus within the document currently "switched to", or the body element
 *  if this cannot be detected.
 * @author JPC Hanson
 *
 */
public class SwitchToActiveElement extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public SwitchToActiveElement(ActionData context) 
	{super(context);}
	
	/**
	 * Executes the switch to the currently active element.
	 * @param n meaningless variable 
	 * @return String confirming the element that has been switched to 
	 */
	@Override
	public String execute(int n) throws ActionDataException
	{
		super.getActionData().getElement().clear();
		super.getActionData().getElement().add
				(
						super.getActionData().getDriver()
						.switchTo().activeElement()
				);
		return "switched to: " + super.getActionData().getDriver().switchTo().activeElement().getTagName();
	}
}
