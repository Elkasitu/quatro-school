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
}
