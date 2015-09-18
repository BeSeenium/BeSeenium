package beseenium.view.outputHandlers.compositors;

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
	String composite(String compositorString, String stringToComposite)
	{
		
		return null;
	}
}
