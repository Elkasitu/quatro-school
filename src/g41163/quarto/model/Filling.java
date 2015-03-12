package g41163.quarto.model;

/**
 * An enum that represents the two possible fillings of a Quarto piece
 * @author Adrian Torres
 * 
 *
 */
public enum Filling
{
	HOLLOW('H'),
	SOLID('S');
	
	private char value;
	
	/**
	 * Constructor for the enum
	 * @param value the value given to every element of this enum
	 * 
	 */
	private Filling(char value)
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
