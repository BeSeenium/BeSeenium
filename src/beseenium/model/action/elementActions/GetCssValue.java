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
 * this is a Get CSS Action, it retrieves the value of a specific CSS property. The
 * property that you wish to find is defined in the ActionData object, so make sure that
 * you set this to reflect the CSS property you wish to find the value of before passing it
 * to this action.
 * @author JPC Hanson
 *
 */
public class GetCssValue extends AbstractAction 
{
	/**
	 * constructor, initialises Action using the ActionData passed in as a param
	 * @param context an ActionData
	 */
	public GetCssValue(ActionData context) 
	{super(context);}
	
	/**
	 * This performs a GetCss action.
	 * @param n the index of the element to get a CSS value of (as taken from the ActionData)
	 * @return String containing the value of the CSS value set in the input parameter
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
			{result += elements.get(element).getCssValue(super.context.getInputParam())+" , ";}
			return result;
		}
		else
		{
			try
			{return elements.get(n).getCssValue(super.context.getInputParam());}
		
			catch (IndexOutOfBoundsException e)
			{throw new ActionException(this.toString()+": you provided an invalid index");}
		}
	}
}
