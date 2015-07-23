package beseenium.action.navigateActions;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;

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
