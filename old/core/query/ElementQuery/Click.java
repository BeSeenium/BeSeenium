package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This represents a click action.
 * @author JPC Hanson
 *
 */
public class Click extends ElementQuery 
{
	/**
	 * calls superconstructor
	 * @param browserDriver the WebDriver to use.
	 */
	public Click(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * clicks on the WebElement provided
	 * @param element the element to be clicked
	 * @return String confirmation that the element has been clicked
	 * \todo implement some checking if possible to confirm that the 
	 * link has actually been clicked, or that it has resulted in some 
	 * action (or not)
	 */
	@Override
	public String execute(WebElement element) 
	{
		element.click();
		return "clicked";
	}

}
