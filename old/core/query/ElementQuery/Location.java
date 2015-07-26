package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is a get location Action, for finding the location on a page
 * of the WebElement in question.
 * @author JPC Hanson
 *
 */
public class Location extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public Location(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * finds the location of the element passed in on the page.
	 * @param element the WebElement to be located.
	 * @return String representation of the location of the element.
	 */
	@Override
	public String execute(WebElement element) 
	{		
		return element.getLocation().toString();
	}
}
