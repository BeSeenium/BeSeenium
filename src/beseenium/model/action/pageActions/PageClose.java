package beseenium.model.action.pageActions;

import beseenium.exceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;
/**
 * This is a Close Action, it essentially closes the current tab, if it is the last
 * or only tab open it also closes the browser.
 * @author JPC Hanson
 *
 */
public class PageClose extends AbstractAction 
{

		/**
		 * constructor, initialises Action using the ActionData passed in as a param
		 * @param context an ActionData
		 */
		public PageClose(ActionData context) 
		{super(context);}
		
		/**
		 * This performs a Close tab action.
		 * @param n meaningless pass in any old value
		 * @return String verifying the action
		 * @throws ActionDataException
		 */
		@Override
		public String execute(int n) throws ActionDataException 
		{
			super.context.getDriver().close();
			return "closing...";
		}
}
