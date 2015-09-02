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
package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.view.inputHandlers.InputHandler;
import beseenium.view.inputHandlers.requests.AbstractTestRequest;
import beseenium.view.outputHandlers.OutputHandler;
/**
 * BeSeeniumServlet is a servlet that provide functionality that grabs the query
 * strings from a http request and passes it on to the URLHandler, which gives
 * back a result string which this servlet then inserts into the http response.
 * @author Jan P.C. Hanson
 *
 */
public class BeSeeniumServlet extends HttpServlet 
{	
	/** need this to avoid warnings **/
	private static final long serialVersionUID = -2842549406742289709L;
	/** End of line break **/
	static final String EOL = "\n";
	/** Logger **/
//	private static final Logger logger = LogManager.getLogger("BeSeenium.BeSeeniumServlet");
	
	/**
	 * The method that actually does all the work.
	 * @param request a http request
	 * @param response the http response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
    {
		Logger logger = LogManager.getLogger("BeSeenium.BeSeeniumServlet");
		/** holds the contents of the 'browser' get parameter **/
		String browser = request.getParameter("browser");
		/** holds the contents of the 'addActions' get parameter **/
		String addActions = request.getParameter("addActions");
		/** holds the contents of the 'addActions' get parameter **/
		String capabilities = request.getParameter("capabilities");
		/** reference to object that outputs text to response **/
		String id = request.getParameter("ID");
		/** reference to the printwriter that will write the output to the response **/
		PrintWriter out = response.getWriter();
		try 
		{			
			/** UrlDecoder turns the get parameter strings into program actions **/
//			URLHandler urlHandler = new URLHandler();
//			//turn the get parameters into something useful
//			//execute the actions and turn the result string into an http response
//			String result = urlHandler.handleURL(capabilities, browser, addActions);
//			out.print(result);	
			
			
			InputHandler inputHandler = new InputHandler();
			OutputHandler outputHandler = new OutputHandler();
			Map<String, AbstractTestRequest>tmp = inputHandler.handleInput(capabilities, browser, addActions);

			outputHandler.setRequests(tmp);
			
			List<String> results = outputHandler.handleRequests();
			
			out.println(Arrays.deepToString(results.toArray()));
		} 
//		
//		catch (ActionDataFactoryException e) 
//		{
//			out.println("UNRECOVERABLE ERROR: "+ e.getMessage() + EOL);
//			e.printStackTrace(out);
//			e.printStackTrace();
//			out.println(EOL);
//			logger.error("UNRECOVERABLE ERROR: ActionDataFactory" + e + "\n");
//			
//		}
		
		catch (Exception e)
		{
			out.println("UNRECOVERABLE ERROR: " + EOL);
			e.printStackTrace(out);
			e.printStackTrace();
			out.println(EOL);
			logger.error("UNRECOVERABLE ERROR: " + e +"\n");
		}
		
		//close the PrintWriter
		out.close();
    }
}
