package beseenium.view.outputHandlers.compositors;

import java.util.Arrays;

import beseenium.view.helpers.StringSplit;
import beseenium.view.outputHandlers.formatters.AbstractOutputFormatter;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class AddActionCompositor extends AbstractCompositor
{

	/**
	 * @param format
	 */
	protected AddActionCompositor(AbstractOutputFormatter format)
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
	public String composite(String compositorString, String stringToComposite)
	{
		if(this.containsError(stringToComposite)) 
		{return this.finalFormat("	{"+stringToComposite+"}\n");}
		
		String[][] results = StringSplit.generic2d(stringToComposite, "~", ",");
		String formattedResult = new String();
		
		for(int i = 0 ; i < results.length ; ++i) 
		{
			if(i < results.length-2) //with comma delimiter
			{
				formattedResult+=this.format(i,results, ",");
			}
			
			else//without comma delimiter
			{
				formattedResult += this.format(i,results, "");
			}
		}
		return this.finalFormat(formattedResult);
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
					this.formatter.asKeyVal("Action", Integer.toString(actionNo+1), ", ")+
					this.formatter.asKeyVal("Name", results[actionNo][0], ", ")+
					this.formatter.asKeyVal("Parameter", results[actionNo][1], ", ")+
					this.formatter.asKeyVal("Index", results[actionNo][2], "")
					, delimiter+"\n");
	}
	
	/**
	 * does the final formatting of the JSON object
	 * @param results the previously formatted results
	 * @return fully formatted JSON
	 */
	private String finalFormat(String formattedResults)
	{
		return this.formatter.finalForm
				(
					"Actions",this.formatter.asKVsuperSet("\n", formattedResults, ""),","
				);
	}
	
	/**
	 * check if result string contains "!!ERROR!!"
	 * @param msg String to check
	 * @return true if contains, false otherwise.
	 */
	private boolean containsError(String msg)
	{
		if(msg.contains("!!ERROR!!")) {return true;}
		else {return false;}
	}
}
