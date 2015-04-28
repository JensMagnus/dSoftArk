package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.framework.Game;
import hotciv.variants.ThirdPartyFractalGeneratorFactory;

import org.junit.Before;
import org.junit.Test;

public class TestThirdPartyGenerator {
	@SuppressWarnings("unused")
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
