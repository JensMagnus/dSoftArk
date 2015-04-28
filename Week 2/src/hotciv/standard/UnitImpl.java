package hotciv.standard;

import java.util.HashMap;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Unit;

public class UnitImpl implements Unit {
	private String type;
	private Player p;
	private int fortified = 0;
	
	private HashMap<String, Object> unitData = new HashMap<String, Object>();
	
	public UnitImpl(String type, Player p) {
		this.type = type;
		this.p = p;
		
		// Assign values to different type of units.
		unitData.put(GameConstants.SETTLER, new UnitHelper(0,3,30));
		unitData.put(GameConstants.LEGION, new UnitHelper(4,2,15));
		unitData.put(GameConstants.ARCHER, new UnitHelper(2,3,10));
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
		return 1;
	}

	@Override
	public int getDefensiveStrength() {
		int factor = 1;
		if(fortified == 1) {
			factor = 2;
		}
		return ((UnitHelper) unitData.get(getTypeString())).getDefence() * factor;
	}

	@Override
	public int getAttackingStrength() {
		return 50;
	}

	public void toggleFortify() {
		fortified = (fortified == 1) ? 0 : 1;
	}

	public int isFortified() {
		return fortified;
	}
	
	public void performSettlerAction() {
		
	}
	
}
