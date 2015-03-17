package g41163.quarto.model;

/**
 * A class that represents the game board
 * @author Adrian Torres
 *
 */
public class Board
{
	public static final int SIZE = 4;
	
	private Piece[][] pieces;
	
	/**
	 * Argument-less constructor that initializes every element in the pieces matrix to null
	 */
	public Board()
	{
		this.pieces = new Piece[4][4];
	}
	
	/**
	 * Constructor that initializes every element in the pieces matrix to an element from the pieces argument array (sequentially)
	 * @param pieces an array of Piece objects
	 */
	public Board(Piece[] pieces)
	{
		this.pieces = new Piece[4][4];
		for (int row = 0; row < SIZE; row++)
			for (int col = 0; col < SIZE; col++)
				// col + row * 4 allows us to go through the 16 elements of the array pieces
				if (col + row * 4 < pieces.length)
					// we do this to avoid index out of bounds error
					this.pieces[row][col] = pieces[col + row * 4];
	}
	
	/**
	 * Checks if the given position is free on the game board
	 * @param position the position to be checked
	 * @return true if the position is free, false otherwise
	 */
	public boolean isFree(Position position)
	{
		if (pieces[position.getRow()][position.getColumn()] == null)
			return true;
		return false;
	}
	
	/**
	 * Adds the given piece at the given position in the game board
	 * @param piece the piece to be added
	 * @param position the position where the piece will be added
	 * @throws QuartoException if the given position isn't free
	 */
	public void addPiece(Piece piece, Position position) throws QuartoException
	{
		if (!isFree(position))
			throw new QuartoException();
		this.pieces[position.getRow()][position.getColumn()] = piece;
	}
	
	/**
	 * Representation of the board, rows, columns and the pieces on it
	 * @return returns a string that represents the board, columns, rows and the pieces on it
	 */
	public String toString()
	{
		// the "head" of the board never changes, is static, so we can just hardcode it
		// I use toPrint += to get a preview of how it would look like when printed
		String toPrint = "   #  1  #  2  #  3  #  4  #\n";
		toPrint +=		 "   #########################\n";
		
		// we loop through the board
		for(int i = 0; i < SIZE; i++)
		{
			// here we will hold the visual representation of the attributes for each piece
			// default value is space (" ") so that if there's no piece, the string format variable (%s)
			// will be replaced by a space so the layout is kept intact
			String[] colors = {" ", " ", " ", " "};
			String[] size = {" ", " ", " ", " "};
			String[] filling = {" ", " ", " ", " "};
			String[] shape = {" ", " ", " ", " "};
			
			for (int j = 0; j < SIZE; j++)
			{
				// we get the current object at the given indexes and we process it if it's a piece object
				Piece currentPiece = this.pieces[i][j];
				if (currentPiece != null)
				{
					// we get the visual representation of each attribute and put them into the corresponding local array
					colors[j] = Character.toString(currentPiece.getColor().asChar());
					size[j] = Character.toString(currentPiece.getSize().asChar());
					filling[j] = Character.toString(currentPiece.getFilling().asChar());
					shape[j] = Character.toString(currentPiece.getShape().asChar());
				}
					
			}
			
			// after each row we add 2 lines (visually representing one row) with the corresponding attributes
			toPrint += String.format(" %d # %s %s # %s %s # %s %s # %s %s #\n", i+1, colors[0], size[0], colors[1], size[1],
																					 colors[2], size[2], colors[3], size[3]);
			toPrint += String.format("   # %s %s # %s %s # %s %s # %s %s #\n",	    filling[0], shape[0], filling[1], shape[1],
					 																filling[2], shape[2], filling[3], shape[3]);
			toPrint += "   #########################\n";
		}		
		
		return toPrint;
	}
}
