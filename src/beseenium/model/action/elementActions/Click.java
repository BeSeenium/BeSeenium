package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ClickException;
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
	 * @throws ClickException 
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException, ClickException 
	{
		List<WebElement> elements = super.context.getElement();
		String tag = elements.get(n).getTagName();
		String href = elements.get(n).getAttribute("href");
		String text = elements.get(n).getText();
		String classOf = elements.get(n).getText();
		
		try
		{
			elements.get(n).click();
		}
		catch (StaleElementReferenceException e2)
		{
			throw new ClickException("the element is stale");
		}
		catch (IndexOutOfBoundsException e2)
		{
			throw new ActionDataException("there is no such element in the list");
		}
		
		return "<"+tag+" class='"+classOf+ "' href='"+href+"'>"
				+text +"</"+tag+">"+"-------clicked";
	}
}
