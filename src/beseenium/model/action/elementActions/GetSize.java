package beseenium.model.action.elementActions;
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
import java.util.List;

import org.openqa.selenium.WebElement;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This is a GetSize Action, It retrieves the size of the WebElement currently
 * stored in the ActionData.
 * @author JPC Hanson
 *
 */
public class GetSize extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetSize(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetSize action.
	 * @param n the index of the element to get the size of (as taken from the ActionData)
	 * @return String containing the size of the WebElement[n] contained in the ActionData.
	 * @throws ActionDataException
	 * @throws ActionException 
	 */
	@Override
	public String execute(int n) throws ActionDataException, ActionException 
	{
		List<WebElement> elements = super.context.getElement();			
		String result ="";
		
		if(n==-1)
		{
			for(int element = 0; element < elements.size(); ++element)
			{result += elements.get(element).getSize().toString()+" , ";}
			return result;
		}
		else
		{
			try
			{return elements.get(n).getSize().toString();}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
