package core.selectors;

/**
 * This enum represents types of selection criterion appropriate to a chainable query
 * 
 * @author JPC Hanson
 *
 */
public enum SelectionType 
{
	/** select element by name attribute **/
	byName,
	/** select element by id attribute **/
	byId, 
	/** select element by link text **/
	byLinkTxt,
	/** select element by tag name **/
	byTagName,
	/** select element by partial link text **/
	byPartialLinkTxt,
	/** select element by xpath string **/
	byXpath, 
	/** select element by class attribute **/
	byClass,
	/** select element using CSS selectors **/
	byCss
}
