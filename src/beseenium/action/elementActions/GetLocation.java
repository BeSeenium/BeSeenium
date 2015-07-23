package beseenium.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;

/**
 * This is a GetLocation Action, It retrieves the location of the top left corner of the 
 * element currently stored in the ActionData object.
 * @author JPC Hanson
 *
 */
public class GetLocation extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetLocation(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetLocation action.
	 * @param n the index of the element to get the location of (as taken from the ActionData)
	 * @return String containing the location of the WebElement[n] contained in the ActionData.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		return elements.get(n).getLocation().toString();
	}
}
