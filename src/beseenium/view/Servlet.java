package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beseenium.Run;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.testExceptions.TestException;

public class Servlet extends HttpServlet 
{	
	/** need this to avoid warnings **/
	private static final long serialVersionUID = -2842549406742289709L;
	
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
		/** UrlDecoder turns the get parameter strings into program actions **/
		UrlDecoder urlDecoder = new UrlDecoder();
		
		//turn the get parameters into something useful
		urlDecoder.decodeCapabilities(capabilities);
		urlDecoder.decodeBrowser(browser);
		urlDecoder.decodeAddActions(addActions);
		
		//execute the actions and turn the result string into an http response
		out.print(urlDecoder.execute(execute));
		
		//close the PrintWriter
		out.close();
    }
}
