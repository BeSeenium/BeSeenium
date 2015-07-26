package core.query.ElementQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This Abstract class defines a common interface for all terminating queries. A terminating
 * query is one that operates on a WebElement i.e. the result of a ChainableQuery.
 * @author JPC Hanson
 *
 */
public abstract class ElementQuery
{
	/**
	 * constructor, sets the WebDriver to e used by derived classes.
	 * @param browserDriver ChromeDriver, FirefoxDriver, etc
	 */
	protected ElementQuery(WebDriver browserDriver) 
	{
		this.driver = browserDriver;
	}

	/**
	 * Executes a terminating Query on the provided WebElement
	 * @param element WebElement representation to be operated on
	 * @return String representation of the outcome of the query.
	 */
	public abstract String execute(WebElement element);

	
	/** the driver to be used by the execute methods of derived classes **/
	protected WebDriver driver;
	
}
