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
	/** holds all the compositors **/
	private Map<String, AbstractCompositor> compositorMap;
	
	/**
	 * default constructor, populates the internal map and sets the default value for the 
	 * format as basicFormatter;
	 */
	public RootCompositor(AbstractOutputFormatter format)
	{
		super(format);
		
		compositorMap.put("execute", new ExecuteCompositor(super.formatter));
		compositorMap.put("addAction", new AddActionCompositor(super.formatter));
		compositorMap.put("browser", new BrowserCompositor(super.formatter));
		compositorMap.put("capabilities", new CapabilitiesCompositor(super.formatter));		
	}
	
	/**
	 * This method passes the string to be composited, on to the appropriate compositor where
	 * the string is transformed into the format provided in the constructor.
	 * @param compositor the specific compositor that you wish to call. i.e. execute,
	 * addAction,capabilities or browser.
	 * @param stringToBeFormatted the string to be formatted
	 * @return a string of the form specified by setFormat()
	 */
	@Override
	public String composite(String compositorString, String stringToComposite)
	{
		return this.compositorMap.get(compositorString)
											.composite(compositorString, stringToComposite);
	}
}
