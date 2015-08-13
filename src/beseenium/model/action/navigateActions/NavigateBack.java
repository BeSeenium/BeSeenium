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
 * This is a navigate back action, it attempts to use the back/forward history to 
 * navigate back a specified number of times.
 * @author JPC Hanson
 *
 */
public class NavigateBack extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public NavigateBack(ActionData context) 
	{super(context);}
	
	/**
	 * @param n the number of times to navigate back
	 * @return String verifying the number of times back navigation has occurred
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
			super.context.getDriver().navigate().back();	
			newURL = super.context.getDriver().getCurrentUrl();
			
			if(oldURL.equals(newURL))
				{
					return "could only navigate back "+count+" times"
							+ "\n - final URL:" + newURL;
				}
		}
		return "navigated back " + n + " times, final URL:\n - "
				+ newURL;
	}

}
