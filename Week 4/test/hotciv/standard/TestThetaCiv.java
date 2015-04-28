package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variants.ThetaCivFactory;

import org.junit.Before;
import org.junit.Test;

public class TestThetaCiv {
	private Game game;
	private UnitImpl uH = null;
	
	@Before
	public void setUp() {
		// Give it our random die strategy.
		game = new GameImpl(new ThetaCivFactory());
		uH = new UnitImpl(GameConstants.CHARIOT, Player.BLUE, game.getUnitList());
	}
	
	@Test
	public void isThereAUnitNamedChariot() {
		assertNotNull(GameConstants.CHARIOT.isEmpty());
	}
	
	@Test
	public void isTheCost20() {
		assertEquals(((GameImpl) game).getCostOfCurrentProduction(GameConstants.CHARIOT), 20);
	}
	
	@Test
	public void isTheTravelDistance1() {
		assertEquals(uH.getMoveCount(), 1);
	}
	
	@Test
	public void isDefense1() {
		assertEquals(uH.getDefensiveStrength(), 1);
	}
	
	@Test
	public void isAttack3() {
		assertEquals(uH.getAttack(), 3);
	}
	
	@Test
	public void canProduceChariot() {
		game.changeProductionInCityAt(new Position(1,1), GameConstants.CHARIOT);
		City c = game.getCityAt(new Position(1,1));
		assertEquals(c.getProduction(), GameConstants.CHARIOT);
	}
	
	@Test
	public void chariotShouldDoubleFortify() {
		((GameImpl)game).createUnit(new Position(7,7), new UnitImpl(GameConstants.CHARIOT, Player.BLUE, game.getUnitList()));
		
		UnitImpl u = (UnitImpl) game.getUnitAt(new Position(7,7));
		int defense = u.getDefensiveStrength();
		game.performUnitActionAt(new Position(7,7));
		assertEquals(defense * 2, u.getDefensiveStrength());
		game.performUnitActionAt(new Position(7,7));
		// Should now just be normal defense.
		assertEquals(defense, u.getDefensiveStrength());
	}
	
	
}