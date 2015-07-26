package beseenium.model.actionData;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import beseenium.exceptions.ActionDataException;

/**
 * This class encapsulates the data needed to perform an action into 4 distinct areas: <br><br>
 * 
 * <strong>InputParam</strong> - The Input Param is a string that represents What a particular
 * action should be using as input. For example if the action in question is FindElementByCss
 * action an appropriate inputParam would be "a.title" if it was FindElementByClass an appropriate
 * inputParam would be ".myClass" and if the action was SendKeys an appropriate Input Parameter
 * would be a string containing the set letters you wish to send etc.<br>
 * 
 * <strong>OutputParam</strong> - The Output Parameter is a string that represents the attribute
 * that an action should return for instance "href" or "class" etc<br>
 * 
 * <strong>element</strong>  A FindElementBy... action populates an ActionData with a WebElement,
 * this is needed by other, non FindElementBy queries.<br>
 * 
 * <strong>driver</strong>  This is used by all queries and is the Selenium WebDriver that this
 * particular ActionData object is created with.<br>
 * @author JPC Hanson
 *
 */
public class ActionData 
{
	/** a the browser driver that an action will be performed with**/
	private WebDriver driver;
	/** the Input parameter that an action may operate on**/
	private String inputParam;
	/** the Output parameter that an action may return**/
	private String outputParam;
	/** The html element that other actions operate on **/
	private List<WebElement> element;
	
	/**
	 * default ctor
	 */
	public ActionData()
	{}
	
	/**
	 * Instantiate a new ActionData object with the WebDriver provided 
	 * @param driver
	 */
	public ActionData(WebDriver driver)
	{this.driver = driver;}
	
	/**
	 * constructor for findElement style actions \todo remove
	 */
	public ActionData(WebDriver driver, String iParam, String oParam)
	{
		this.driver = driver;
		this.inputParam = iParam;
		this.outputParam = oParam;
	}

//---------------------------------------------------------------------------SETTERS
	/**
	 * @return the inputParam
	 * @throws ActionDataException if no search parameter set.
	 */
	public String getInputParam() throws ActionDataException 
	{
		if (this.inputParam == null)
			{throw new ActionDataException("No search parameter set");}
		else
			{return inputParam;}
	}

	/**
	 * @return the WebElement
	 * @throws ActionDataException if no WebElement set.
	 */
	public List<WebElement> getElement() throws ActionDataException 
	{
		if (this.element == null)
			{throw new ActionDataException("No WebElement exists in this ActionData");}
		else
			{return element;}	
	}
	
	/**
	 * @return the WebDriver
	 * @throws ActionDataException 
	 */
	public WebDriver getDriver() throws ActionDataException
	{
		if (this.driver == null)
		{throw new ActionDataException("No WebDriver exists in this ActionData");}
	else
		{return driver;}
	}
//---------------------------------------------------------------------ENDOF SETTERS
	
//---------------------------------------------------------------------------GETTERS	
	/**
	 * @param element the element to set
	 */
	public void setElement(List<WebElement> element) 
	{this.element = element;}

	/**
	 * this method sets the value of the input parameter. Make sure that the value is 
	 * appropriate to the action that you plan to execute next.
	 * @param inputParam the searchParam to set
	 */
	public void setInputParam(String inputParam) 
	{this.inputParam = inputParam;}
	
	/**
	 * 
	 * @param driver
	 */
	public void setDriver(WebDriver driver)
	{this.driver=driver;}
//---------------------------------------------------------------------ENDOF GETTERS
}