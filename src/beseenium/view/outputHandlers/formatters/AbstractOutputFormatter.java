package beseenium.view.outputHandlers.formatters;
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
import beseenium.helpers.CopyrightIgnore;
/**
 * Interface that all output formatter classes should subscribe to, allowing the servlet to 
 * request an appropriate output format specific to a users request.
 * 
 * Output formatting is divided into 4 generic sections which should be able to apply to all
 * formats that the user could request:</br>
 * 
 * **KeyVal** a key value pair, in the case of JSON this would be "key":"value" for XML it would
 * be <key>value</key> and so on.</br>
 * 
 * **KVset** this is a set of key value pairs organised in a way that makes sense to the output
 * type: JSON: {"key1":"val1", "key2":"val2", etc} XML:<setName><key1>value1</key1><key2>value2
 * </key2></setName> and so on.</br>
 * 
 * **KVsuperSet** this is a set of key value sets organised in a way that makes sense to the 
 * output type
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface AbstractOutputFormatter
{
	/**
	 * format the given string as a key value pair specific to the derived type.
	 * @param stringToFormat the string to format
	 * @return String formatted as requested
	 */
	public String asKeyVal(String key, String val);
	
	/**
	 * format the given string as a key value set specific to the derived type.
	 * @param stringToFormat the string to format
	 * @param label a string to use as a label in the KVSet (optional)
	 * @return String formatted as requested
	 */
	public String asKVset(String label, String stringToFormat);
	
	/**
	 * format the given string as a key value super set specific to the derived type.
	 * @param stringToFormat the string to format
	 * @param label a string to use as a label in the KVsuperSet (optional)
	 * @return String formatted as requested
	 */
	public String asKVsuperSet(String label, String stringToFormat);
	
	/**
	 * do some final formatting on the given string to put it in the final form specific to 
	 * the derived type.
	 * @param stringToFormat the string to format
	 * @param label a string to use as a label in the final form (optional)
	 * @return String formatted as requested
	 */
	public String finalForm(String label, String stringToFormat);
}
