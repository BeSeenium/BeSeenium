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
package beseenium.model.action.pageActions;

import org.openqa.selenium.WebDriverException;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * this is a page get action, it navigates to a page set in the input parameter of 
 * the ActionData object. It is possible to reload a page a number of times in succession
 * (could be useful for stress/load testing)
 * @author JPC Hanson
 *
 */
public class PageGet extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public PageGet(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a PageGet action.
	 * @param n number of times to re-load the page.
	 * @return String verifying the page to navigate to.
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		try 
		{
			String inputParam = super.context.getInputParam();
			super.context.getDriver().get(inputParam);	
			return "navigating to " + inputParam;
		}
		
		catch (WebDriverException e)
		{
			throw new ActionDataException("cannot open webPage \n" + e.getCause());
		}
	}
}
