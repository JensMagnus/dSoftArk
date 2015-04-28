package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.variants.ThirdPartyFractalGeneratorFactory;

import org.junit.Before;
import org.junit.Test;

public class TestThirdPartyGenerator {
	private Game game;

	@Before
	public void setUp() {
		game = new GameImpl(new ThirdPartyFractalGeneratorFactory());
	}
	
	// ...
	@Test
	public void shouldHaveATestStub() {
		assertEquals(this, this);
	}
}
