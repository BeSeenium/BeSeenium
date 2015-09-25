package beseenium.view.outputHandlers;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beseenium.controller.Test;
import beseenium.view.helpers.EmergencyShutdown;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.compositors.RootCompositor;
import beseenium.view.outputHandlers.formatters.JsonFormatter;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;
import beseenium.view.outputHandlers.requestHandlers.addActionHandlers.RootAddActionsHandler;
import beseenium.view.outputHandlers.requestHandlers.browserHandlers.RootBrowserHandler;
import beseenium.view.outputHandlers.requestHandlers.capabilitiesHandlers.RootCapabilitiesHandler;
import beseenium.view.outputHandlers.requestHandlers.executeHandlers.RootExecuteHandler;

/**
 * This takes an array of AbstractTestRequests and uses it to generate output
 * in various forms. Logically it is a specialisation of the AbstractRequestHandler type
 * but contains an extra method setRequests() which allows it to distribute 
 * the requests contained in this array to chains of responsibility specific
 * to that request type. It is also the client of all request chains of responsibility.
 * As well as this, its handleRequests() method has no parameter, so while it is logically
 * an AbstractRequestHandler it is not part of that inheritance hierarchy.
 * 
 * it is responsible for deciding the order in which the specific requests are
 * passed to their handlers, however it is left to the root handler of individual 
 * chains to decide the order in which request specific handlers are called. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public class OutputHandler
{
	/** map of possible chains of responsibility to follow depending on the type of TestRequest **/
	private Map<AbstractTestRequest, AbstractRequestHandler> successorMap;
	/** The actual chain of responsibility to follow. **/
	private AbstractRequestHandler successor;
	/** map of string descriptors to AbstractTestRequests**/
	private Map<String, AbstractTestRequest> requestMap;
	/** class copy of test to be used **/
	private Test test;
	
	/**
	 * default constructor
	 */
	public OutputHandler(Test test)
	{
		super();
		successorMap = new HashMap<AbstractTestRequest, AbstractRequestHandler>();	
		this.test = test;
	}
	
	/**
	 * Sets the map of Test Requests to distribute to the various chains of responsibility.
	 * @param requests
	 */
	public void setRequests(Map<String, AbstractTestRequest> requests)
	{
		this.requestMap = requests;
		successorMap.put(requests.get("execute"), new RootExecuteHandler());
		successorMap.put(requests.get("actions"), new RootAddActionsHandler());
		successorMap.put(requests.get("browser"), new RootBrowserHandler());
		successorMap.put(requests.get("capabilities"), new RootCapabilitiesHandler());	
	}
	
	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.AbstractRequestHandler#setSuccessor(beseenium.view.outputHandlers.AbstractRequestHandler)
	 */
	public void setSuccessor(AbstractRequestHandler successor)
	{
		this.successor = successor;
	}

	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.AbstractRequestHandler#handleRequest()
	 * 
	 * This method calls the individual chains of responsibility in the required 
	 * order, it makes sense for actions to be handled before there is
	 * a browser to handle them for instance. Similarly as the 'remote' browser type
	 * requires capabilities to be set before it is called this must come first.
	 */
	public List<String> handleRequests(String id)
	{
		ArrayList<String> results = new ArrayList<String>();
		try
		{ 
		
			this.setSuccessor(successorMap.get(this.requestMap.get("capabilities")));
			results.add(this.successor.handleRequest(this.requestMap.get("capabilities"),test));
		
			this.setSuccessor(successorMap.get(this.requestMap.get("browser")));
			results.add(this.successor.handleRequest(this.requestMap.get("browser"),test));
		
			this.setSuccessor(successorMap.get(this.requestMap.get("actions")));
			results.add(this.successor.handleRequest(this.requestMap.get("actions"),test));
			
			if (this.checkListForERROR(results)==false)
			{
				this.setSuccessor(successorMap.get(this.requestMap.get("execute")));
				results.add(this.successor.handleRequest(this.requestMap.get("execute"),test));
				
			}
			else
			{
				results.add(new EmergencyShutdown().execute(test));
			}
			System.out.println(new RootCompositor
					(
						new JsonFormatter()).composite("capabilities", results.get(0))
					);
			System.out.println(new RootCompositor
					(
						new JsonFormatter()).composite("browser", results.get(1))
					);
			System.out.println(new RootCompositor
					(
						new JsonFormatter()).composite("addAction", results.get(2))
					);
			System.out.println(new RootCompositor
					(
						new JsonFormatter()).composite("execute", results.get(3))
					);
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * checks to see if a List<String> contains the string "ERROR" in it
	 * @param stringList the List<String> to check
	 * @return true if the list contains the String "ERROR", false if not.
	 */
	private boolean checkListForERROR(List<String> stringList)
	{
		for(String string: stringList)
		{  if(string.contains("ERROR")){return true;}  }
		return false;
	}
}
