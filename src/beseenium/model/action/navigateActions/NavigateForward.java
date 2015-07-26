package beseenium.model.action.navigateActions;

import beseenium.exceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a navigate forward action, it attempts to use the back/foward history
 * to navigate forward a specified number of times.
 * @author JPC Hanson
 *
 */
public class NavigateForward extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public NavigateForward(ActionData context) 
	{super(context);}
	
	/**
	 * @param n the number of times to navigate forward
	 * @return String verifying the number of times forward navigation has occurred
	 * and the resultant URL.
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		int count;
		String oldURL, newURL="";
		for(count = 0; count < n; ++count)
		{
			oldURL = super.context.getDriver().getCurrentUrl();
			super.context.getDriver().navigate().forward();	
			newURL = super.context.getDriver().getCurrentUrl();
			
			if(oldURL.equals(newURL))
				{
					return "could only navigate forward "+count+" times"
							+ "\n - final URL:" + newURL;
				}
		}
		return "navigated forward " + n + " times, final URL:\n - "
				+ newURL;
	}
}
