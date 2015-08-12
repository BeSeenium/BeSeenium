package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is an IsSelected Action, checks to see whether the element currently held
 * in the ActionData is currently selected or not
 * @author JPC Hanson
 *
 */
public class IsSelected extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public IsSelected(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a IsSelected action.
	 * @param n the index of the element to check if is selected (as taken from the ActionData)
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
			{result += String.valueOf(elements.get(element).isSelected())+" , ";}
			return result;
		}
		else
		{
			try
			{return String.valueOf(elements.get(n).isSelected());}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
