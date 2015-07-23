package beseenium.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
/**
 * This is an IsEnabled Action, checks to see whether the element currently held
 * in the ActionData is currently enabled or not
 * @author JPC Hanson
 *
 */
public class IsEnabled extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public IsEnabled(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a IsEnabled action.
	 * @param n the index of the element to check if is enabled (as taken from the ActionData)
	 * @return String containing true or false depending on the outcome of the check.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();			
		
		if(elements.get(n).isEnabled()==true)
		{return "true";}
		else
		{return "false";}
	}
}
