package beseenium.controller;

import java.util.HashMap;
import java.util.Map;

import beseenium.action.AbstractAction;
import beseenium.action.elementActions.*;
import beseenium.action.findElementsBy.*;
import beseenium.action.navigateActions.*;
import beseenium.action.pageActions.*;
import beseenium.exceptions.ActionDataFactoryException;
import beseenium.exceptions.ActionFactoryException;

/**
 * 
 * @author JPC Hanson
 *\todo change to factory method map implementation
 */
public class ActionFactory 
{
	/**  **/
	private static Map<String, AbstractAction> actionMap;
	/**  **/
	private static final String internal = "internal";

	/**
	 * @throws ActionDataFactoryException 
	 * 
	 */
	public ActionFactory() throws ActionDataFactoryException
	{
		@SuppressWarnings("unused")
		ActionDataFactory actionDataFactory = new ActionDataFactory();
		ActionFactory.actionMap = new HashMap<String, AbstractAction>();
		populateActionMap();
	}
	
	/**
	 * creates an Action
	 * @return  AbstractAction
	 * @throws ActionFactoryException 
	 * @throws ActionDataFactoryException 
	 */
	public static AbstractAction makeAction(String actionKey) throws ActionFactoryException
	{
		if(actionMap.containsKey(actionKey))
		{return actionMap.get(actionKey);}
	else
		{throw new ActionFactoryException("you cannot instanciate this type of Action '"
					+actionKey+ "' Check your spelling, or refer to documentation");}
	}
	
	/**
	 * @throws ActionDataFactoryException 
	 * 
	 */
	private void populateActionMap() throws ActionDataFactoryException
	{
		//Page Actions
		actionMap.put( "PageGet", new PageGet(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetPageSrc", new GetPageSrc(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "BrowserQuit", new BrowserQuit(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetTitle", new GetTitle(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetURL", new GetURL(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "PageClose", new PageClose(ActionDataFactory.makeActionData(internal)));
		
		//Navigation Actions
		actionMap.put( "NavigateBack", new NavigateBack(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "NavigateForward", new NavigateForward(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "RefreshPage", new RefreshPage(ActionDataFactory.makeActionData(internal)));
		
		//Find Element Actions
		actionMap.put( "FindElementsByClass", new FindElementsByClass(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByCss", new FindElementsByCss(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsById", new FindElementsById(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByLinkTxt", new FindElementsByLinkTxt(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByName", new FindElementsByName(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByPartialLinkTxt", new FindElementsByPartialLinkTxt(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByTagName", new FindElementsByTagName(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByXpath", new FindElementsByXpath(ActionDataFactory.makeActionData(internal)));
		
		//Element Actions
		actionMap.put( "Clear", new Clear(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "Click", new Click(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetAttribute", new GetAttribute(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetCssValue", new GetCssValue(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetLocation", new GetLocation(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetSize", new GetSize(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetTagName", new GetTagName(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "GetText", new GetText(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "IsDisplayed", new IsDisplayed(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "IsEnabled", new IsEnabled(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "IsSelected", new IsSelected(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "SendKeys", new SendKeys(ActionDataFactory.makeActionData(internal)));
		actionMap.put( "Submit", new Submit(ActionDataFactory.makeActionData(internal)));
		
		
	}
}
