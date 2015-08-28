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
package beseenium.view.outputHandlers;

import java.util.Map;

import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;
import beseenium.view.outputHandlers.requestHandlers.addActionHandlers.RootAddActionsHandler;
import beseenium.view.outputHandlers.requestHandlers.browserHandlers.RootBrowserHandler;
import beseenium.view.outputHandlers.requestHandlers.capabilitiesHandlers.RootCapabilitiesHandler;
import beseenium.view.outputHandlers.requestHandlers.executeHandlers.RootExecuteHandler;

/**
 * This takes an array of AbstractTestRequests and uses it to generate output
 * in various forms. it is a specialisation of the AbstractRequestHandler type
 * and contains an extra method setRequestS() which allows it to distribute 
 * the requests contained in this array to chains of responsibility specific
 * to that request type. It is also the client of all request chains of responsibility.
 * 
 * it is responsible for deciding the order in which the specific requests are
 * handled, however it is left to the root handler of individual chains to decide
 * the order in which request specific handlers are called. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public class OutputHandler extends AbstractRequestHandler
{
	/** map of possible chains of responsibility to follow depending on the type of TestRequest **/
	private Map<AbstractTestRequest, AbstractRequestHandler> successorMap;
	/** The actual chain of responsibility to follow. **/
	private AbstractRequestHandler successor;
	
	/**
	 * default constructor
	 */
	public OutputHandler()
	{super();}
	
	/**
	 * Sets the array of Test Requests to distribute to the various chains of responsibility.
	 * @param requests
	 */
	public void setRequests(Map<String, AbstractTestRequest> requests)
	{
		successorMap.put(requests.get("execute"), new RootExecuteHandler());
		successorMap.put(requests.get("action"), new RootAddActionsHandler());
		successorMap.put(requests.get("browser"), new RootBrowserHandler());
		successorMap.put(requests.get("capabilities"), new RootCapabilitiesHandler());	
	}
	
	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.AbstractRequestHandler#setSuccessor(beseenium.view.outputHandlers.AbstractRequestHandler)
	 */
	@Override
	public void setSuccessor(AbstractRequestHandler successor)
	{
		this.successor = successor;
	}

	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.AbstractRequestHandler#handleRequest()
	 * 
	 * This method calls the individual chains of responsibility in the required 
	 * order, it make much sense for actions to be handled before there is
	 * a browser to handle them for instance. Similarly as the 'remote' browser type
	 * requires capabilities to be set before it is called this must come first.
	 */
	@Override
	public String handleRequest(AbstractTestRequest request)
	{	
		this.setSuccessor(successorMap.get(request));
		return this.successor.handleRequest(request);
	}
}
