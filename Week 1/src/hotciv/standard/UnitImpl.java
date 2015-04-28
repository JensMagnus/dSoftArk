package hotciv.standard;

import hotciv.framework.Player;
import hotciv.framework.Unit;

public class UnitImpl implements Unit {
	private String type;
	private Player p;

	public UnitImpl(String type, Player p) {
		this.type = type;
		this.p = p;
	}
	
	@Override
	public String getTypeString() {
		return type;
	}

	@Override
	public Player getOwner() {
		return p;
	}

	@Override
	public int getMoveCount() {
		return 10;
	}

	@Override
	public int getDefensiveStrength() {
		return 2;
	}

	@Override
	public int getAttackingStrength() {
		return 50;
	}

	// Should perform unit action at some point
	public void performAction(String unitType) {
		// Do nothing.
	}

}
