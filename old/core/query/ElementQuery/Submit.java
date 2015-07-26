package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** 
 * this is a form submit action
 * @author JPC Hanson
 *
 */
public class Submit extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public Submit(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * submits a form
	 * @param element the WebElement to be located.
	 * @return String confirmation of submit action
	 * \todo implement some checking if possible to see if the form has 
	 * been submitted successfully or not.
	 */
	@Override
	public String execute(WebElement element) 
	{		
		element.submit();
		return "submitted";
	}
}
