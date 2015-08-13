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

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;
/**
 * This is a GetURL Action, it retrieves the URL of the current page
 * @author JPC Hanson
 *
 */
public class GetURL extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetURL(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetURL action.
	 * @param n meaningless pass in any old value
	 * @return String containing the URL of the current page
	 * @throws ActionDataException
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{	
		return super.context.getDriver().getCurrentUrl();
	}
}
