package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ClickException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a click action, 
 * @author JPC Hanson
 *
 */
public class Click extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public Click(ActionData context) 
	{super(context);}
	
	/**
	 * This performs the click action.
	 * @param n the index of the element to click on (as taken from the ActionData)
	 * @return String verifying success of click action
	 * @throws ActionDataException
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ClickException 
	{
		List<WebElement> elements = super.context.getElement();
		
		try
		{
			if(n==-1)
			{
				for(int element = 0; element < elements.size(); ++element)
				{elements.get(element).click();}
				return " all provided elements clicked ";
			}
			else
			{
				elements.get(n).click();
				return "element " + n + " clicked";		
			}
		}
		catch (StaleElementReferenceException e2)
		{
			throw new ClickException("the element is stale");
		}
		catch (IndexOutOfBoundsException e2)
		{
			throw new ActionDataException(this.toString()+": you provided an invalid index");
		}
	}
}
