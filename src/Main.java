
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.action.findElementBy.*;
import beseenium.action.elementActions.*;
import beseenium.action.*;
import beseenium.actionData.ActionData;
import beseenium.exception.ActionDataException;
import beseenium.exception.ActionException;



public class Main {

	public static void main(String[] args) throws ActionDataException, ActionException, InterruptedException 
	{
		
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
		
		Thread.sleep(2000);
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
		
		//end
		Thread.sleep(1000);
		driver.quit();
	}

}
