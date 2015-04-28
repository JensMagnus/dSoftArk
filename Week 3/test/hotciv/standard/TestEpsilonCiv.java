package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.EpsilonCivFactory;
import hotciv.variants.FixedDieStrategy;

import org.junit.Before;
import org.junit.Test;

public class TestEpsilonCiv {
private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new EpsilonCivFactory(new FixedDieStrategy()));
		
		// Add some units we can play with on top of Alpha Civs tile layout.
		((GameImpl) game).createUnit(new Position(10,10), new UnitImpl(GameConstants.ARCHER, Player.RED));
		((GameImpl) game).createUnit(new Position(10,11), new UnitImpl(GameConstants.ARCHER, Player.RED));
		((GameImpl) game).createUnit(new Position(10,9), new UnitImpl(GameConstants.LEGION, Player.BLUE));
	}
	
	@Test
	public void firstToThreeWonBattlesWinTheGame() {
		// Check if we have a winner.
		assertNull(game.getWinner());
		
		// Make it BLUE's turn.
		game.endOfTurn();
		
		// Move close so we can attack.
		((GameImpl) game).updateUnitPosition(new Position(3,2), new Position(2,1));
		
		// Use moveUnit to perform battle other wise move to next unit and kill it.
		game.moveUnit(new Position(2,1), new Position(2,0));
		
		// Check if we have a winner other wise move to next unit and kill it.
		assertNull(game.getWinner());
		game.moveUnit(new Position(10,9), new Position(10,10));
		
		// Check if we have a winner other wise move to next unit and kill it.
		assertNull(game.getWinner());
		game.moveUnit(new Position(10,10), new Position(10,11));
		
		assertNotNull(game.getWinner());
		assertEquals(game.getWinner(), Player.BLUE);
	}
	
	@Test
	public void redArchershouldHaveDifferentAttackBonusWithDifferentTilesNearBy() {
		UnitImpl unit = (UnitImpl) game.getUnitAt(new Position(10,10));
		assertNotNull(unit);
		assertEquals(unit.combinedAttackBonus(new Position(10,10), game, Player.BLUE, game.getDieStrategy()), 255);
		((GameImpl) game).updateUnitPosition(new Position(10,10), new Position(3,5));
		assertEquals(unit.combinedAttackBonus(new Position(3,5), game, Player.BLUE, game.getDieStrategy()), 250);
	}
	
	@Test
	public void redArchershouldHaveDifferentBonusWithDifferentTilesNearBy() {
		UnitImpl unit = (UnitImpl) game.getUnitAt(new Position(10,10));
		assertNotNull(unit);
		assertEquals(unit.combinedDefenceBonus(new Position(10,10), game, Player.BLUE, game.getDieStrategy()), 20);
		((GameImpl) game).updateUnitPosition(new Position(10,10), new Position(3,5));
		assertEquals(unit.combinedDefenceBonus(new Position(3,5), game, Player.BLUE, game.getDieStrategy()), 15);
	}	
}
