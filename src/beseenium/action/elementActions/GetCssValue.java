package beseenium.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exception.ActionDataException;
import beseenium.exception.ActionException;

/**
 * this is a Get CSS Action, it retrieves the value of a specific CSS property. The
 * property that you wish to find is defined in the ActionData object, so make sure that
 * you set this to reflect the CSS property you wish to find the value of before passing it
 * to this action.
 * @author JPC Hanson
 *
 */
public class GetCssValue extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetCssValue(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetCss action.
	 * @param n the index of the element to get a CSS value of (as taken from the ActionData)
	 * @return String containing the value of the CSS value set in the input parameter
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		return elements.get(n).getCssValue(super.context.getInputParam());
	}
}
