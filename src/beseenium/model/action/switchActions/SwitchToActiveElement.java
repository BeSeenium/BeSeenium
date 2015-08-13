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
package beseenium.model.action.switchActions;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * this is a SwitchToActiveElement, it Switches to the element that currently 
 * has focus within the document currently "switched to", or the body element
 *  if this cannot be detected.
 * @author JPC Hanson
 *
 */
public class SwitchToActiveElement extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public SwitchToActiveElement(ActionData context) 
	{super(context);}
	
	/**
	 * Executes the switch to the currently active element.
	 * @param n meaningless variable 
	 * @return String confirming the element that has been switched to 
	 */
	@Override
	public String execute(int n) throws ActionDataException
	{
		super.getActionData().getElement().clear();
		super.getActionData().getElement().add
				(
						super.getActionData().getDriver()
						.switchTo().activeElement()
				);
		return "switched to: " + super.getActionData().getDriver().switchTo().activeElement().getTagName();
	}
}
