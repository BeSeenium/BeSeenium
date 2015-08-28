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
package beseenium.view.inputHandlers;


import java.util.HashMap;
import java.util.Map;

import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.inputHandlers.requests.AddActionsRequest;
import beseenium.view.inputHandlers.requests.BrowserRequest;
import beseenium.view.inputHandlers.requests.CapabilitiesRequest;
import beseenium.view.inputHandlers.requests.ExecuteRequest;

/**
 * This class is responsible for taking the input, in the form of URL 
 * parameters passed in from the servlet, and turning them into AbstractTestRequest
 * derived objects that can then be passed to the output handler to give
 * useable results.
 * @author Jan P.C. Hanson
 *
 */
public class InputHandler
{
	/** map of Strings to AbstractTestRequest's **/
	private Map<String, AbstractTestRequest> testRequests;
	
	/**
	 * default constructor.
	 */
	public InputHandler()
	{
		super();
		testRequests = new HashMap<String, AbstractTestRequest>();
	}
	
	/**
	 * Generates a map of string descriptors to requests from the given parameters, 
	 * ending with a request to execute the test.
	 * @param caps the capabilities passed in as a string.
	 * @param brwsr the browser passed in as a string.
	 * @param actns the actions to add passed in as a string.
	 * @return Map<String, AbstractTestRequest> addressable by the strings:
	 * capabilities, browser, actions & execute.
	 */
	public Map<String, AbstractTestRequest> handleInput(String caps, String brwsr, String actns)
	{
		this.testRequests.put("capabilities", this.handleCapabilities(caps));
		this.testRequests.put("browser", this.handleBrowser(brwsr));
		this.testRequests.put("actions", this.handleAddActions(actns));
		this.testRequests.put("execute", this.handleExecuteRequest());
		
		return testRequests;
	}
	
	/**
	 * generates a CapabilitiesRequest
	 * @param caps the capabilities string
	 * @return CapabilitiesRequest
	 */
	private AbstractTestRequest handleCapabilities(String caps)
	{
		return new CapabilitiesRequest(caps);
	}
	
	/**
	 * generates a BrowserRequest
	 * @param brwsr the browser string
	 * @return BrowserRequest
	 */
	private AbstractTestRequest handleBrowser(String brwsr)
	{
		return new BrowserRequest(brwsr);
	}
	
	/**
	 * generates a AddActionRequest
	 * @param actns the actions string
	 * @return AddActionRequest
	 */
	private AbstractTestRequest handleAddActions(String actns)
	{
		return new AddActionsRequest(actns);
	}
	
	/**
	 * generates an ExecuteRequest
	 * @return ExecuteRequest
	 */
	private AbstractTestRequest handleExecuteRequest()
	{
		return new ExecuteRequest("THIS TEXT IS NOT USED ATM");
	}
}
