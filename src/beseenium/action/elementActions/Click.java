package beseenium.action.elementActions;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exception.ActionDataException;
import beseenium.exception.ClickException;

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
	 * This performs the click action. After successfully completing the action it
	 * also sets the List of WebElements in the ActionData object to null, to avoid
	 * attempting to click the same link twice in a row, as the second time the page
	 * would have changed and there may not be an identical element to click on.
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
			super.context.setElement(null);
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
