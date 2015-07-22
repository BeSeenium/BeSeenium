package beseenium.exception;

public class SubmitException extends ActionException 
{
	/**
	 * serialisation required to avoid warnings
	 */
	private static final long serialVersionUID = 5614307891089020664L;

	public SubmitException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public SubmitException(String message)
	{
		super(message);
	}
}
