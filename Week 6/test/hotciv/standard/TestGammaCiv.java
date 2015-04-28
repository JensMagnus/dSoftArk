package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.variants.GammaCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestGammaCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new GammaCivFactory());
	}
	
	@Test
	public void archerShouldNotBeAbleToMoveIfFortified() {
		assertEquals(game.moveUnit(new Position(2,0), new Position(2,1)), true);
		game.performUnitActionAt(new Position(2,1));
		assertEquals(game.moveUnit(new Position(2,0), new Position(2,3)), false);
	}
	
	@Test
	public void archerShouldDoubleFortify() {
		UnitImpl u = (UnitImpl) game.getUnitAt(new Position(2,0));
		int defense = u.getDefensiveStrength();
		game.performUnitActionAt(new Position(2,0));
		assertEquals(defense * 2, u.getDefensiveStrength());
		game.performUnitActionAt(new Position(2,0));
		// Should now just be normal defense.
		assertEquals(defense, u.getDefensiveStrength());
	}
	
	@Test 
	public void settlerShouldBeAbleToBuildCity() {
		UnitImpl u = (UnitImpl) game.getUnitAt(new Position(4,3));
		assertNotNull(u);
		game.performUnitActionAt(new Position(4,3));
		// has it been deleted?
		assertEquals(game.getUnitAt(new Position(4,3)), null);
		// is there a new city?
		assertNotNull(game.getCityAt(new Position(4,3)));
	}	
}
