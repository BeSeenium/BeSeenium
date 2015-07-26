package beseenium.model.action.pageActions;

import beseenium.exceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a Close Action, it essentially closes the bowser.
 * @author JPC Hanson
 *
 */
public class BrowserQuit extends AbstractAction 
{

		/**
		 * constructor, initialises Action using the ActionData passed in as a param
		 * @param context an ActionData
		 */
		public BrowserQuit(ActionData context) 
		{super(context);}
		
		/**
		 * This performs a quit browser.
		 * @param n meaningless pass in any old value
		 * @return String verifying the action
		 * @throws ActionDataException
		 */
		@Override
		public String execute(int n) throws ActionDataException 
		{
			super.context.getDriver().quit();
			return "Quitting...";
		}
}
