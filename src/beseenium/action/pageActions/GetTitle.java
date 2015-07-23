package beseenium.action.pageActions;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;

/**
 * 
 * @author JPC Hanson
 *
 */
public class GetTitle extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetTitle(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a PageGet action.
	 * @param n number of times to re-load the page.
	 * @return String verifying the page to navigate to.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		return super.context.getDriver().getTitle();
	}
}
