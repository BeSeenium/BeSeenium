package beseenium.controller.ActionFactory;
/** Copyright(C) 2015 Jan P.C. Hanson & BeSeen Marketing Ltd
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import beseenium.controller.ActionDataFactory.ActionDataFactory;
import beseenium.controller.ActionFactory.elementActions.MakeClear;
import beseenium.controller.ActionFactory.elementActions.MakeClick;
import beseenium.controller.ActionFactory.elementActions.MakeGetAttribute;
import beseenium.controller.ActionFactory.elementActions.MakeGetCssValue;
import beseenium.controller.ActionFactory.elementActions.MakeGetLocation;
import beseenium.controller.ActionFactory.elementActions.MakeGetSize;
import beseenium.controller.ActionFactory.elementActions.MakeGetTagName;
import beseenium.controller.ActionFactory.elementActions.MakeGetText;
import beseenium.controller.ActionFactory.elementActions.MakeIsDisplayed;
import beseenium.controller.ActionFactory.elementActions.MakeIsEnabled;
import beseenium.controller.ActionFactory.elementActions.MakeIsSelected;
import beseenium.controller.ActionFactory.elementActions.MakeSendKeys;
import beseenium.controller.ActionFactory.elementActions.MakeSubmit;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByClass;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByCss;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsById;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByLinkTxt;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByName;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByPartialLinkTxt;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByTagName;
import beseenium.controller.ActionFactory.findElementsBy.MakeFindElementsByXpath;
import beseenium.controller.ActionFactory.navigateActions.MakeNavigateBack;
import beseenium.controller.ActionFactory.navigateActions.MakeNavigateForward;
import beseenium.controller.ActionFactory.navigateActions.MakeRefreshPage;
import beseenium.controller.ActionFactory.pageActions.MakeBrowserQuit;
import beseenium.controller.ActionFactory.pageActions.MakeGetPageSrc;
import beseenium.controller.ActionFactory.pageActions.MakeGetTitle;
import beseenium.controller.ActionFactory.pageActions.MakeGetURL;
import beseenium.controller.ActionFactory.pageActions.MakePageClose;
import beseenium.controller.ActionFactory.pageActions.MakePageGet;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.model.action.AbstractAction;

/**
 * this class is a factory for creating actions, it uses a factory method
 * style pattern and a map implementation.
 * @author JPC Hanson
 *
 */
public class ActionFactory 
{
	/** the map to store the actions in **/
	private Map<String, MakeAction> actionMap;
	/** internal ActionDataFactory reference **/
	private ActionDataFactory actionDataFactory;

	/**
	 * default constructor creates and populates internal map 
	 * @param actionDataFactory 
	 * @throws ActionDataFactoryException 
	 * @throws MalformedURLException 
	 * 
	 */
	public ActionFactory(ActionDataFactory actionDataFactory) 
			throws ActionDataFactoryException, MalformedURLException
	{
		super();
		this.actionDataFactory = actionDataFactory;
		this.actionMap = new HashMap<String, MakeAction>();
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
		{return this.actionMap.get(actionKey).makeAction();}
	else
		{throw new ActionFactoryException("you cannot instanciate this type of Action '"
					+actionKey+ "' Check your spelling, or refer to documentation");}
	}
	
	/**
	 * creates all possible actions and populates the map with them.
	 * @throws ActionDataFactoryException 
	 * 
	 */
	private void populateActionMap() throws ActionDataFactoryException
	{
//		//Page Actions
		this.actionMap.put( "PageGet", new MakePageGet(actionDataFactory));
		this.actionMap.put( "GetPageSrc", new MakeGetPageSrc(actionDataFactory));
		this.actionMap.put( "BrowserQuit", new MakeBrowserQuit(actionDataFactory));
		this.actionMap.put( "GetTitle", new MakeGetTitle(actionDataFactory));
		this.actionMap.put( "GetURL", new MakeGetURL(actionDataFactory));
		this.actionMap.put( "PageClose", new MakePageClose(actionDataFactory));
		
//		//Navigation Actions
		this.actionMap.put( "NavigateBack", new MakeNavigateBack(actionDataFactory));
		this.actionMap.put( "NavigateForward", new MakeNavigateForward(actionDataFactory));
		this.actionMap.put( "RefreshPage", new MakeRefreshPage(actionDataFactory));
		
//		//Find Element Actions
		this.actionMap.put( "FindElementsByClass", new MakeFindElementsByClass(actionDataFactory));
		this.actionMap.put( "FindElementsByCss", new MakeFindElementsByCss(actionDataFactory));
		this.actionMap.put( "FindElementsById", new MakeFindElementsById(actionDataFactory));
		this.actionMap.put( "FindElementsByLinkTxt", new MakeFindElementsByLinkTxt(actionDataFactory));
		this.actionMap.put( "FindElementsByName", new MakeFindElementsByName(actionDataFactory));
		this.actionMap.put( "FindElementsByPartialLinkTxt", new MakeFindElementsByPartialLinkTxt(actionDataFactory));
		this.actionMap.put( "FindElementsByTagName", new MakeFindElementsByTagName(actionDataFactory));
		this.actionMap.put( "FindElementsByXpath", new MakeFindElementsByXpath(actionDataFactory));
		
//		//Element Actions
		this.actionMap.put( "Clear", new MakeClear(actionDataFactory));
		this.actionMap.put( "Click", new MakeClick(actionDataFactory));
		this.actionMap.put( "GetAttribute", new MakeGetAttribute(actionDataFactory));
		this.actionMap.put( "GetCssValue", new MakeGetCssValue(actionDataFactory));
		this.actionMap.put( "GetLocation", new MakeGetLocation(actionDataFactory));
		this.actionMap.put( "GetSize", new MakeGetSize(actionDataFactory));
		this.actionMap.put( "GetTagName", new MakeGetTagName(actionDataFactory));
		this.actionMap.put( "GetText", new MakeGetText(actionDataFactory));
		this.actionMap.put( "IsDisplayed", new MakeIsDisplayed(actionDataFactory));
		this.actionMap.put( "IsEnabled", new MakeIsEnabled(actionDataFactory));
		this.actionMap.put( "IsSelected", new MakeIsSelected(actionDataFactory));
		this.actionMap.put( "SendKeys", new MakeSendKeys(actionDataFactory));
		this.actionMap.put( "Submit", new MakeSubmit(actionDataFactory));	
	
	}
}
