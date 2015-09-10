package beseenium.controller.ActionFactory;
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
import beseenium.controller.ActionDataFactory.ActionDataFactory;
import beseenium.model.action.AbstractAction;

/**
 * abstract base class for the creation of AbstractActions specific to the MakeAction 
 * derived type.
 * 
 * @author Jan P.C. Hanson
 *
 */
public abstract class MakeAction
{
	/** internal ActionDataFactory for use by derived types **/
	protected ActionDataFactory adFactory;
	
	/**
	 * populates internal ActionDataFactory for use by derived types
	 * @param adf
	 */
	protected MakeAction(ActionDataFactory adf)
	{
		super();
		this.adFactory = adf;
	}
	
	/**
	 * creates an AbstractAction specific to the MakeAction derived type.
	 * @return AbstractAction specific to the MakeAction derived type
	 */
	public abstract AbstractAction makeAction();
	
}
