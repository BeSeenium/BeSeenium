package beseenium.view.outputHandlers.compositors;

import beseenium.view.helpers.StringSplit;
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
public class CapabilitiesCompositor extends AbstractCompositor
{

	/**
	 * specifies the format that the user wishes the output returned in e.g. JSON, XML, etc
	 * @param format the format that the user wishes the output returned in e.g. JSON, XML, etc
	 */
	public CapabilitiesCompositor(AbstractOutputFormatter format)
	{
		super(format);
	}

	/**
	 * This method provides functionality to composite the string into the format specified by
	 * the user on creation of this object.
	 * @param compositorString representation of the type of string that this is i.e. execute,
	 * addAction, capabilities or browser.
	 * @param stringToComposite the string that requires formatting
	 * @return String the formatted string.
	 */
	@Override
	public String composite(String compositorString, String stringToComposite)
	{
		String[][] results = StringSplit.generic2d(stringToComposite, "~", ",");
		String formattedResult = new String();
		
		for(int i = 0 ; i < results.length ; ++i) 
		{
			if(i < results.length-1) //with comma delimiter
			{
				formattedResult+=this.format(i,results, ",");
			}
			
			else//without comma delimiter
			{
				formattedResult += this.format(i,results, "");
			}
		}
		return this.finalFormat(formattedResult, compositorString);
	}
	
	/**
	 * does the formatting of the keyVal and KVset
	 * @param actionNo the number of the action to use as a key in the KeyVal
	 * @param result the result to use as the value of a KeyVal
	 * @param delimiter string delimiter to add to the end of each KVset
	 * @return String of the form {"action":"actionNo", "result":"result value"}
	 */
	private String format(int actionNo, String[][] results, String delimiter)
	{
		return this.formatter.asKVset("	",
					this.formatter.asKeyVal("Name", results[actionNo][0], ",")+
					this.formatter.asKeyVal("Value", results[actionNo][1], "")
					, delimiter+"\n");
	}
	
	/**
	 * does the final formatting of the JSON object
	 * @param results the previously formatted results
	 * @return fully formatted JSON
	 */
	private String finalFormat(String formattedResults, String label)
	{
		return this.formatter.finalForm
				(
					label,this.formatter.asKVsuperSet("\n", formattedResults, ""),","
				);
	}
}
