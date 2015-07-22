package core.query;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.query.ElementQuery.ElementQuery;
import core.selectors.Select;
import core.selectors.SelectionType;

/**
 * A tag query is a child class of a generic Query, it represents a query that acts on a specific 
 * web element, this query can be chained with a terminating query.
 * 
 * @author JPC Hanson
 *
 *\todo get chaining to work so you can chain ChainableQueries together ad infinitum.
 */
public class PageQuery extends AbstractQuery 
{
	/**
	 * Calls the super constructor
	 * @param browserDriver
	 */
	public PageQuery(WebDriver browserDriver) 
	{
		super(browserDriver);
	}

	/**
	 * executes the query defined by the parameters, the query may find more than one
	 * matching tag, this will be reflected in the returned string.
	 * @param type a type of selection appropriate defined in SelectionType enum:
	 * byId, byClass, byCss, byTagName, byName, byXpath, byLinkTxt, byPartialLinkTxt
	 * @param searchParam a string relevant to the selection method e.g. if selection
	 * method is byClass searchParam would be something like ".myClass"
	 * @param returnParam the attribute that you with returned i.e. "href", "class" and so on
	 * @return String the value of the attribute defined in returnParam, if more than one matching
	 * element is found, the results of each element will be separated by a comma.
	 * \todo maybe change the return type to List<String>
	 */
	@Override
	public String execute(SelectionType type, String searchParam, String returnParam) 
			throws InvalidQueryException
	{
		listResult = Select.selection(type, searchParam, returnParam, driver);
		stringResult = formatResults(listResult, returnParam);
		return stringResult;
	}

	/**
	 * The query to chain onto the back of the query run by the execute method. This chained query
	 * may only operate on one WebElement, so chose which element you wish to operate on using the
	 * elementNo parameter (if more than one is returned)
	 * @param elementNo the element that you wish to apply the chained query to.
	 * @param tQuery a terminatingQuery.
	 * @return String the results of the chained query.
	 */
	@Override 
	public String nextQuery(int elementNo, ElementQuery tQuery)
	{
		String res = tQuery.execute(listResult.get(elementNo-1));
		return res;
	}
	
	/** list of WebElements received from executing a query **/
	private List<WebElement> listResult;
	/** The result of the query as a string representation, initialised to 
	 * an empty string to avoid the first element of the result being null **/
	private String stringResult="";
	
	/**
	 * iterates through a list of WebElements and converts the result to a string
	 * @param resultList the input list of WebElements
	 * @param rParam the attribute that you wish to find.
	 * @return String representation of the attribute value. 
	 * (null implies no attribute value)
	 */
	private String formatResults(List<WebElement> resultList, String rParam)
	{
		String res = "";
		
		for(int i=0; i < listResult.size(); ++i)
		{
			res += (listResult.get(i).getAttribute(rParam))+"\n";
		}
		
		if(res=="")
		{res="Sorry, no elements found matching your criterion.";}
		
		return res;	
	}
	

}
