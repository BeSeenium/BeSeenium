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
package beseenium.view.helpers;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EmergencyShutdown
{
	/**
	 * in case something goes wrong the test should be able to shut down the current browser instance,
	 * or else there could potentially be many, for all intents and purposes, orphan processes floating
	 * about eating up memory....remember: always kill the orphans.
	 * @param e
	 * @return verification string
	 */
	public String execute(Test test)
	{
		try {test.emergencyShutdown();} 
		catch (ActionDataException | ActionException e1) 
		{
			e1.printStackTrace();
			return "\n CRITICAL ERROR: CANNOT PERFORM EMERGENCY SHUTDOWN \n" + e1.getMessage();
		}
		return "\n could not run test";
	}
}
