package beseenium.exceptions.testExceptions;

import beseenium.exceptions.BeSeeniumException;

public class TestException extends BeSeeniumException 
{
	/**
	 * needed to avoid warning
	 */
	private static final long serialVersionUID = 2620333356090725352L;

	/**
	 * default constructor
	 */
	protected TestException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public TestException(String message)
	{
		super(message);
	}
}
