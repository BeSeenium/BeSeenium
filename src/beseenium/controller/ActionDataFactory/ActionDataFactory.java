package beseenium.controller.ActionDataFactory;
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
import java.util.HashMap;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.model.actionData.ActionData;

/**
 * This Class conforms to a 'factory' pattern, it allows the creation of different
 * ActionData instances 
 * @author JPC Hanson
 *
 */
public class ActionDataFactory implements MakeData
{
	/** container for string value pairs associated with this factory **/
	private  Map<String, MakeData> ActionDataMap;
	/** this is used by the RemoteWebDriver to create an appropriate browser simulation **/
	private  DesiredCapabilities capabilities;
	/** needed by the RemoteWebDriver, holds the location of the server to run simulations on **/
	private  URL URL;
	/**  **/
	private ActionData emptyActionData;
	
	/**
	 * default constructor, initialises internal map and populates it
	 * @throws MalformedURLException 
	 */
	public ActionDataFactory() throws MalformedURLException
	{
		super();
		this.emptyActionData = new ActionData();
		this.ActionDataMap = new HashMap<String, MakeData>();
		this.capabilities = new DesiredCapabilities();
		this.mapEntries();
	}
	
	
	
	/**
	 * when you wish to use the remote webdriver, then the capabilities must be set first, this method 
	 * provides a convenient way to set them.
	 * @param key the capability you wish to set
	 * @param value the value you wish to set it to.
	 * @throws MalformedURLException 
	 */
	public void setCapabilities(String key, String value) throws MalformedURLException
	{
		//if the key is not 'auth' set the capability requested
		if (key.contentEquals("auth")==false)
		{
			this.capabilities.setCapability(key, value);
			System.out.println(key+":"+capabilities.getCapability(key));
		}
		//if the key is 'auth' create a new URL given the value they have provided
		else
		{
			this.URL =new URL("http://" +value+ "@hub.browserstack.com/wd/hub");
			System.out.println(key+":"+URL);
		}
	}
	
	
	
	/**
	 * provides an ActionData devoid of any pre initialised data, i.e. completely empty.
	 * mostly used by ActionFactory.
	 * @return ActionData that is completely empty.
	 */
	@Override
	public ActionData makeActionData()
	{return this.emptyActionData;}
	
	
	
	/**
	 * make a specific actionData containing a specific WebDriver.
	 * @param ActionDataKey the type of ActionData you wish to specify.
	 * @return ActionData appropriate to the ActionDataKey passed in
	 * @throws ActionDataFactoryException if ActionDataKey does not correspond to 
	 * a known ActionData implementation.
	 */
	public ActionData makeActionData(String ActionDataKey) throws ActionDataFactoryException
	{
		//test to see if the user requests a remote ActionData.
		if(ActionDataKey.contentEquals("remote"))
		{return new ActionData(new RemoteWebDriver(this.URL, this.capabilities));}
		
		//otherwise if the ActionData they request doesnt exist throw an appropriate exception
		else if (this.ActionDataMap.containsKey(ActionDataKey)==false)
		{
			throw new ActionDataFactoryException("cannot create a '"+ActionDataKey
												+"'. please check spelling, or refer to docs");
		}
		
		//if all goes well get the ActionData that they have requested.
		else
		{return this.ActionDataMap.get(ActionDataKey).makeActionData();}
	}
	
	
	
	/**
	 * populate the map with 'MakeActionData' derived types
	 */
	private void mapEntries()
	{
		this.ActionDataMap.put("firefox", new MakeFirefoxData());
		this.ActionDataMap.put("noWindows",  new MakeHtmlUnitDriverData());
	}
}