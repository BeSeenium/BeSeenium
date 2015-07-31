package beseenium.exceptions.testExceptions;

public class TestAlreadyExistsException extends TestException 
{
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = -4809217893822758020L;

	/**
	 * default constructor
	 */
	protected TestAlreadyExistsException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public TestAlreadyExistsException(String message)
	{
		super(message);
	}
}
