package beseenium.action.pageAction;


import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exception.ActionDataException;

/**
 * this is a get page source action, it retrieves the source code of the page
 * that you are currently on.
 * @author JPC Hanson
 *
 */
public class GetPageSrc extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetPageSrc(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetPageSrc action.
	 * @param n meaningless pass in any old value
	 * @return String containing the source code of the current page
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		return super.context.getDriver().getPageSource();
	}
}
