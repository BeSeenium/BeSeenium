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
 * This class provides methods to transform strings into JSON format.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public class JsonFormatter implements AbstractOutputFormatter
{
	/**
	 * default ctor
	 */
	public JsonFormatter()
	{super();}
	
	/**
	 * format the end JSON object
	 * @param stringToFormat string of the form 'V01 V02 ... V0n'
	 * @param label the label to apply to the end object.
	 * @return a string of the form '{"label":}'
	 */
	@Override
	public String finalForm(String label, String stringToFormat)
	{
		return "{\""+label+"\""+":"+""+stringToFormat+"}";
	}
	
	/**
	 * format a string as a JSON array
	 * @param stringToFormat string of the form 'V01 V02 ... V0n'
	 * @param label NOT USED
	 * @return a string of the form '[V01, V02 ... V03]'
	 */
	@Override
	public String asKVsuperSet(String label, String stringToFormat)
	{		
		return "["+stringToFormat+"]";
	}
	
	/**
	 * format a string as a JSON object
	 * @param stringToFormat string of the form 'V01 V02 ... V0n'
	 * @param label NOT USED
	 * @return string of the form '{V01, V02 ... V0n}'
	 */
	@Override
	public String asKVset(String Label, String stringToFormat)
	{
		return "{"+stringToFormat+"}";
	}
	
	/**
	 * formats a string as a JSON "key":"value" pair
	 * @param key a string representing the key
	 * @param value a string representing the value
	 * @return a string of the form '"key":"value"'
	 */
	@Override
	public String asKeyVal(String key,String value)
	{
		return "\""+key+"\""+":"+"\""+value+"\"";
	}
}
