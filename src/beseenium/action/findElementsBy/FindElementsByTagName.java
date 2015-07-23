package beseenium.action.findElementsBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import beseenium.action.AbstractAction;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;

public class FindElementsByTagName extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public FindElementsByTagName(ActionData context) 
	{super(context);}

	/**
	 * @param n the index of the element to find information on, i.e. if 3 results are found
	 * the 0 will be the first element 1 the second and so on. will get an array out of bounds.
	 * If you wish the action to return all of the results found then set n = -1.
	 * @return String representation of the returnParam set in the ActionData object
	 * passed into the constructor.
	 * @throws ActionDataException  
	 */
	@Override
	public String execute(int n) throws ActionDataException 
	{
		String searchParam = super.context.getInputParam();
		String returnParam = super.context.getOutputParam();
		WebDriver browser = super.context.getDriver();
		List<WebElement> htmlElements = browser.findElements(By.tagName(searchParam));
		
		super.context.setElement(htmlElements);
		
		if(n == -1)
		{return iterateThroughAllElements(htmlElements, returnParam);}
		else
		{return htmlElements.get(n).getAttribute(returnParam);}
	}
	
	/**
	 * iterate through all the elements provided and concatonate the attribute results into
	 * one string
	 * @param elements the List<elements> to operate on
	 * @param rParam the value of the attribute you wish to return
	 * @return String representation of the Action Result
	 */
	private String iterateThroughAllElements(List<WebElement> elements, String rParam)
	{
		String tempRes = "";
		for(int i=0; i< elements.size(); ++i)
		{
			tempRes += elements.get(i).getAttribute(rParam)+"\n";
		}
		
		return tempRes;
	}
}
