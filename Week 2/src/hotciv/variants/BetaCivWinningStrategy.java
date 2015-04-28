package hotciv.variants;

import java.util.HashMap;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.CityImpl;

public class BetaCivWinningStrategy implements WinnerStrategy {
	@Override
	public Player getWinner(Game game) {
		HashMap<Position, CityImpl> hm = game.getCityHashMap();
		int redCount = 0;
		int blueCount = 0;
		
		for(Object c : hm.values()) {
			if(((CityImpl) c).getOwner() == Player.RED) {
				redCount++;
			}
			if(((CityImpl) c).getOwner() == Player.BLUE) {
				blueCount++;
			}
		}
		if(blueCount == 0) {
			return Player.RED;
		}
		if(redCount == 0) {
			return Player.BLUE;
		}
		return null;
	}
}
