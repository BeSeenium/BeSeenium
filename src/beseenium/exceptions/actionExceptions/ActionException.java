package beseenium.exceptions.actionExceptions;

import beseenium.exceptions.BeSeeniumException;

public class ActionException extends BeSeeniumException 
{

	/**
	 * Serialisation needed to avoid warnings.
	 */
	private static final long serialVersionUID = -2121908009959867560L;
	

	
	public ActionException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public ActionException(String message)
	{
		super(message);
	}

}
