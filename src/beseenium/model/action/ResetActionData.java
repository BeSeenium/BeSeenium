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
package beseenium.model.action;

import beseenium.exceptions.actionExceptions.NoSuchParameterException;
import beseenium.model.actionData.ActionData;

/**
 * this resets various attributes of the ActionData
 *
 * @author Jan P.C. Hanson
 *
 */
public class ResetActionData extends AbstractAction
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public ResetActionData(ActionData context) 
	{super(context);}
	
	/**
	 * performs the reset action data action.
	 * @param n ,0=reset WebElement, 1=reset inputParam, -1=reset all
	 * @throws NoSuchParameterException 
	 */
	public String execute(int n) throws NoSuchParameterException
	{
		switch(n)
		{
		case 0:
			super.context.setElement(null);
		break;
		
		case 1:
			super.context.setInputParam(null);
		break;
		
		default:
			throw new NoSuchParameterException("number must be twixt -1 and 2");
		
		}
		return "element stored in ActionData set to 'NULL'";	
	}
}
