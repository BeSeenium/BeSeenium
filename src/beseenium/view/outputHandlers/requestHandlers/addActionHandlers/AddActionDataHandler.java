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
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.requestHandlers.AbstractRequestHandler;

/**
 * This represents a handler for the case where there has been a misuse of an ActionData object
 * This is in the most case a developer space problem rather than a user-space problem i.e. a 
 * bug rather than the user having done something wrong. this is generally the last handler in
 * the chain and as such if the exception is not caught here it will fall trigger an end of chain
 * response.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class AddActionDataHandler extends AbstractRequestHandler
{
	/** refefrence to log4j logger **/
	private static final Logger logger = LogManager.getLogger
			("BeSeenium.view.outputHandlers.requestHandlers.addActionHandlers.addActionDataHandler");

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
		catch (ActionDataException ade)
		{
			logger.error("ERROR: ActionDataException" + ade.getMessage());
			results="!!ERROR!!: probably a programming error, notify developer, jpchansondev@gmail.com";
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
