package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This represents a click action, it will have no effect unless the element that
 * this action is performed on is a text entry element, i.e. <input> or <textArea>.
 * If it is one of these elements it will clear the value currently held in them.<br><br>
 * nb// does not fire any mouse or keyboard events
 * @author JPC Hanson
 *
 */
public class Clear extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public Clear(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a clear action.
	 * @param n the index of the element to clear (as taken from the ActionData)
	 * @return String verifying clear action
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		List<WebElement> elements = super.context.getElement();
		String tag = elements.get(n).getTagName();
		String href = elements.get(n).getAttribute("href");
		String text = elements.get(n).getText();
		String classOf = elements.get(n).getText();
		
		
		elements.get(n).clear();	
		
		return "<"+tag+" class='"+classOf+ "' href='"+href+"'>"
				+text +"</"+tag+">"+"-------cleared";
	}
}
