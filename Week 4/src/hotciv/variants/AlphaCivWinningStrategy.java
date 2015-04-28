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

	@Override
	public void incrementWonBattles(Player playerInTurn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementNumberofRounds(int amount) {
		// TODO Auto-generated method stub
		
	}
}
