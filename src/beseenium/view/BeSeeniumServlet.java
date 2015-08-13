package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.view.helpers.URLHandler;
/**
 * 
 * Copyright(C) 2015 Jan P.C. Hanson & BeSeen Marketing Ltd
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
 * 
 * @author Jan P.C. Hanson
 *
 */
public class BeSeeniumServlet extends HttpServlet 
{	
	/** need this to avoid warnings **/
	private static final long serialVersionUID = -2842549406742289709L;
	/** End of line break **/
	static final String EOL = "\n";
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
    {
		/** holds the contents of the 'browser' get parameter **/
		String browser = request.getParameter("browser");
		/** holds the contents of the 'addActions' get parameter **/
		String addActions = request.getParameter("addActions");
		/** holds the contents of the 'addActions' get parameter **/
		String capabilities = request.getParameter("capabilities");
		/** holds the contents of the 'execute' get parameter **/
		String execute = request.getParameter("execute");
		/** reference to object that outputs text to response **/
		PrintWriter out = response.getWriter();
		try 
		{			
			/** UrlDecoder turns the get parameter strings into program actions **/
			URLHandler urlDecoder = new URLHandler();
			//turn the get parameters into something useful
			//execute the actions and turn the result string into an http response
			String result =urlDecoder.handleURL(capabilities, browser, addActions, execute);
			out.print(result);	
		} 
		
		catch (ActionDataFactoryException e) 
		{
			out.println("UNRECOVERABLE ERROR: "+ e.getMessage() + EOL);
			e.printStackTrace(out);
			e.printStackTrace();
			out.println(EOL);
		}
		
		catch (Exception e)
		{
			out.println("UNRECOVERABLE ERROR: " + EOL);
			e.printStackTrace(out);
			e.printStackTrace();
			out.println(EOL);
		}
		
		//close the PrintWriter
		out.close();
    }
}
