package beseenium.model.action.switchActions;
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
 * represents a SwitchToDefaultContent action which Selects either the 
 * first frame on the page, or the main document when a page contains iframes.
 *
 * @author Jan P.C. Hanson
 *
 */
public class SwitchToDefaultContent extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public SwitchToDefaultContent(ActionData context) 
	{super(context);}
	
	/**
	 * Executes the switch to the currently active element.
	 * @param n meaningless variable 
	 * @return String confirming the element that has been switched to 
	 */
	@Override
	public String execute(int n) throws ActionDataException
	{
		super.context.setDriver(super.context.getDriver().switchTo().defaultContent());
		return "switched to: "+ super.context.getDriver().toString();
	}
}
