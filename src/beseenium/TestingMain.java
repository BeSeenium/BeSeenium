package beseenium;

import java.net.MalformedURLException;
//import java.util.Arrays;

//import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.exceptions.testExceptions.TestException;
//import beseenium.view.TestManager;

public class TestingMain 
{

	
	public static void main(String[] args) 
			throws MalformedURLException, ActionDataException, ActionException, TestException
	{
//		String testString = "key1+value1+val1AAAkey2+value2+val2AAAkey3+value3+val3";
//		
//		String[] firstSplit = testString.split("ABC"); //={"key:value", "key:value"}
//		int split1Len = firstSplit.length;
//		int split2Len = firstSplit[0].split("XYZ").length;
//		String[][] resultArray = new String[split1Len][split2Len];// = {{"key","value"},{"key","value"}};
//		
//		for(int i = 0; i < firstSplit.length; ++i)
//		{
//			resultArray[i]=firstSplit[i].split("XYZ");
//		}
//		System.out.println(Arrays.deepToString(resultArray));
		
//		Test test = new Test();
//		test.setBrowser("firefox");
//		test.addAction("PageGet", "http://www.google.com", 0);
//		test.addAction("FindElementsByName", "q", -1);
//		test.addAction("GetTagName", "", 0);
//		test.addAction("BrowserQuit", "", 0);
//		
//		System.out.println(test.executeActions().toString());

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
