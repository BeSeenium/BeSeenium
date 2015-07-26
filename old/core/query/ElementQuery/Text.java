package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this is a 'get visible text' action
 * @author JPC Hanson
 *
 */
public class Text extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public Text(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * Gets the visible text associated with this element
	 * @param element the WebElement to be located.
	 * @return String representation of the visible text of the element.
	 */
	@Override
	public String execute(WebElement element) 
	{		
		return element.getText();
	}
}
