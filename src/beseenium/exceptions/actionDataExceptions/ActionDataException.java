package beseenium.exceptions.actionDataExceptions;

import beseenium.exceptions.BeSeeniumException;

public class ActionDataException extends BeSeeniumException {

	/**
	 * serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = 5028456643209737119L;

	public ActionDataException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public ActionDataException(String message)
	{
		super(message);
	}
}
