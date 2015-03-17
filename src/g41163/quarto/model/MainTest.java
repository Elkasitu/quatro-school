package g41163.quarto.model;

/**
 * A class that tests the integration of all the components necessary for the game to work
 * @author Adrian Torres
 *
 */
public class MainTest
{
	/**
	 * Called when the class is ran, testing the integration of all of the game's components
	 * @param args execution arguments
	 * @throws QuartoException
	 */
	public static void main(String[] args) throws QuartoException
	{
		Board board = new Board();
		Stock stock = new Stock();
		Position[] positions = {new Position(0, 0), new Position(3, 2), new Position(1, 1)};
		
		System.out.println(board.toString());
		System.out.println(stock.toString());
		
		for (int i = 0; i < 3; i++)
			board.addPiece(stock.takePiece(stock.size() - 1), positions[i]);
		
		System.out.println(board.toString());
		System.out.println(stock.size());
		System.out.println(stock.toString());
	}
}
