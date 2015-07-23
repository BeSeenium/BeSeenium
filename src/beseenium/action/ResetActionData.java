package beseenium.action;

import beseenium.actionData.ActionData;
import beseenium.exceptions.NoSuchParameterException;

public class ResetActionData extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public ResetActionData(ActionData context) 
	{super(context);}
	
	/**
	 * @param n ,0=reset WebElement, 1=reset inputParam, 2=reset outputParam, -1=reset all
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
		
		case 2:
			super.context.setOutputParam(null);
		break;
		
		default:
			throw new NoSuchParameterException("number must be twixt -1 and 2");
		
		}
		return "element stored in ActionData set to 'NULL'";	
	}
}
