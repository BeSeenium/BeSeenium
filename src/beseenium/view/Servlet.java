package beseenium.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beseenium.controller.ActionInvoker;
import beseenium.controller.ActionDataFactory;
import beseenium.controller.ActionFactory;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
import beseenium.model.actionData.ActionData;

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
        if(command == null)
        {
        	
        }
        
        else if(command.contentEquals("ok")==false)
        {
        	//httpServletResponse.reset(); //clear screen
        	out.println("command = "+command);
            out.println("value = "+httpServletRequest.getParameter("value"));
        	
        }
        else
        {
        	try {
				run();
			} catch (ActionDataException | ActionException
					| InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 System.out.println("it works");
        }
        out.close();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void run() 
			throws ActionDataException, ActionException, InterruptedException, MalformedURLException 
			{

				///////////////////////////////////////////////////////////////////////
				//prototype action list and iteration
				///////////////////////////////////////////////////////////////////////
				
				
				//initialise factories
				
				
				//configuration
				ActionDataFactory.setCapabilities("browser", "IE");
				ActionDataFactory.setCapabilities("brower_version", "7.0");
				ActionDataFactory.setCapabilities("os", "Windows");
				ActionDataFactory.setCapabilities("os_version", "XP");
				ActionDataFactory.setCapabilities("browserstack.debug", "true");
				ActionDataFactory.setCapabilities("auth", "jonjackson:WDaudZN5Y1eTGPUUozty");
				
				ActionFactory Afactory = new ActionFactory();
				ActionData actionData = ActionDataFactory.makeActionData("firefox");
				
				
				ActionInvoker controller = new ActionInvoker(actionData);
				
				
				//page actions test
				controller.add(ActionFactory.makeAction("PageGet"), "http://www.test.com", 0);
//				controller.add(ActionFactory.makeAction("GetPageSrc"), "", 0);
//				controller.add(ActionFactory.makeAction("GetTitle"), "", 0);
//				controller.add(ActionFactory.makeAction("GetURL"), "", 0);
				
				//navigation Actions test
				controller.add(ActionFactory.makeAction("PageGet"), "http://www.google.com/?#q=test", 0);
//				controller.add(ActionFactory.makeAction("NavigateBack"), "", 1);
//				controller.add(ActionFactory.makeAction("NavigateForward"), "", 1);
//				controller.add(ActionFactory.makeAction("RefreshPage"), "", 2);
				
				//find elements by test
//				controller.add(ActionFactory.makeAction("FindElementsByCss"), "input", -1);
//				controller.add(ActionFactory.makeAction("FindElementsByTagName"), "input", -1);
//				controller.add(ActionFactory.makeAction("FindElementsById"), "lst-ib", -1);
//				controller.add(ActionFactory.makeAction("FindElementsByLinkTxt"), "Speedtest.net by Ookla - The Global Broadband Speed Test", -1);
//				controller.add(ActionFactory.makeAction("FindElementsByPartialLinkTxt"), "Ookla", -1);
//				controller.add(ActionFactory.makeAction("FindElementsByXpath"), "//div[@id]", -1);
				controller.add(ActionFactory.makeAction("FindElementsByName"), "q", -1);

				//element Action test
				controller.add(ActionFactory.makeAction("Clear"), "", 0);
				controller.add(ActionFactory.makeAction("Click"), "", 0);
				controller.add(ActionFactory.makeAction("GetAttribute"), "name", 0);
				controller.add(ActionFactory.makeAction("GetCssValue"), "background", 0);
				controller.add(ActionFactory.makeAction("GetLocation"), "", 0);
				controller.add(ActionFactory.makeAction("GetSize"), "", 0);
				controller.add(ActionFactory.makeAction("GetTagName"), "", 0);
				controller.add(ActionFactory.makeAction("GetText"), "", 0);
				controller.add(ActionFactory.makeAction("IsDisplayed"), "", 0);
				controller.add(ActionFactory.makeAction("IsEnabled"), "", 0);
				controller.add(ActionFactory.makeAction("IsSelected"), "", 0);
				controller.add(ActionFactory.makeAction("SendKeys"), "blueberry trifle", 0);
				controller.add(ActionFactory.makeAction("Submit"), "", 0);
				
				//close page and browser(PageActions)
//				controller.add(ActionFactory.makeAction("PageClose"), "", 0);
				controller.add(ActionFactory.makeAction("BrowserQuit"), "", 0);
				
				//execute all Actions
				List<String> results = controller.execute();
				
				//print results to screen
				for (int i = 0; i < results.size(); ++i)
				{
					System.out.println(results.get(i));
				}
				
			
			}

}
