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
package beseenium.model.action.findElementsBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;
import beseenium.model.helpers.FormatOutput;

public class FindElementsByTagName extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public FindElementsByTagName(ActionData context) 
	{super(context);}

	/**
	 * @param n the index of the element to find information on, i.e. if 3 results are found
	 * the 0 will be the first element 1 the second and so on. will get an array out of bounds.
	 * If you wish the action to return all of the results found then set n = -1.
	 * @return String representation of the returnParam set in the ActionData object
	 * passed into the constructor.
	 * @throws ActionDataException  
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		String searchParam = super.context.getInputParam();
		WebDriver browser = super.context.getDriver();
		List<WebElement> htmlElements = browser.findElements(By.tagName(searchParam));
		
		super.context.setElement(htmlElements);
		
		return FormatOutput.formatFindElementOutput(htmlElements, n);	
	}
}
