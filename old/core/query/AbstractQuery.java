
package core.query;

import org.openqa.selenium.WebDriver;

import core.query.ElementQuery.ElementQuery;
import core.selectors.SelectionType;

/**
 * A Query is a something that you can ask the browser to do with respect to a specific
 * web page or element..
 * @author JPC Hanson
 *
 */
public abstract class AbstractQuery
{
	
	/** 
	 * a query must be able to be executed but there are no guarantees as to what type it will
	 * return or the type of the parameter.
	 * @throws InvalidQueryException 
	 */
	public abstract String execute(SelectionType type, String param, String returnParam) throws InvalidQueryException;	
	
	public abstract String nextQuery(int elementNo, ElementQuery tQuery);
	
	/**
	 * constructor instanciates dervived classes with the WebDriver passed in
	 * @param browserDriver WebDriver that you wish to use for executing derived Query's
	 */
	protected AbstractQuery(WebDriver browserDriver)
	{
		this.driver = browserDriver;
	}
	
	/** the driver to be used by the execute methods of derived classes **/
	protected WebDriver driver;
}
