package hotciv.variants;

import java.util.HashMap;

import hotciv.framework.GameConstants;
import hotciv.framework.UnitList;
import hotciv.standard.UnitHelper;

public class DefaultUnitList implements UnitList {

	private HashMap<String, UnitHelper> unitList = new HashMap<String, UnitHelper>();
	
	public DefaultUnitList() {
		// (int attack, int defence, int cost, String action)
		unitList.put(GameConstants.ARCHER, new UnitHelper(2,3,10, "fortify"));
		unitList.put(GameConstants.LEGION, new UnitHelper(4,2,15, "none"));
		unitList.put(GameConstants.SETTLER, new UnitHelper(0,3,30, "build city"));
	}

	@Override
	public HashMap<String, UnitHelper> getMap() {
		// TODO Auto-generated method stub
		return unitList;
	}
}
