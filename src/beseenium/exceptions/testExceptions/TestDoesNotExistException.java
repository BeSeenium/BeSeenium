package beseenium.exceptions.testExceptions;

public class TestDoesNotExistException extends TestException 
{
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = 6407310411521085773L;

	/**
	 * default constructor
	 */
	protected TestDoesNotExistException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public TestDoesNotExistException(String message)
	{
		super(message);
	}
}
