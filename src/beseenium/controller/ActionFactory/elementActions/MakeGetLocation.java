package beseenium.controller.ActionFactory.elementActions;
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
import beseenium.controller.ActionFactory.MakeAction;
import beseenium.model.action.AbstractAction;
import beseenium.model.action.elementActions.GetLocation;

/**
 * creates a new GetLocation action
 * @author Jan P.C. Hanson
 *
 */
public class MakeGetLocation extends MakeAction
{
	/**
	 * call to super constructor
	 * @param adf an ActionDataFactory
	 */
	public MakeGetLocation(ActionDataFactory adf)
	{super(adf);}

	/* (non-Javadoc)
	 * @see beseenium.controller.ActionFactory.MakeAction#makeAction()
	 */
	@Override
	public AbstractAction makeAction()
	{
		return new GetLocation(super.adFactory.makeActionData());
	}
}
