package hotciv.variants;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.UnitStrategy;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitImpl;

public class GammaCivUnitStrategy implements UnitStrategy {
	@Override
	public void performUnitActionAt(Position p, Game game) {
		// get type of unit
		UnitImpl u = (UnitImpl) game.getUnitAt(p);
		if(u.getTypeString().equals(GameConstants.SETTLER)) {
			((GameImpl) game).killUnitAt(p);
			((GameImpl) game).createCityAt(p, u.getOwner());
		}
		if(u.getTypeString().equals(GameConstants.ARCHER)) {
			u.toggleFortify();
		}
		if(u.getTypeString().equals(GameConstants.CHARIOT)) {
			u.toggleFortify();
		}
	}
}
