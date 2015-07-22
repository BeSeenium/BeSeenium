
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
		
		//action 1
		context = new ActionData(driver, "q", "id");
		action = new FindElementsByName(context);				
		test = action.execute(-1);
		System.out.println(test);
		
		//action2 sendkeys
		context = action.getActionData();
		context.setInputParam("test");
		action = new SendKeys(context);
		test = action.execute(0);
		System.out.println(test);
		
		//action 3 submit
		context = action.getActionData();
		action = new Submit(context);
		test = action.execute(0);
		System.out.println(test);
		
		Thread.sleep(2000);
		//action 4 clear
		context = action.getActionData();
		action = new Clear(context);
		test = action.execute(0);
		System.out.println(test);
		
		//end
		Thread.sleep(1000);
		driver.quit();
	}

}
