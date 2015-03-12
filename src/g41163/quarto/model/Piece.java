package g41163.quarto.model;

/**
 * Represents a piece in the game of Quarto
 * @author Adrian Torres
 *
 */
public class Piece
{
	private Color color;
	private Filling filling;
	private Shape shape;
	private Size size;
	
	/**
	 * Constructor for the Piece class
	 * @param color enum of type Color representing the piece's color
	 * @param filling enum of type Filling representing the piece's filling
	 * @param shape enum of type Shape representing the piece's shape
	 * @param size enum of type Size representing the piece's size
	 */
	public Piece(Color color, Filling filling, Shape shape, Size size)
	{
		this.color = color;
		this.filling = filling;
		this.shape = shape;
		this.size = size;
	}
	
	/**
	 * Gets the color of the current Piece object
	 * @return the color of the current Piece object
	 */
	public Color getColor()
	{
		return this.color;
	}
	
	/**
	 * Gets the filling of the current Piece object
	 * @return the filling of the current Piece object
	 */
	public Filling getFilling()
	{
		return this.filling;
	}
	
	/**
	 * Gets the shape of the current Piece object
	 * @return the shape of the current Piece object
	 */
	public Shape getShape()
	{
		return this.shape;
	}
	
	/**
	 * Gets the size of the current Piece object
	 * @return the size of the current Piece object
	 */
	public Size getSize()
	{
		return this.size;
	}
	
	/**
	 * 
	 * @return A string composed of the Piece's attributes
	 */
	public String toString()
	{
		return getColor() + " " + getSize() + " " + getFilling() + " " + getShape();
	}
}
