package g41163.quarto.model;

/**
 * An enum that represents the two possible colors of a Quarto piece
 * @author Adrian Torres
 * 
 *
 */
public enum Color
{
	WHITE('W'),
	BLACK('B');
	
	private char value;
	
	/**
	 * Constructor for the enum
	 * @param value the value given to every element of this enum
	 * 
	 */
	private Color(char value)
	{
		this.value = value;
	}
	
	/**
	 * 
	 * @return the first letter of the enum's value
	 */
	char asChar()
	{
		return this.value;
	}
}
