package beseenium.view.outputFormatters;

import java.util.Map;

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

/**
 * 
 * @author Jan P.C. Hanson
 *
 */
public class RootCompositor extends AbstractCompositor
{
	/** holds all the AbstractOutputFormatters **/
	private Map<String, AbstractCompositor> compositorMap;
	/** the formatter to be used **/
	AbstractOutputFormatter formatter;
	
	/**
	 * default constructor, populates the internal map and sets the default value for the 
	 * format as basicFormatter;
	 */
	public RootCompositor(AbstractOutputFormatter format)
	{
		super();
		
		if(format == null)
		{this.formatter = new BasicFormatter();} //default value for formatter
		
		else
		{this.formatter = format;}
		
		compositorMap.put("execute", new ExecuteCompositor());
		compositorMap.put("addAction", new AddActionCompositor());
		compositorMap.put("browser", new BrowserCompositor());
		compositorMap.put("capabilities", new CapabilitiesCompositor());		
	}
	
	/**
	 * This method formats a string into the specific format specified using the setFormat 
	 * method.
	 * @param formatterType the specific output formatter that you wish to call. i.e. execute,
	 * addAction,capabilities or browser.
	 * @param stringToBeFormatted the string to be formatted
	 * @return a string of the form specified by setFormat()
	 */
	public String formatOutput(String formatterType, String stringToBeFormatted)
	{
		
		return null;
	}
}
