package g41163.quarto.model;

/**
 * A class for the QuartoException exception, handles incoherences in the g41163.quarto.model package
 * @author Adrian Torres
 *
 */
@SuppressWarnings("serial")
public class QuartoException extends Exception
{
	/**
	 * No-argument constructor
	 */
	public QuartoException() {}
	
	/**
	 * Constructor, sends the error message to the super class
	 * @param message sent to the super class for the error message to be displayed
	 */
	public QuartoException(String message)
	{
		super(message);
	}
}
