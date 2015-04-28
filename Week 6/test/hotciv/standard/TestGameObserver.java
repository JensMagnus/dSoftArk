package hotciv.standard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hotciv.framework.Game;
import hotciv.framework.GameObserver;
import hotciv.framework.Position;
import hotciv.stub.GameObserverStub;
import hotciv.variants.AlphaCivFactory;

public class TestGameObserver {
	private Game game;
	private GameObserver observer;

	@Before
	public void setUp() {
		game = new GameImpl(new AlphaCivFactory());
		observer = new GameObserverStub();
		
		
		game.addObserver(observer);
	}
	
	
	@Test
	public void observerNotifiedWhenUnitIsMoved() {
		// Verify we're using our stub.
		assertEquals(((GameObserverStub) observer).isChange(), false);
		
		// Move some unit to a VALID position, otherwise moveUnit will return false before we get to update the observer at the bottom.
		game.moveUnit(new Position(2,0), new Position(2,1));
		
		assertEquals(((GameObserverStub) observer).isChange(), true);
	}
	
	@Test
	public void observerNofifiedAfterEndOfTurn() {
		// Verify we're using our stub.
		assertEquals(((GameObserverStub) observer).isEnds(), false);
		
		game.endOfTurn();
		
		assertEquals(((GameObserverStub) observer).isEnds(), true);
	}
	
	@Test
	public void observerNofifiedWhenTileFocusIsChanged() {
		// Verify we're using our stub.
		assertEquals(((GameObserverStub) observer).isFocus(), false);
			
		// Change the tile focus at some random position.
		game.setTileFocus(new Position(5,5));
			
		// Check if our focus has been observed by the observers.
		assertEquals(((GameObserverStub) observer).isFocus(), true);
	}
}
