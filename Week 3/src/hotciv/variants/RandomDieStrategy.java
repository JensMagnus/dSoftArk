package hotciv.variants;

import java.util.Random;

import hotciv.framework.DieStrategy;

public class RandomDieStrategy implements DieStrategy {

	@Override
	public int rollDie() {
		Random rand = new Random();
		return rand.nextInt(6) + 1; 
	}

}
