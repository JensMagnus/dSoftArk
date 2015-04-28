package hotciv.variants;

import hotciv.framework.DieStrategy;

public class FixedDieStrategy implements DieStrategy {
	public int rollDie() {
		return 5;
	}
}
