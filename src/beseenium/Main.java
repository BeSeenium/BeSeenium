package beseenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.action.*;
import beseenium.action.findElementsBy.*;
import beseenium.action.navigateActions.*;
import beseenium.action.pageActions.*;
import beseenium.action.switchActions.*;
import beseenium.action.elementActions.*;
import beseenium.actionData.ActionData;
import beseenium.controller.*;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;

public class Main {

	public static void main(String[] args) 
	throws ActionDataException, ActionException, InterruptedException 
	{
		/**
		WebDriver driver = new FirefoxDriver();
		ActionData context;
		AbstractAction action;
		String test;
		
		driver.get("http://www.google.com");		
		
		//test 1 find element
		context = new ActionData(driver, "q", "id");
		action = new FindElementsByName(context);				
		test = action.execute(-1);
		System.out.println(test);
		
		//test 2 sendkeys
		context = action.getActionData();
		context.setInputParam("test");
		action = new SendKeys(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 3 submit
		context = action.getActionData();
		action = new Submit(context);
		test = action.execute(0);
		System.out.println(test);
		
		Thread.sleep(1000);
		
		//test 4 clear
		context = action.getActionData();
		action = new Clear(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 5 getAttribute
		context = action.getActionData();
		context.setInputParam("class");
		action = new GetAttribute(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 6 getCssValue
		context = action.getActionData();
		context.setInputParam("background");
		action = new GetCssValue(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 7 getText
		context = action.getActionData();
		action = new GetText(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 8 GetTagName
		context = action.getActionData();
		action = new GetTagName(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 9 get location
		context = action.getActionData();
		action = new GetLocation(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 10 get size
		context = action.getActionData();
		action = new GetSize(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 11 is displayed?
		context = action.getActionData();
		action = new IsDisplayed(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 12 is enabled?
		context = action.getActionData();
		action = new IsEnabled(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 13 is selected?
		context = action.getActionData();
		action = new IsSelected(context);
		test = action.execute(0);
		System.out.println(test);
		
		// test 14 get page
		context = action.getActionData();
		context.setInputParam("http://jpchanson.jetos.com");
		action = new PageGet(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 14 get current url
		context = action.getActionData();
		action = new GetURL(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 15 get page src
		context = action.getActionData();
		action = new GetPageSrc(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 15 get page title
		context = action.getActionData();
		action = new GetTitle(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 16  navigate back
		context = action.getActionData();
		action = new NavigateBack(context);
		test = action.execute(5);
		System.out.println(test);
		
		//test 17  navigate forward
		context = action.getActionData();
		action = new NavigateForward(context);
		test = action.execute(5);
		System.out.println(test);
		
		//test 18  refresh page
		context = action.getActionData();
		action = new RefreshPage(context);
		test = action.execute(1);
		System.out.println(test);
		
		//test 18 switch to active element
		context = action.getActionData();
		action = new SwitchToActiveElement(context);
		test = action.execute(0);
		System.out.println(test);
		
		//test 19 switch to default content
		context = action.getActionData();
		action = new SwitchToDefaultContent(context);
		test = action.execute(0);
		System.out.println(test);**/
		
		///////////////////////////////////////////////////////////////////////
		//prototype action list and iteration
		///////////////////////////////////////////////////////////////////////
		//initialise factories

		ActionFactory Afactory = new ActionFactory();
		
		//configuration
		ActionData actionData = ActionDataFactory.makeActionData("firefox");
		ActionController controller = new ActionController(actionData);
		
		//page actions test
		controller.add(ActionFactory.makeAction("PageGet"), "http://www.test.com", 0);
//		controller.add(ActionFactory.makeAction("GetPageSrc"), "", 0);
//		controller.add(ActionFactory.makeAction("GetTitle"), "", 0);
//		controller.add(ActionFactory.makeAction("GetURL"), "", 0);
		
		//navigation Actions test
		controller.add(ActionFactory.makeAction("PageGet"), "http://www.google.com/?#q=test", 0);
//		controller.add(ActionFactory.makeAction("NavigateBack"), "", 1);
//		controller.add(ActionFactory.makeAction("NavigateForward"), "", 1);
//		controller.add(ActionFactory.makeAction("RefreshPage"), "", 2);
		
		//find elements by test
//		controller.add(ActionFactory.makeAction("FindElementsByCss"), "input", -1);
//		controller.add(ActionFactory.makeAction("FindElementsByTagName"), "input", -1);
//		controller.add(ActionFactory.makeAction("FindElementsById"), "lst-ib", -1);
//		controller.add(ActionFactory.makeAction("FindElementsByLinkTxt"), "Speedtest.net by Ookla - The Global Broadband Speed Test", -1);
//		controller.add(ActionFactory.makeAction("FindElementsByPartialLinkTxt"), "Ookla", -1);
//		controller.add(ActionFactory.makeAction("FindElementsByXpath"), "//div[@id]", -1);
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
		controller.add(ActionFactory.makeAction("PageClose"), "", 0);
		controller.add(ActionFactory.makeAction("BrowserQuit"), "", 0);
		
		//execute all Actions
		List<String> results = controller.execute();
		
		//print results to screen
		for (int i = 0; i < results.size(); ++i)
		{
			System.out.println(results.get(i));
		}
		
		//end
		//Thread.sleep(1000);
		//driver.quit();
	}

}
