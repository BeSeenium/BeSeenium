package beseenium.controller;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import beseenium.controller.ActionDataFactory.ActionDataFactory;
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
 *
 */
public class ActionFactory 
{
	/**  **/
	private Map<String, AbstractAction> actionMap;
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
		this.actionMap.put( "PageGet", new PageGet(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetPageSrc", new GetPageSrc(actionDataFactory.makeActionData()));
		this.actionMap.put( "BrowserQuit", new BrowserQuit(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetTitle", new GetTitle(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetURL", new GetURL(actionDataFactory.makeActionData()));
		this.actionMap.put( "PageClose", new PageClose(actionDataFactory.makeActionData()));
		
		//Navigation Actions
		this.actionMap.put( "NavigateBack", new NavigateBack(actionDataFactory.makeActionData()));
		this.actionMap.put( "NavigateForward", new NavigateForward(actionDataFactory.makeActionData()));
		this.actionMap.put( "RefreshPage", new RefreshPage(actionDataFactory.makeActionData()));
		
		//Find Element Actions
		this.actionMap.put( "FindElementsByClass", new FindElementsByClass(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByCss", new FindElementsByCss(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsById", new FindElementsById(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByLinkTxt", new FindElementsByLinkTxt(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByName", new FindElementsByName(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByPartialLinkTxt", new FindElementsByPartialLinkTxt(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByTagName", new FindElementsByTagName(actionDataFactory.makeActionData()));
		this.actionMap.put( "FindElementsByXpath", new FindElementsByXpath(actionDataFactory.makeActionData()));
		
		//Element Actions
		this.actionMap.put( "Clear", new Clear(actionDataFactory.makeActionData()));
		this.actionMap.put( "Click", new Click(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetAttribute", new GetAttribute(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetCssValue", new GetCssValue(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetLocation", new GetLocation(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetSize", new GetSize(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetTagName", new GetTagName(actionDataFactory.makeActionData()));
		this.actionMap.put( "GetText", new GetText(actionDataFactory.makeActionData()));
		this.actionMap.put( "IsDisplayed", new IsDisplayed(actionDataFactory.makeActionData()));
		this.actionMap.put( "IsEnabled", new IsEnabled(actionDataFactory.makeActionData()));
		this.actionMap.put( "IsSelected", new IsSelected(actionDataFactory.makeActionData()));
		this.actionMap.put( "SendKeys", new SendKeys(actionDataFactory.makeActionData()));
		this.actionMap.put( "Submit", new Submit(actionDataFactory.makeActionData()));		
	}
}
