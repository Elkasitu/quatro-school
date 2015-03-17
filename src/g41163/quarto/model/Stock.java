package g41163.quarto.model;

import java.util.ArrayList;

/**
 * A class representing the current stock of playable Piece objects
 * @author Adrian Torres
 *
 */
public class Stock
{
	
	private ArrayList<Piece> pieces;
	
	/**
	 * Constructor of the Stock class, initializes the pieces array with 16 possible combinations of color, filling, shape
	 * and size attributes for a Piece
	 */
	public Stock()
	{
		
		// Initialization of some basic variables to be used in the loop
		Color color = Color.WHITE;
		Filling filling = Filling.HOLLOW;
		Shape shape = Shape.ROUND;
		Size size = Size.SHORT;
		this.pieces = new ArrayList<Piece>();
		
		//TODO: Make the piece generator export to a .txt file so that the piece generation isn't done each time the program is executed
		
		for (int i = 0; i < 16; i++)
		{
			// Creation of the first object with the initial values of each variable
			this.pieces.add(new Piece(color, filling, shape, size));
			
			// Change of color each 8 pieces
			if ((i + 1) % 8 == 0)
				color = Color.BLACK;
			
			// Change of filling each 4 pieces
			if ((i + 1) % 4 == 0)
				filling = filling == Filling.HOLLOW ? Filling.SOLID : Filling.HOLLOW;
			
			// Change of shape each 2 pieces
			if ((i + 1) % 2 == 0)
				shape = shape == Shape.ROUND ? Shape.SQUARE : Shape.ROUND;
			
			// Change size for every piece
			size = size == Size.SHORT ? Size.TALL : Size.SHORT;
			
			// The end result will be 16 unique pieces
		}
	}
	
	/**
	 * Takes the number i piece from the pieces list
	 * @param i the index of the piece to be taken
	 * @return the piece at the i index of the pieces list
	 * @throws QuartoException if argument i is not between 0 and 16 (excluded)
	 */
	public Piece takePiece(int i) throws QuartoException
	{
		if (i < 0 || i >= 16)
			throw new QuartoException("Index out of range");
		
		Piece pieceTaken = this.pieces.get(i);
		this.pieces.remove(i);
		return pieceTaken;
	}
	
	/**
	 * Takes the first piece out of the stock (for testing purposes)
	 * @return the first piece (index 0) of the instance's pieces ArrayList
	 */
	public Piece takePiece()
	{
		Piece pieceTaken = this.pieces.get(0);
		this.pieces.remove(0);
		return pieceTaken;
	}
	
	/**
	 * Checks the current amount of playable pieces
	 * @return a number representing the amount of playable pieces
	 */
	public int size()
	{
		return this.pieces.size();
	}
	
	/**
	 * Checks if there are any more playable pieces
	 * @return a boolean indicating if the pieces list is empty
	 */
	public boolean isEmpty()
	{
		return this.pieces.isEmpty();
	}
	
	/**
	 * @return a string that lists all the current pieces in the stock.
	 */
	public String toString()
	{
		String toPrint = "";
		int counter = 0;
		for (Piece piece : this.pieces)
		{
			toPrint += counter + " " + piece.getColor() + " " + piece.getFilling() + " " + piece.getShape() + " " + piece.getSize() + "\n";

			counter++;
		}
		return toPrint;
	}
}
