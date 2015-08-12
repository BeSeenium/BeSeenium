package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a getAttribute action, it takes the input parameter from the ActionData object
 * to perform this action so make sure that at the time of execution this reflects the attribute
 * you wish to find the value of i.e. "href" , "class" , "id" , etc.
 * @author JPC Hanson
 *
 */
public class GetAttribute extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetAttribute(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a getAttribute action.
	 * @param n the index of the element to get an attribute of (as taken from the ActionData)
	 * @return String containing the value of the attribute set in the input parameter
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
			{result += elements.get(element).getAttribute(super.context.getInputParam())+" , ";}
			return result;
		}
		else
		{
			try
			{return elements.get(n).getAttribute(super.context.getInputParam());}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}