package beseenium.model.action.navigateActions;
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
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * this is a refresh page action, it (surprise surprise) refreshes the page.
 *
 * @author Jan P.C. Hanson
 *
 */
public class RefreshPage extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public RefreshPage(ActionData context) 
	{super(context);}
	
	/**
	 * performs the refresh action.
	 * @param n the number of times to navigate forward
	 * @return String verifying the number of times forward navigation has occurred
	 * and the resultant URL.
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		for(int count = 0; count < n; ++count)
		{
			super.context.getDriver().navigate().refresh();;	
		}
		return "page refreshed " + n + " times";
	}
}
