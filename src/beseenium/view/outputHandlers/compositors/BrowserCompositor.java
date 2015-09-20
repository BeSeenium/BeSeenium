package beseenium.view.outputHandlers.compositors;

import beseenium.view.outputHandlers.formatters.AbstractOutputFormatter;
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
public class BrowserCompositor extends AbstractCompositor
{

	/**
	 * @param format
	 */
	protected BrowserCompositor(AbstractOutputFormatter format)
	{super(format);}

	/**
	 * This method provides functionality to composite the string into the format specified by
	 * the user on creation of this object.
	 * @param compositorString representation of the type of string that this is i.e. execute,
	 * addAction, capabilities or browser.
	 * @param stringToComposite the string that requires formatting
	 * @return String the formatted string.
	 */
	@Override
	String composite(String compositorString, String stringToComposite)
	{
		return this.formatter.finalForm("Browser", "\""+stringToComposite+"\"", ",");
	}
}
