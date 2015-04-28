package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.DieStrategy;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.FixedDieStrategy;
import hotciv.variants.ZetaCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCiv {
	private Game game;
	private GameHelper GameHelper;
	
	@Before
	public void setUp() {
		// Give it our random die strategy.
		game = new GameImpl(new ZetaCivFactory(new FixedDieStrategy()));
		
		
		// Add some units we can play with on top of Alpha Civs tile layout.
		((GameImpl) game).createUnit(new Position(10,10), new UnitImpl(GameConstants.ARCHER, Player.RED));
		((GameImpl) game).createUnit(new Position(10,11), new UnitImpl(GameConstants.ARCHER, Player.RED));
		((GameImpl) game).createUnit(new Position(10,9), new UnitImpl(GameConstants.LEGION, Player.BLUE));
		
		// For end of turns.
		GameHelper = new GameHelper(game);
	}
	
	@Test
	public void winningAttacksDoesNotMakeYouWinBefore50Turns() {
		// Check if we have a winner.
		assertNull(game.getWinner());
		
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
		
		// Progress some turns and make sure no one has won by winning 3 turns before the 20th or afterwards.
		GameHelper.endOfTurns(50);
		
		assertNull(game.getWinner());
	}
	
	@Test
	public void shouldWinGameByWinning3AttacksAfterThe20ThRound() {
		// Check if we have a winner.
		assertNull(game.getWinner());
	
		// Progress some turns and make sure no one has won by winning 3 turns before the 20th or afterwards.
		GameHelper.endOfTurns(21);
		
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
		
		// Check if blue has won.
		assertEquals(Player.BLUE, game.getWinner());
	}
	
	@Test
	public void gameIsWonAfterAllCitiesAreCaptured() {
		// Get a city owned by BLUE
		CityImpl c = (CityImpl) game.getCityAt(new Position(4,1));

		// set city owner to red
		c.setOwner(Player.RED);
		
		// Red should now have won
		assertEquals("Should win when all cities are captured",
			game.getWinner(),
			c.getOwner()
		);
	}
	
	@Test
	public void diesRollsFive() {
		DieStrategy die = game.getDieStrategy();
		assertNotNull(die);
		assertEquals(die.rollDie(), 5);
	}
}
