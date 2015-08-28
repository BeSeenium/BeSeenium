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
package beseenium.view.requests;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;

/**
 * This class represents a request for a test to use a particular browser type
 * @author Jan P.C. Hanson
 *
 */
public class BrowserRequest extends AbstractTestRequest
{
	/**
	 * call super constructor passing in the appropriate request data.
	 * @param requestData
	 */
	public BrowserRequest(String requestData)
	{
		super(requestData);		
	}

	/* (non-Javadoc)
	 * @see beseenium.view.inputHandlers.AbstractTestRequest#executeRequest()
	 * 
	 * \n String representation of the WebDriver to use ("firefox"/"noWindows"/"remote"...etc)
	 * 
	 * \n returns a String of the form: "BROWSER SET AS" + "<name of browser>" + newline
	 */
	@Override
	public String executeRequest(Test test) throws ActionDataException, NullPointerException
	{
		test.setBrowser(super.requestData);
		return "BROWSER SET AS: " + super.requestData + "\n";
	}
}
