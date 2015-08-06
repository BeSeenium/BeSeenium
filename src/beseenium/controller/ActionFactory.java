package beseenium.controller;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.model.action.AbstractAction;
import beseenium.model.action.elementActions.*;
import beseenium.model.action.findElementsBy.*;
import beseenium.model.action.navigateActions.*;
import beseenium.model.action.pageActions.*;

/**
 * 
 * @author JPC Hanson
 *\todo change to factory method map implementation
 */
public class ActionFactory 
{
	/**  **/
	private Map<String, AbstractAction> actionMap;
	/**  **/
	private final String internal = "internal";
	/**  **/
	private ActionDataFactory actionDataFactory;

	/**
	 * @throws ActionDataFactoryException 
	 * @throws MalformedURLException 
	 * 
	 */
	public ActionFactory(ActionDataFactory actionDataFactory) 
			throws ActionDataFactoryException, MalformedURLException
	{
		this.actionDataFactory = actionDataFactory;
		this.actionMap = new HashMap<String, AbstractAction>();
		this.populateActionMap();
	}
	
	/**
	 * creates an Action
	 * @return  AbstractAction
	 * @throws ActionFactoryException 
	 * @throws ActionDataFactoryException 
	 */
	public AbstractAction makeAction(String actionKey) throws ActionFactoryException
	{
		if(this.actionMap.containsKey(actionKey))
		{return this.actionMap.get(actionKey);}
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
		actionMap.put( "PageGet", new PageGet(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetPageSrc", new GetPageSrc(actionDataFactory.makeActionData(internal)));
		actionMap.put( "BrowserQuit", new BrowserQuit(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetTitle", new GetTitle(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetURL", new GetURL(actionDataFactory.makeActionData(internal)));
		actionMap.put( "PageClose", new PageClose(actionDataFactory.makeActionData(internal)));
		
		//Navigation Actions
		actionMap.put( "NavigateBack", new NavigateBack(actionDataFactory.makeActionData(internal)));
		actionMap.put( "NavigateForward", new NavigateForward(actionDataFactory.makeActionData(internal)));
		actionMap.put( "RefreshPage", new RefreshPage(actionDataFactory.makeActionData(internal)));
		
		//Find Element Actions
		actionMap.put( "FindElementsByClass", new FindElementsByClass(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByCss", new FindElementsByCss(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsById", new FindElementsById(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByLinkTxt", new FindElementsByLinkTxt(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByName", new FindElementsByName(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByPartialLinkTxt", new FindElementsByPartialLinkTxt(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByTagName", new FindElementsByTagName(actionDataFactory.makeActionData(internal)));
		actionMap.put( "FindElementsByXpath", new FindElementsByXpath(actionDataFactory.makeActionData(internal)));
		
		//Element Actions
		actionMap.put( "Clear", new Clear(actionDataFactory.makeActionData(internal)));
		actionMap.put( "Click", new Click(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetAttribute", new GetAttribute(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetCssValue", new GetCssValue(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetLocation", new GetLocation(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetSize", new GetSize(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetTagName", new GetTagName(actionDataFactory.makeActionData(internal)));
		actionMap.put( "GetText", new GetText(actionDataFactory.makeActionData(internal)));
		actionMap.put( "IsDisplayed", new IsDisplayed(actionDataFactory.makeActionData(internal)));
		actionMap.put( "IsEnabled", new IsEnabled(actionDataFactory.makeActionData(internal)));
		actionMap.put( "IsSelected", new IsSelected(actionDataFactory.makeActionData(internal)));
		actionMap.put( "SendKeys", new SendKeys(actionDataFactory.makeActionData(internal)));
		actionMap.put( "Submit", new Submit(actionDataFactory.makeActionData(internal)));
		
		
	}
}
