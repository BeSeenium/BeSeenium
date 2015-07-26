package core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beseenium.action.AbstractAction;
import beseenium.action.findElementBy.*;
import beseenium.actionData.ActionData;
import beseenium.exception.ActionDataException;
import core.query.PageQuery;
import core.query.InvalidQueryException;
import core.selectors.Select;
import core.selectors.SelectionType;
import core.selectors.TerminatorType;


public class Main {

	public static void main(String[] args) throws InvalidQueryException, ActionDataException 
	{
		
		WebDriver driver = new FirefoxDriver();
		//ChainableQuery query = new ChainableQuery(driver);
		
		/**
		String chainableResult = query.execute(SelectionType.byCss, "a.title", "href");
		String terminatingResult = query.nextQuery(1, Select.terminator(TerminatorType.tagName, driver));
		
		System.out.println(chainableResult);
		System.out.println(terminatingResult);**/
		
		//new way of doing things
		ActionData context = new ActionData(driver, "a.title", "href");
		AbstractAction findbyCss = new FindElementByCss(context);
		driver.get("http://jpchanson.jetos.com");
				
		String test = findbyCss.execute(-1);
		System.out.println(test);
		
		driver.quit();
	}

}
