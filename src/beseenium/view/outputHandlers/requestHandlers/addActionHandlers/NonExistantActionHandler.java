package beseenium.view.outputHandlers.requestHandlers.addActionHandlers;
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
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;

/**
 * This represents a handler for the case where the user attempts to create an action that 
 * does not exist, for example they misspelled the action etc. This class will pass back a 
 * message echoing what was used as input and refer the user to the documentation in order
 * to check the spelling/action is correct. If this is not the case then the request will be
 * propogated down the chain.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class NonExistantActionHandler extends AbstractRequestHandler
{
	/** refefrence to log4j logger **/
	private static final Logger logger = LogManager.getLogger
			("BeSeenium.view.outputHandlers.requestHandlers.addActionHandlers.addActionFactoryHandler");

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
		catch (ActionFactoryException afe)
		{
			logger.error("ERROR: "+ afe.getMessage());
			results="!!ERROR!!, "+ afe.getMessage()+", ~";
		}
		catch (Exception e)
		{
			if(super.successor != null)
			{results = super.successor.handleRequest(request, test);}
			else
			{
				results = "end of chain, see logs for stacktrace";
				logger.fatal("reached end of handler chain, exception not handled" + e + "\n");
			}
		}
	
	return results;
	}

}
