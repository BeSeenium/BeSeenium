package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a sendKeys Action, it simulates a human typing into an element, which 
 * may set its value. Make sure to change the <strong>input parameter</strong>
 * to the value that you wish to enter into the element.
 * @author JPC Hanson
 *
 */
public class SendKeys extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public SendKeys(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a sendKeys action.
	 * @param n the index of the element to send the keys to (as taken from the ActionData)
	 * @return String verifying SendKeys action
	 * @throws ActionDataException
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ActionException 
	{
		List<WebElement> elements = super.context.getElement();
		
		if(n==-1)
		{
			for(int element = 0; element < elements.size(); ++element)
			{elements.get(n).sendKeys(super.context.getInputParam());}
			return "all elements populated with: '" +
			super.context.getInputParam()+"'";
		}
		else
		{
			try
			{
				elements.get(n).sendKeys(super.context.getInputParam());
				return "element-"+n+" populated with: '" +
				super.context.getInputParam()+"'";
			}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
