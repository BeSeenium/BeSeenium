package beseenium.model.action.elementActions;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.SubmitException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This will submit a form if the element in question is a form or a form element
 * @author JPC Hanson
 *
 */
public class Submit extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public Submit(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a clear action.
	 * @param n the index of the element to clear (as taken from the ActionData)
	 * @return String verifying clear action
	 * @throws ActionDataException
	 * @throws SubmitException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, SubmitException 
	{
		List<WebElement> elements = super.context.getElement();
		String tag = elements.get(n).getTagName();
		String id = elements.get(n).getAttribute("id");
		String text = elements.get(n).getText();
		String classOf = elements.get(n).getText();
		
		try
		{
			elements.get(n).submit();
		}
		catch (NoSuchElementException e)
		{
			throw new SubmitException("the element is not a form");
		}
		
		return "<"+tag+" class='"+classOf+ "' href='"+id+"'>"
				+text +"</"+tag+">"+"-------submitted";
	}
}
