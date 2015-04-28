package hotciv.framework;

public interface WinnerStrategy {
	// Get the winner
	public Player getWinner(Game game);
}
