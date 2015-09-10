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
 * This class provides methods to transform strings into JSON format.
 * @author Jan P.C. Hanson
 *
 */
public class JsonFormatter extends AbstractOutputFormatter
{
	/**
	 * format a string as a JSON array
	 * @param stringToFormat string of the form 'V01 V02 ... V0n'
	 * @return a string of the form '[V01, V02 ... V03]'
	 */
	public String asArray(String stringToFormat)
	{
		
		return null;
	}
	
	/**
	 * format a string as a JSON object
	 * @param stringToFormat string of the form 'V01 V02 ... V0n'
	 * @return string of the form '{V01, V02 ... V0n}'
	 */
	public String asObject(String stringToFormat)
	{
		return null;
	}
	
	/**
	 * formats a string as a JSON "key":"value" pair
	 * @param key a string representing the key
	 * @param value a string representing the value
	 * @return a string of the form '"key":"value"'
	 */
	public String asKeyVal(String key,String value)
	{
		return null;
	}
}
