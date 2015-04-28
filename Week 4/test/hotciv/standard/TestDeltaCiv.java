package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.DeltaCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestDeltaCiv {
	private Game game;
	private String[] mountainLayout =
		      new String[] {
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM", 
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM",
	          "MMMMMMMMMMMMMMMM"
	         };

	@Before
	public void setUp() {
		game = new GameImpl(new DeltaCivFactory());
		
	}	
	
	@Test
	public void redHasCityAt8_12() {
		assertNotNull(game.getCityAt(new Position(8,12)));
		assertEquals(
			(game.getCityAt(new Position(8,12))).getOwner(), 
			Player.RED
		);
	}
	
	@Test
	public void blueHasCityAt4_5() {
		assertNotNull(game.getCityAt(new Position(4,5)));
		assertEquals(
			(game.getCityAt(new Position(4,5))).getOwner(), 
			Player.BLUE
		);
	}
	
	@Test
	public void shouldBeDefaultLayoutUnlessSpecifiedOtherWise() {
		assertEquals(
			game.getTileAt(new Position(0,0)).getTypeString(), 
			GameConstants.OCEANS
		);
		assertEquals(
			game.getTileAt(new Position(0,1)).getTypeString(), 
			GameConstants.OCEANS
		);
		assertEquals(
			game.getTileAt(new Position(0,2)).getTypeString(), 
			GameConstants.OCEANS
		);
		assertEquals(
			game.getTileAt(new Position(14,16)).getTypeString(), 
			GameConstants.PLAINS
		);
		assertEquals(
			game.getTileAt(new Position(7,9)).getTypeString(), 
			GameConstants.PLAINS
		);
	}
}
