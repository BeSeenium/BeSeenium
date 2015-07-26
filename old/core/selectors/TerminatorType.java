package core.selectors;

/**
 * this enum is used in conjucntion with the select class to select the appropriate terminatingQuery
 * @author JPC Hanson
 *
 */
public enum TerminatorType 
{
	/** selects clear object **/
	clear,
	/** selects click object **/
	click,
	/** selects location object **/
	location,
	/** selects size object **/
	size,
	/** selects text object **/
	text,
	/** selects tagName object **/
	tagName,
	/** selects isDisplayed object **/
	isDisplayed,
	/** selects isEnabled object **/
	isEnabled,
	/** selects isSelected object **/
	isSelected,
	/** selects sendkeys object **/
	sendKeys,
	/** selects submit object **/
	submit,
	
}
