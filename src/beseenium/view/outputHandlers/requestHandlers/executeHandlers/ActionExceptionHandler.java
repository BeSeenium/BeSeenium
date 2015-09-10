package beseenium.view.outputHandlers.requestHandlers.executeHandlers;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beseenium.controller.Test;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;

/**
 * This represents a handler for the case where, actions have been requested in the incorrect 
 * order, i.e. an element-scoped action has been requested before a findElementsBy... action
 * as it is nonsensical to query an element that has yet to be found. There are other examples,
 * please refer to the wiki for an exhaustive list. in any case this class should pick up on 
 * these misuses and inform the user of their digression from the path. any of these action
 * misuses will result in an ActionException should the exception thrown now be an ActionException
 * then the request will be passed on to the following handler in the chain.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class ActionExceptionHandler extends AbstractRequestHandler
{
	/** refefrence to log4j logger **/
	private static final Logger logger = LogManager.getLogger
			("BeSeenium.view.outputHandlers.requestHandlers.executeHandlers.ActionExceptionHandler");

	/* (non-Javadoc)
	 * @see beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler#handleRequest(beseenium.view.inputHandlers.requests.AbstractTestRequest, beseenium.controller.Test)
	 */
	@Override
	public String handleRequest(AbstractTestRequest request, Test test)
	{
		String results=null;
		try
		{
			results = request.executeRequest(test);
		} 
		catch (ActionException ae)
		{
			logger.error("ERROR: " + ae.getMessage());
			results="ERROR: " + ae.getMessage();
		}
		catch (Exception e)
		{
			if(super.successor != null)
			{results = super.successor.handleRequest(request, test);}
			else
			{
				results = "end of chain, see logs for stacktrace ";
				logger.fatal("reached end of handler chain, exception not handled" 
							+ e.getMessage() + "\n", e);
			}
		}
	
	return results;
	}
}
