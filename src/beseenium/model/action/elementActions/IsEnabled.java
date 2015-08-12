package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;
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
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ActionException 
	{
		List<WebElement> elements = super.context.getElement();			
		String result ="";
		
		if(n==-1)
		{
			for(int element = 0; element < elements.size(); ++element)
			{result += String.valueOf(elements.get(element).isEnabled())+" , ";}
			return result;
		}
		else
		{
			try
			{return String.valueOf(elements.get(n).isEnabled());}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
