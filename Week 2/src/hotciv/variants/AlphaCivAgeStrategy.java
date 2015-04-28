package hotciv.variants;

import hotciv.framework.AgeStrategy;

public class AlphaCivAgeStrategy implements AgeStrategy {

	@Override
	public int endOfTurn(int age) {
		return 100;
	}

}
