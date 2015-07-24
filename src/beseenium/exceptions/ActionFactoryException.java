package beseenium.exceptions;

public class ActionFactoryException extends ActionException 
{
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = -264857503419965155L;

	/**
	 * default ctor
	 */
	public ActionFactoryException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public ActionFactoryException(String message)
	{
		super(message);
	}
}
