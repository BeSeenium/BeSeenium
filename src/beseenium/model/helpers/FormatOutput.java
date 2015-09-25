package beseenium.model.helpers;
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
/**
 * This helper class provides methods to format the output of individual actions.
 *
 * @author Jan P.C. Hanson
 *
 */
public class FormatOutput 
{
	/**
	 * formats the output string of a findElementBy... output string
	 * @param elements a List<WebElement> containing all elements to be formatted
	 * @param n an integer value determining which element to act on, if n = -1 then all elements
	 * in the list will be formatted.
	 * @return String containing the formatted output.
	 */
	public static String formatFindElementOutput(List<WebElement> elements, int n)
	{
		String tempRes = "";
		
		if(n == -1)
		{
			for(int i=0; i<= elements.size(); ++i)
			{
				tempRes += elements.get(i).toString();
			}
		
		return tempRes;
		}
		
		else
		{
			return elements.get(n).toString();
		}	
	}
}
