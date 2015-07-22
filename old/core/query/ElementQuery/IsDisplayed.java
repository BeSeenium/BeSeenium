package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this checks to see if the element is displayed onscreen or not.
 * @author JPC Hanson
 *
 */
public class IsDisplayed extends ElementQuery
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public IsDisplayed(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * Is this element displayed or not
	 * @param element the WebElement to be located.
	 * @return String "true" if yes else "false"
	 */
	@Override
	public String execute(WebElement element) 
	{		
		String res;
		
		if(element.isDisplayed())
		{res="true";}
		else
		{res="false";}
		
		return res;
	}
}
