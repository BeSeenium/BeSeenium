package beseenium.controller.ActionDataFactory;
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
import beseenium.model.actionData.ActionData;

/**
 * interface which describes a prototype for creating MakeData objects.
 * @author Jan P.C. Hanson
 *
 */
public interface MakeData 
{	
	/**
	 * the factory method that returns the ActionData specific to 
	 * the derived type of MakeActionData. 
	 * @return ActionData appropriate to this type.
	 */
	public ActionData makeActionData();

	
}
