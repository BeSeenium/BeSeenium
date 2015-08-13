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
package beseenium.model.action.navigateActions;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a navigate forward action, it attempts to use the back/foward history
 * to navigate forward a specified number of times.
 * @author JPC Hanson
 *
 */
public class NavigateForward extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public NavigateForward(ActionData context) 
	{super(context);}
	
	/**
	 * @param n the number of times to navigate forward
	 * @return String verifying the number of times forward navigation has occurred
	 * and the resultant URL.
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		int count;
		String oldURL, newURL="";
		for(count = 0; count < n; ++count)
		{
			oldURL = super.context.getDriver().getCurrentUrl();
			super.context.getDriver().navigate().forward();	
			newURL = super.context.getDriver().getCurrentUrl();
			
			if(oldURL.equals(newURL))
				{
					return "could only navigate forward "+count+" times"
							+ "\n - final URL:" + newURL;
				}
		}
		return "navigated forward " + n + " times, final URL:\n - "
				+ newURL;
	}
}
