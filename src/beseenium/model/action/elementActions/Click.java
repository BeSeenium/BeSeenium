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

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.actionExceptions.ClickException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a click action, 
 * @author JPC Hanson
 *
 */
public class Click extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public Click(ActionData context) 
	{super(context);}
	
	/**
	 * This performs the click action.
	 * @param n the index of the element to click on (as taken from the ActionData)
	 * @return String verifying success of click action
	 * @throws ActionDataException
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ClickException 
	{
		List<WebElement> elements = super.context.getElement();
		
		try
		{
			if(n==-1)
			{
				for(int element = 0; element < elements.size(); ++element)
				{elements.get(element).click();}
				return " all provided elements clicked ";
			}
			else
			{
				elements.get(n).click();
				return "element " + n + " clicked";		
			}
		}
		catch (StaleElementReferenceException e2)
		{
			throw new ClickException("the element is stale");
		}
		catch (IndexOutOfBoundsException e2)
		{
			throw new ActionDataException(this.toString()+": you provided an invalid index");
		}
	}
}
