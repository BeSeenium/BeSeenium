package beseenium.exception;

public class ClickException extends ActionException
{

	/**
	 * Serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = -1616537734173184555L;

	
	public ClickException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public ClickException(String message)
	{
		super(message);
	}

}
