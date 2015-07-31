package beseenium.exceptions.actionDataExceptions;


public class ActionDataFactoryException extends ActionDataException 
{

	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = 9057616264921236836L;

	/**
	 * 
	 */
	public ActionDataFactoryException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public ActionDataFactoryException(String message)
	{
		super(message);
	}
}
