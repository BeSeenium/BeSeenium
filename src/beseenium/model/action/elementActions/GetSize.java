package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a GetSize Action, It retrieves the size of the WebElement currently
 * stored in the ActionData.
 * @author JPC Hanson
 *
 */
public class GetSize extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetSize(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetSize action.
	 * @param n the index of the element to get the size of (as taken from the ActionData)
	 * @return String containing the size of the WebElement[n] contained in the ActionData.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		return elements.get(n).getSize().toString();
	}
}
