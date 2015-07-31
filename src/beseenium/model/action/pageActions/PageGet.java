package beseenium.model.action.pageActions;

import org.openqa.selenium.WebDriverException;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * this is a page get action, it navigates to a page set in the input parameter of 
 * the ActionData object. It is possible to reload a page a number of times in succession
 * (could be useful for stress/load testing)
 * @author JPC Hanson
 *
 */
public class PageGet extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public PageGet(ActionData context) 
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
		try 
		{
			String inputParam = super.context.getInputParam();
			super.context.getDriver().get(inputParam);	
			return "navigating to " + inputParam;
		}
		
		catch (WebDriverException e)
		{
			throw new ActionDataException("cannot open webPage \n" + e.getCause());
		}
	}
}
