package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.SemiCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestSemiCiv {
	private Game game;
	private GameHelper gH;
	
	@Before
	public void setUp() {
		game = new GameImpl(new SemiCivFactory());
		gH = new GameHelper(game);
	}
	
	// Test delta civ layout factory.
	@Test
	public void redHasCityAt8_12() {
		assertNotNull(game.getCityAt(new Position(8,12)));
		assertEquals(
			(game.getCityAt(new Position(8,12))).getOwner(), 
			Player.RED
		);
	}
	
	// Test Beta Civ age Strategy
	@Test
	public void between4000And100BCA100YearsPasses() {
		gH.endOfTurns(39);
		assertEquals(game.getAge(), -100);
	}

}
