package beseenium.view.outputHandlers.requestHandlers.browserHandlers;
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
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;

/**
 * This class is the root of the browser chain of responsibility, it takes care of 
 * defining the chain and, assuming the request fails, passing it to the first handler in the
 * chain. The request then propagates down the chain until it gets handled, or in the worst
 * case scenario, drops off the end of the chain without being handled.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class RootBrowserHandler extends AbstractRequestHandler
{

	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler#handleRequest()
	 * 
	 * This sets the order of the chain of responsibility and sends the request to the first
	 * handler, which in turn propagates it down the chain.
	 */
	@Override
	public String handleRequest(AbstractTestRequest request, Test test)
	{
		String results=null;
		try
		{			
			 results = request.executeRequest(test);
		} 
		catch (Exception e)
		{
			NoBrowserParamHandler h1 = new NoBrowserParamHandler();
			WrongBrowserParamHandler h2 = new WrongBrowserParamHandler();
			BrowserActionDataHandler h3 = new BrowserActionDataHandler();
			
			h1.setSuccessor(h2);
			h2.setSuccessor(h3);
			
			
			results = h1.handleRequest(request, test);
		}
		
		return results;
	}

}
