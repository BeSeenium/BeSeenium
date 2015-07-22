package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this is a get tag name action
 * @author JPC Hanson
 *
 */
public class TagName extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public TagName(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * finds the tag name of the element passed in on the page.
	 * @param element the WebElement to be located.
	 * @return String representation of the tag name of the element.
	 */
	@Override
	public String execute(WebElement element) 
	{		
		return element.getTagName();
	}
}
