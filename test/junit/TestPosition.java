package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cam.utils.personnages.Position;

public class TestPosition
{

	private Position position;
	
	@Before
	public void before() {
		position = new Position(0, 0);
	}
	
	@Test
	public void testX()
	{
		assertEquals(position.getX(), 0);
	}
	
	@Test
	public void testY()
	{
		assertEquals(position.getY(), 0);
	}
	
	@Test
	public void testChangement() {
		this.position.setX(5);
		this.position.setY(2);
		
		assertEquals(position.getX(), 5);
		assertEquals(position.getY(), 2);
	}

}
