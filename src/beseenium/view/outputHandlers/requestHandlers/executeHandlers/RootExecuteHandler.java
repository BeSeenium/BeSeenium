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
package beseenium.view.outputHandlers.requestHandlers.executeHandlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beseenium.controller.Test;
import beseenium.view.helpers.EmergencyShutdown;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;

/**
 * This class is the root of the addAction chain of responsibility, it takes care of 
 * defining the chain and, assuming the request fails, passing it to the first handler in the
 * chain. The request then propagates down the chain until it gets handled, or in the worst
 * case scenario, drops off the end of the chain without being handled.
 * @author Jan P.C. Hanson
 *
 */
public class RootExecuteHandler extends AbstractRequestHandler
{
	private static final Logger logger = LogManager.getLogger
			("BeSeenium.view.outputHandlers.requestHandlers.executeHandlers.RootExecuteHandler");
	
	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler#handleRequest()
	 */
	@Override
	public String handleRequest(AbstractTestRequest request, Test test)
	{
		String results=null;
		try
		{			
			 results = request.executeRequest(test);
			 logger.info(results);
		} 
		catch (Exception e)
		{
			ActionExceptionHandler h1 = new ActionExceptionHandler();
			ActionDataExceptionHandler h2 = new ActionDataExceptionHandler();
			
			
			h1.setSuccessor(h2);
			
			
			results = h1.handleRequest(request, test);
			results += new EmergencyShutdown().execute(test);
		}
		return results;
	}
}
