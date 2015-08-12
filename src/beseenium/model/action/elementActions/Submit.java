package beseenium.model.action.elementActions;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.SubmitException;
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
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ActionException 
	{
		List<WebElement> elements = super.context.getElement();
		
		try
		{	
			if(n==-1)
			{
				for(int element = 0; element < elements.size(); ++element)
				{elements.get(element).submit();}
				return " all elements submited. ";
			}
			else
			{
				try
				{
					elements.get(n).submit();
					return "element-"+n+" submitted.";
				}
			
				catch (IndexOutOfBoundsException e)
				{throw new ActionException(this.toString()+": you provided an invalid index");}
			}
		}
		catch (NoSuchElementException e)
		{
			throw new SubmitException("the element is not a form");
		}
	}
}
