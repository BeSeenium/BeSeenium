package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a GetTagName Action, it retrieves the tag name of the web element selected.
 * @author JPC Hanson
 *
 */
public class GetTagName extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetTagName(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetTagName action.
	 * @param n the index of the element to get the tag name of (as taken from the ActionData)
	 * @return String containing the tag name of the WebElement[n] contained in the ActionData.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		return elements.get(n).getTagName();
	}
}
