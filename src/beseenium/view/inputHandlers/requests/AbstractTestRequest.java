package beseenium.view.inputHandlers.requests;
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
import beseenium.controller.Test;

/**
 * This class is the abstract base class for a series of request objects relating to 
 * various parts of a test's functionality, e.g. capabilities, browser, addActions etc.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractTestRequest
{
	/** the data passed in from the URL parameter **/
	protected String requestData;
	
	/**
	 * Constructor, instantiates the object with the data provided by the URL parameter
	 * @param requestData the data provided by the URL parameter.
	 */
	protected AbstractTestRequest(String requestData)
	{
		super();
		this.requestData = requestData;
	}
	
	/**
	 * Contains the implementation of the request
	 * @return String representing the result of this request.
	 */
	public abstract String executeRequest(Test test) throws Exception;
	
}
