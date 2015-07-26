package core.selectors;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.query.InvalidQueryException;
import core.query.ElementQuery.Clear;
import core.query.ElementQuery.Click;
import core.query.ElementQuery.ElementQuery;
import core.query.ElementQuery.IsDisplayed;
import core.query.ElementQuery.IsEnabled;
import core.query.ElementQuery.IsSelected;
import core.query.ElementQuery.Location;
import core.query.ElementQuery.Size;
import core.query.ElementQuery.TagName;
import core.query.ElementQuery.Text;
/**
 * This is a helper class that encapsulates some of the nasty finctionality away from the 
 * main structure. It provides methods that expose the Selection criterion for WebElements
 * as well as the selection of terminating queries.
 * @author JPC Hanson
 *
 */
public class Select 
{
	/**
	 * This provides a method of selecting particular WebElements given the selection criterion specified,
	 * this is a convenience that just encapsulates some inelegant code and strips it out of the 
	 * ChainableQuery class.
	 * 
	 * @param type the type of selection criterion required: byId, byClass, byCss, byTagName,
	 *  byName, byXpath, byLinkTxt, byPartialLinkTxt
	 * @param searchParam a string relevant to the selection method e.g. if selection
	 * method is byClass searchParam would be something like ".myClass"
	 * @param returnParam the attribute that you with returned i.e. "href", "class" and so on
	 * @param driver The WebDriver to be used to carry out the query
	 * @return List<WebElement> a list of WebElements
	 * @throws InvalidQueryException 
	 * \todo find a better solution than this pile of shite.
	 */
	public static List<WebElement> selection
	(SelectionType type, String searchParam, String returnParam, WebDriver driver) throws InvalidQueryException
	{
		List<WebElement> result;
		
		switch (type)
		{
			case byName:
				result = driver.findElements(By.name(searchParam));
				break;
			
			case byId:
				result = driver.findElements(By.id(searchParam));
				break;
		
			case byTagName:
				result = driver.findElements(By.tagName(searchParam));
				break;
		
			case byClass:
				result = driver.findElements( By.className(searchParam));
				break;
		
			case byCss:
				result = driver.findElements( By.cssSelector(searchParam));
				break;
		
			case byXpath:
				result = driver.findElements(By.xpath(searchParam));
				break;
		
			case byLinkTxt:
				result = driver.findElements(By.linkText(searchParam));
				break;
		
			case byPartialLinkTxt:
				result = driver.findElements( By.partialLinkText(searchParam));
				break;
		
			default:
				throw new InvalidQueryException();
		}
		return result;		
	}
	
	/**
	 * select a TerminatingQuery based on the enum constant passed in via the parameters.
	 * @param type enum constant defined in TerminatorType
	 * @param driver the WebDriver to use 
	 * @return AbstractTerminatingQuery the appropriate TerminatingQuery
	 * @throws InvalidQueryException 
	 * \todo not sure the WebDriver is necessary for this.
	 */
	public static ElementQuery terminator(TerminatorType type, WebDriver driver) 
			throws InvalidQueryException
	{
		ElementQuery tQuery = null;
		
		switch(type)
		{
			case clear:
					tQuery = new Clear(driver);
				break;
			
			case click:
					tQuery = new Click(driver);
				break;
			
			case location:
					tQuery = new Location(driver);
				break;
				
			case size:
					tQuery = new Size(driver);
				break;
			
			case isDisplayed:
					tQuery = new IsDisplayed(driver);
				break;
			
			case isEnabled:
					tQuery = new IsEnabled(driver);
				break;
				
			case isSelected:
					tQuery = new IsSelected(driver);
				break;
				
			case text:
					tQuery = new Text(driver);
				break;
				
			case tagName:
					tQuery = new TagName(driver);
				break;
				
				/**\todo find a way to do the sendkeys thing **/
			case sendKeys:
					//tQuery = new SendKeys(driver);
				break;
				
			case submit:
					//tQuery = new Submit(driver);
				break;
				
			default:
				throw new InvalidQueryException();
		}
	return tQuery;		
	}
}
