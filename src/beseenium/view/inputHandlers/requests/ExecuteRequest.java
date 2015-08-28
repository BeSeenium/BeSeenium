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
package beseenium.view.inputHandlers.requests;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;

/**
 * represents a request to execute the test.
 * @author Jan P.C. Hanson
 *
 */
public class ExecuteRequest extends AbstractTestRequest
{
	/**
	 * call super constructor passing in the appropriate request data.
	 * @param requestData
	 */
	public ExecuteRequest(String requestData)
	{
		super(requestData);		
	}

	/* (non-Javadoc)
	 * @see beseenium.view.inputHandlers.AbstractTestRequest#executeRequest()
	 * 
	 * \n returns a String of with the output of the test results.
	 */
	@Override
	public String executeRequest(Test test) 
			throws ActionDataException, ActionException 
			
	{return test.executeActions().toString() + "\n";}
}
