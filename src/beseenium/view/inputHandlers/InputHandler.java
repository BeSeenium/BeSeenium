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

import java.util.List;

import beseenium.view.requests.AbstractTestRequest;
import beseenium.view.requests.BrowserRequest;

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
	/**
	 * default constructor.
	 */
	public InputHandler()
	{super();}
	
	/**
	 * Generates a List of requests from the given parameters, ending with a request to 
	 * execute the test.
	 * @param caps the capabilities passed in as a string.
	 * @param brwsr the browser passed in as a string.
	 * @param actns the actions to add passed in as a string.
	 * @return
	 */
	public List<AbstractTestRequest> handleInput(String caps, String brwsr, String actns)
	{
		return null;
	}
	
	/**
	 * 
	 * @param caps
	 */
	private AbstractTestRequest handleCapabilities(String caps)
	{
		return null;
	}
	
	/**
	 * 
	 * @param brwsr
	 * @return
	 */
	private AbstractTestRequest handleBrowser(String brwsr)
	{
		return new BrowserRequest(brwsr);
	}
	
	/**
	 * 
	 * @param actns
	 * @return
	 */
	private AbstractTestRequest handleAddActions(String actns)
	{
		return null;
	}
}
