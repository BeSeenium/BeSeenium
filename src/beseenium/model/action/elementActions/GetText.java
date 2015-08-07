package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;
/**
 * This is a GetText action, it returns the inner html of the current WebElement 
 * (and any child nodes) not including any text hidden by css. 
 * @author JPC Hanson
 *
 */
public class GetText extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetText(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetText action.
	 * @param n the index of the element to get the text of (as taken from the ActionData)
	 * @return String containing the text of the WebElement[n] contained in the ActionData.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		return elements.get(n).getText();
	}
}
