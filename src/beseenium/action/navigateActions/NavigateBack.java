package beseenium.action.navigateActions;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;
/**
 * This is a navigate back action, it attempts to use the back/forward history to 
 * navigate back a specified number of times.
 * @author JPC Hanson
 *
 */
public class NavigateBack extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public NavigateBack(ActionData context) 
	{super(context);}
	
	/**
	 * @param n the number of times to navigate back
	 * @return String verifying the number of times back navigation has occurred
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
			super.context.getDriver().navigate().back();	
			newURL = super.context.getDriver().getCurrentUrl();
			
			if(oldURL.equals(newURL))
				{
					return "could only navigate back "+count+" times"
							+ "\n - final URL:" + newURL;
				}
		}
		return "navigated back " + n + " times, final URL:\n - "
				+ newURL;
	}

}
