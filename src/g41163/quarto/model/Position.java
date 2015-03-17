package g41163.quarto.model;

/**
 * A class that represents a piece's position on the game board
 * @author Adrian Torres
 *
 */
public class Position
{
	
	private final int row;
	private final int column;
	
	/**
	 * The constructor sets the initial and final values for row and column
	 * @param row represents the y coordinate within the game's board
	 * @param column represents the x coordinate within the game's board
	 * @throws IllegalArgumentException if any of the arguments is negative
	 */
	public Position(int row, int column)
	{
		// Starting from 0 instead of 1 because normal programmers start counting from 0...
		if (row < 0 || column < 0 || row >= Board.SIZE || column >= Board.SIZE)
			throw new IllegalArgumentException("Row and Column must be positive integers");
		this.row = row;
		this.column = column;
	}
	
	/**
	 * Getter for the row attribute
	 * @return the row attribute
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * Getter for the column attribute
	 * @return the column attribute
	 */
	public int getColumn()
	{
		return this.column;
	}

}
