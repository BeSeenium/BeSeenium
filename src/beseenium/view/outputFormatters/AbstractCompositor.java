package beseenium.view.outputFormatters;
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
 * This is the abstract base class for all the compositors. compositors use a formatter provided
 * by a constructor argument to compose the output strings into the form that the user has
 * requested.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractCompositor
{
	/** reference to the formatter used e.g. JSON, basic, xml, etc **/
	protected AbstractOutputFormatter formatter;
	
	/**
	 * default constructor, sets the formatter. if not explicitly called then defaults to 
	 * BasicFormatter.
	 * @param format a formatter object
	 */
	protected AbstractCompositor(AbstractOutputFormatter format)
	{
		if(format == null)
		{this.formatter = new BasicFormatter();} //default value for formatter
		else
		{this.formatter = format;}
	}
	
	/**
	 * This method provides functionality that composites a string into the format 
	 * specified by the user during the creation of derived objects.
	 * @param compositorString
	 * @param stringToComposite
	 * @return String the composed string
	 */
	abstract String composite(String compositorString, String stringToComposite);
}
