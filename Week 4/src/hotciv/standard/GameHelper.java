package hotciv.standard;

import hotciv.framework.Game;

public class GameHelper  {
	private Game game;

	public GameHelper(Game game) {
		this.game = game;
	}
	
	public void endOfTurns(int n) {
		for(int i = 0; i < n; i++) {
			game.endOfTurn();
		}
	}
}
