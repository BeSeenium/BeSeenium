package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This checks to see if the element is enabled or not.
 * @author JPC Hanson
 *
 */
public class IsEnabled extends ElementQuery 
{
	/**
	 * constructor calls superconstructor
	 * @param browserDriver
	 */
	public IsEnabled(WebDriver browserDriver) 
	{super(browserDriver);}

	/**
	 * Is this element enabled or not, will generally return true for anything
	 * other than a disabled input element.
	 * @param element the WebElement to be located.
	 * @return String "true" if yes else "false"
	 */
	@Override
	public String execute(WebElement element) 
	{		
		String res;
		
		if(element.isSelected())
		{res="true";}
		else
		{res="false";}
		
		return res;
	}
}
