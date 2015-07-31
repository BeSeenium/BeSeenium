package beseenium.model.action;

import beseenium.exceptions.actionExceptions.NoSuchParameterException;
import beseenium.model.actionData.ActionData;

public class ResetActionData extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public ResetActionData(ActionData context) 
	{super(context);}
	
	/**
	 * @param n ,0=reset WebElement, 1=reset inputParam, -1=reset all
	 * @throws NoSuchParameterException 
	 */
	public String execute(int n) throws NoSuchParameterException
	{
		switch(n)
		{
		case 0:
			super.context.setElement(null);
		break;
		
		case 1:
			super.context.setInputParam(null);
		break;
		
		default:
			throw new NoSuchParameterException("number must be twixt -1 and 2");
		
		}
		return "element stored in ActionData set to 'NULL'";	
	}
}
