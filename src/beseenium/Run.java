package beseenium;

import java.net.MalformedURLException;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.testExceptions.TestException;
import beseenium.view.TestManager;

public class Run 
{
	public static void main(String[] args) 
			throws MalformedURLException, ActionDataException, ActionException, TestException
	{
//		ActionController controller = new ActionController();
//		try 
//		{
//			controller.setBrowser("firefox");
//			controller.addAction("PageGet", "http://www.google.com", 0);
//			controller.addAction("BrowserQuit", "", 0);
//			controller.executeActions();
//		} 
//		
//		catch (ActionDataException | ActionException e) 
//		{
//			e.printStackTrace();
//			controller.emergencyShutdown();
//		}
		
		
		TestManager tm = new TestManager();
		tm.addTest("jan");
		tm.addTest("bob");
		tm.getTestContext("jan").setBrowser("firefox");
		tm.getTestContext("bob").setBrowser("firefox");
		tm.getTestContext("jan").addAction("PageGet", "http://www.google.com", 0);
		tm.getTestContext("bob").addAction("PageGet", "http://www.google.com", 0);
		tm.getTestContext("jan").addAction("BrowserQuit", "", 0);
		tm.getTestContext("bob").addAction("BrowserQuit", "", 0);
		System.out.println(tm.getTestContext("jan").executeActions());
		System.out.println(tm.getTestContext("bob").executeActions());
	}
}
