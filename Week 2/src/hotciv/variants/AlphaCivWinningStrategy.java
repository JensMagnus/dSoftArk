package hotciv.variants;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;

public class AlphaCivWinningStrategy implements WinnerStrategy {
	@Override
	public Player getWinner(Game game) {
		if(game.getAge() == -3000) {
			return Player.RED;
		}
		return null;
	}
}
