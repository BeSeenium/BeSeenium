package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.view.helpers.UrlDecoder;

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
			UrlDecoder urlDecoder = new UrlDecoder();
			//turn the get parameters into something useful
			//execute the actions and turn the result string into an http response
			String result =urlDecoder.decodeURL(capabilities, browser, addActions, execute);
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
