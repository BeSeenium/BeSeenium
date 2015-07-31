package beseenium.exceptions.actionExceptions;


public class NoSuchParameterException extends ActionException 
{
	
	/**
	 * serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = -4253915626939934718L;

	public NoSuchParameterException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public NoSuchParameterException(String message)
	{
		super(message);
	}
}
