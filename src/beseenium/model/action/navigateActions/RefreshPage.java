package beseenium.model.action.navigateActions;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

public class RefreshPage extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public RefreshPage(ActionData context) 
	{super(context);}
	
	/**
	 * @param n the number of times to navigate forward
	 * @return String verifying the number of times forward navigation has occurred
	 * and the resultant URL.
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		for(int count = 0; count < n; ++count)
		{
			super.context.getDriver().navigate().refresh();;	
		}
		return "page refreshed " + n + " times";
	}
}
