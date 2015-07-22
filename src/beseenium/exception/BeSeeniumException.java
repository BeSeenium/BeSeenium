package beseenium.exception;

/**
 * the root class for the beseenium exception hierarchy
 * @author JPC Hanson
 *
 */
public abstract class BeSeeniumException extends Exception 
{
	/**
	 * Serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = 5427176352533290074L;
	
	/**
	 * default constructor
	 */
	protected BeSeeniumException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public BeSeeniumException(String message)
	{
		super(message);
	}
}
