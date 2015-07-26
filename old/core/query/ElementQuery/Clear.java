package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is a clear action, applies to text entry WebElements
 * @author JPC Hanson
 *
 */
public class Clear extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public Clear(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * if the WebElement provided is a text entry element this will 
	 * clear the value.
	 * @param element the WebElement to be cleared.
	 * @return String confirming that the element has been cleared
	 * \todo implement some kind of checking to make sure that the element 
	 * selected is a text entry element.
	 */
	@Override
	public String execute(WebElement element) 
	{
		element.clear();
		return "cleared";
	}

}
