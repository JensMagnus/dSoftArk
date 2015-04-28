package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.BetaCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestBetaCiv {
	private Game game;
	private GameHelper gH;
	
	@Before
	public void setUp() {
		game = new GameImpl(new BetaCivFactory());
		gH = new GameHelper(game);
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
	public void between4000And100BCA100YearsPasses() {
		gH.endOfTurns(39);
		assertEquals(game.getAge(), -100);
	}
	
	@Test
	public void aroundChristShouldBeDifferentMinusOne() {
		// Get us to 100 BC with the first 39, the last only takes 99 out.
		gH.endOfTurns(40);
		assertEquals(game.getAge(), -1);
	}
	
	@Test
	public void aroundChristShouldBeDifferentPlusOne() {
		gH.endOfTurns(41);
		assertEquals(game.getAge(), 1);
	}
	
	@Test
	public void aroundChristShouldBeYear50() {
		gH.endOfTurns(42);
		assertEquals(game.getAge(), 50);
	}
	
	@Test
	public void between50ACAnd1750AC50YearsPass() {
		gH.endOfTurns(76);
		assertEquals(game.getAge(), 1750);
	}
	
	@Test
	public void between1750ACAnd1900Ac25YearPass() {
		gH.endOfTurns(82);
		assertEquals(game.getAge(), 1900);
	}
	
	@Test
	public void between1900And1970AC5YearsPass() {
		gH.endOfTurns(96);
		assertEquals(game.getAge(), 1970);
	}

	@Test
	public void after1970_1YearPasses() {
		gH.endOfTurns(100);
		assertEquals(game.getAge(), 1974);
		gH.endOfTurns(19);
		assertEquals(game.getAge(), 1993);
	}
}
