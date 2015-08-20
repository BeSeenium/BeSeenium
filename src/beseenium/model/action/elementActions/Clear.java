/** Copyright(C) 2015 Jan P.C. Hanson & BeSeen Marketing Ltd
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package beseenium.model.action.elementActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This represents a clear action, it will have no effect unless the element that
 * this action is performed on is a text entry element, i.e. input or textArea.
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
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ActionException 
	{
		List<WebElement> elements = super.context.getElement();
				
		if(n==-1)
		{
			for(int element = 0; element < elements.size(); ++element)
			{elements.get(element).clear();}
			return " all provided elements cleared ";
		}
		else
		{
			try
			{
				elements.get(n).clear();
				return "element " + n + " cleared";
			}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
