package beseenium;

import java.net.MalformedURLException;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.testExceptions.TestException;
import beseenium.view.TestManager;

public class Run 
{
	public static void main(String[] args) 
			throws MalformedURLException, ActionDataException, ActionException, TestException
	{
		Test test = new Test();
		test.setBrowser("noWindows");
		test.addAction("PageGet", "http://www.google.com", 0);
		test.addAction("FindElementsByName", "q", -1);
		test.addAction("GetTagName", "", 0);
		test.addAction("BrowserQuit", "", 0);
		
		System.out.println(test.executeActions().toString());

//		TestManager tm = new TestManager();
//		tm.addTest("jan");
//		tm.addTest("bob");
//		tm.getTestContext("jan").setBrowser("firefox");
//		tm.getTestContext("jan").addAction("PageGet", "http://www.google.com", 0);
//		tm.getTestContext("jan").addAction("FindElementsByName", "q", -1);
//		tm.getTestContext("jan").addAction("GetTagName", "", 0);
//		tm.getTestContext("jan").addAction("BrowserQuit", "", 0);
		
		
//		tm.getTestContext("bob").setBrowser("firefox");
//		tm.getTestContext("bob").addAction("PageGet", "http://www.google.com", 0);
//		tm.getTestContext("bob").addAction("FindElementsByCss", "a.gb_8a", -1);
//		tm.getTestContext("bob").addAction("GetAttribute", "href", 0);
//		tm.getTestContext("bob").addAction("BrowserQuit", "", 0);
		
		//System.out.println(tm.getTestContext("jan").executeActions());
		//System.out.println(tm.getTestContext("bob").executeActions());
	}
}
