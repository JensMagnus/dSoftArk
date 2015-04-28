package hotciv.variants;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;

public class ZetaCivWinnerStrategy implements WinnerStrategy {
	int numberOfRounds;
	
	private BetaCivWinningStrategy beta = new BetaCivWinningStrategy();
	private EpsilonWinnerStrategy epsilon = new EpsilonWinnerStrategy();
	
	int totalWinsForRed = 0; 
	int totalWinsForBlue = 0;
	
	@Override
	public Player getWinner(Game game) {
		// Assume we can't skip a round.
		if(numberOfRounds > 20) {
			return epsilon.getWinner(game);
		} else {
			return beta.getWinner(game);
		}
	}

	@Override
	public void incrementWonBattles(Player playerInTurn) {
		epsilon.incrementWonBattles(playerInTurn);
	}
	
	@Override
	public void incrementNumberofRounds(int amount) {
		numberOfRounds += amount;
	}

}
