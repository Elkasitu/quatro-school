package g41163.quarto.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases for every class in the package
 * @author Adrian Torres
 *
 */
public class JUnitTests
{

	// ENUMS
	
	@Test
	/**
	 * Tests that the Color enum works properly
	 */
	public void testColor()
	{
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		assertEquals(black.asChar(), 'B');
		assertEquals(white.asChar(), 'W');
	}
	
	@Test
	/**
	 * Tests that the Filling enum works properly
	 */
	public void testFilling()
	{
		Filling solid = Filling.SOLID;
		Filling hollow = Filling.HOLLOW;
		assertEquals(solid.asChar(), 'S');
		assertEquals(hollow.asChar(), 'H');
	}
	
	@Test
	/**
	 * Tests that the Shape enum works properly
	 */
	public void testShape()
	{
		Shape square = Shape.SQUARE;
		Shape round = Shape.ROUND;
		assertEquals(square.asChar(), 'S');
		assertEquals(round.asChar(), 'R');
	}
	
	@Test
	/**
	 * Tests that the Size enum works properly
	 */
	public void testSize()
	{
		Size tall = Size.TALL;
		Size notTall = Size.SHORT;
		assertEquals(tall.asChar(), 'T');
		assertEquals(notTall.asChar(), 'S');
	}
	
	// CLASSES
	
	@Test
	/**
	 * Tests that the Piece class' toString() method works properly
	 */
	public void testPieceToString()
	{
		Piece piece = new Piece(Color.BLACK, Filling.SOLID, Shape.SQUARE, Size.SHORT);
		assertEquals(piece.toString(), "BLACK SHORT SOLID SQUARE");
	}
	
	@Test
	/**
	 * Tests that the takePiece() method from the Stock class works properly
	 * @throws QuartoException
	 */
	public void testStockTakePiece() throws QuartoException
	{
		Stock stock = new Stock();
		// We test that the taken piece is in fact the first piece of the list
		Piece testPiece = stock.takePiece();
		assertEquals(testPiece.getSize(), Size.SHORT);
		assertEquals(testPiece.getColor(), Color.WHITE);
		assertEquals(testPiece.getFilling(), Filling.HOLLOW);
		assertEquals(testPiece.getShape(), Shape.ROUND);
		// We test that taking the piece at index 0 again is different than the previous one
		assertFalse(stock.takePiece().equals(testPiece));
	}
	
	@Test
	/**
	 * Tests that the size() method from the Stock class works properly
	 * @throws QuartoException
	 */
	public void testStockSize() throws QuartoException
	{
		Stock stock = new Stock();
		// We test with a full stock
		assertEquals(stock.size(), 16);
		// We test with an incomplete stock
		stock.takePiece();
		assertEquals(stock.size(), 15);
		// Finally we test with an empty stock
		for (int i = 1; i < 16; i++)
			stock.takePiece();
		assertEquals(stock.size(), 0);
	}
	
	@Test
	/**
	 * Tests that the isEmpty() method of the Stock class works properly
	 * @throws QuartoException
	 */
	public void testStockIsEmpty() throws QuartoException
	{
		Stock stock = new Stock();
		// We test with a full stock
		assertFalse(stock.isEmpty());
		// We test with an incomplete stock
		stock.takePiece();
		assertFalse(stock.isEmpty());
		// We test with an empty stock
		for (int i = 1; i < 16; i++)
			stock.takePiece();
		assertTrue(stock.isEmpty());
	}
	
	@Test (expected = IllegalArgumentException.class)
	/**
	 * Tests that creating a new Piece object throws an IllegalArgumentException when any of the arguments is null
	 */
	public void testPieceException()
	{
		new Piece(null, null, null, null);
	}
	
	@Test (expected = QuartoException.class)
	/**
	 * Tests that the QuartoException works properly in the takePiece method of the Stock class
	 * @throws QuartoException
	 */
	public void testStockException() throws QuartoException
	{
		Stock stock = new Stock();
		stock.takePiece(-15);
	}
	
	
	@Test
	/**
	 * Tests that the Position class creates positions correctly
	 */
	public void testPosition()
	{
		Position position1 = new Position(0, 0);
		Position position2 = new Position(3, 2);
		assertEquals(position1.getRow(), 0);
		assertEquals(position2.getRow(), 3);
		assertEquals(position2.getColumn(), 2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	/**
	 * Tests that Position throws an IllegalArgumentException if any of the arguments is negative
	 */
	public void testPositionException()
	{
		new Position(-3, 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	/**
	 * Tests that Position throws an IllegalArgumentException if any of the arguments is >= Board.SIZE
	 */
	public void testPositionException2()
	{
		new Position(4, 4);
	}
	
	@Test
	/**
	 * Tests that the Board class works properly by testing the constructor, isFree and takePiece methods
	 * @throws QuartoException
	 */
	public void testBoard() throws QuartoException
	{
		Stock stock = new Stock();
		Piece[] pieces = {stock.takePiece(), stock.takePiece()};
		Board board1 = new Board();
		Board board2 = new Board(pieces);
		Position pos1 = new Position(0, 0);
		Position pos2 = new Position(0, 2);
		assertTrue(board1.isFree(pos1));
		assertFalse(board2.isFree(pos1));
		board1.addPiece(stock.takePiece(), pos1);
		board2.addPiece(stock.takePiece(), pos2);
		assertFalse(board1.isFree(pos1));
		assertFalse(board2.isFree(pos2));
	}
	
	@Test (expected = QuartoException.class)
	/**
	 * Tests that the AddPiece() method from the Board class throws a QuartoException when we add a piece in a position where there's already
	 * a piece
	 * @throws QuartoException
	 */
	public void testBoardAddPieceException() throws QuartoException
	{
		Stock stock = new Stock();
		Board board = new Board();
		Position pos = new Position(0, 0);
		board.addPiece(stock.takePiece(), pos);
		// we try to add another piece to the same pos, throws error
		board.addPiece(stock.takePiece(), pos);
	}
}
