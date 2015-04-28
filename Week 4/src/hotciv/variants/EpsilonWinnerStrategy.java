package hotciv.variants;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;

public class EpsilonWinnerStrategy implements WinnerStrategy {
	
	private int totalWinsForRed = 0;
	private int totalWinsForBlue = 0;

	@Override
	public Player getWinner(Game game) {
		if(totalWinsForBlue >= 3) {
			return Player.BLUE;
		} 
		
		if(totalWinsForRed >= 3) {
			return Player.RED;
		}
		return null;
	}

	@Override
	public void incrementWonBattles(Player playerInTurn) {
		if(playerInTurn == Player.RED) {
			totalWinsForRed++;
		}
		
		if(playerInTurn == Player.BLUE) {
			totalWinsForBlue++;
		}
	}

	@Override
	public void incrementNumberofRounds(int amount) {
		// TODO Auto-generated method stub
		
	}
}
