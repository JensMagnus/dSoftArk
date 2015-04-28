package hotciv.framework;

public interface WinnerStrategy {
	// Get the winner
	public Player getWinner(Game game);

	public void incrementWonBattles(Player playerInTurn);

	public void incrementNumberofRounds(int amount);
}
