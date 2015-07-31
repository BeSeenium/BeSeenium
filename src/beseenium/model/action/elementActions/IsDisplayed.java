package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is an IsDisplayed Action, checks to see whether the element currently held
 * in the ActionData is currently displayed or not
 * @author JPC Hanson
 *
 */
public class IsDisplayed extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public IsDisplayed(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a IsDisplayed action.
	 * @param n the index of the element to check if is displayed (as taken from the ActionData)
	 * @return String containing true or false depending on the outcome of the check.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		if(elements.get(n).isDisplayed()==true)
		{return "true";}
		else
		{return "false";}
	}
}
