package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet 
{

	/**
	 * need this to avoid warnings
	 */
	private static final long serialVersionUID = -2842549406742289709L;
	
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException
    {
		String command = httpServletRequest.getParameter("command");
        PrintWriter out = httpServletResponse.getWriter();
       
        out.println("command");
        
        
        if(command.contentEquals("ok"))
        {
        	out.flush();
        	 System.out.println("it works");
        }
        else
        {
        	out.println("command = "+command);
            out.println("value = "+httpServletRequest.getParameter("value"));
        }
        out.close();
    }
	
	/**
     * read the config file and apply settings to server
     */
    private void readHTMLFile()
    {
    	
    }

}
