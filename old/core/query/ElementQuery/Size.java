package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this is a get size action
 * @author JPC Hanson
 *
 */
public class Size extends ElementQuery {
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public Size(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * calculates the width and height of the rendered element.
	 * @param element the WebElement to be located.
	 * @return String representation of the size of the element.
	 */
	@Override
	public String execute(WebElement element) 
	{		
		return element.getSize().toString();
	}
}
