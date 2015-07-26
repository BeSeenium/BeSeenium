package beseenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.controller.*;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;
import beseenium.model.action.*;
import beseenium.model.action.elementActions.*;
import beseenium.model.action.findElementsBy.*;
import beseenium.model.action.navigateActions.*;
import beseenium.model.action.pageActions.*;
import beseenium.model.action.switchActions.*;
import beseenium.model.actionData.ActionData;

public class Main {

	public static void main(String[] args) 
	throws ActionDataException, ActionException, InterruptedException 
	{

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
		
	
	}

}
