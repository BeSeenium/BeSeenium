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

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.actionData.ActionData;

/**
 * this is the root class for all derived Actions 
 * @author JPC Hanson
 * \todo change CTOR's to setActionData(WebDriver driver, ) methods
 */
public abstract class AbstractAction 
{
	/** reference to the ActionData object that a derived Action is constructed with **/
	protected ActionData context;
	
	/**
	 * constructor, initialises derived object using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	protected AbstractAction(ActionData context)
	{this.context = context;}
	
	/**
	 * get the ActionData object stored in the derived Action
	 * @return The ActionData that this Action operates on
	 */
	public ActionData getActionData()
	{return this.context;}
	
	public void setActionData(ActionData actionData)
	{this.context = actionData;}
	
	/**
	 * execute the derived Action in question, 
	 * @param n the index of the element to find information on, i.e. if 3 results are found
	 * the 0 will be the first element 1 the second and so on. will get an IndexOutOfBounds
	 * type exception if you provide a number higher than the number of elements returned.
	 * @return String representation of the output of the derived Action.
	 * @throws ActionDataException 
	 */
	public abstract String execute(int n) throws ActionDataException, ActionException;
}
