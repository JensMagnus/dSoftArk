package hotciv.standard;

import java.util.HashMap;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.framework.DieStrategy;

public class UnitImpl implements Unit {
	private String type;
	private Player p;
	private int fortified = 0;
	// Roll two dies, but since we fake it they'll both roll 5.
	int die1 = 5;
	int die2 = 5;
	
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

	public int combinedAttackBonus(Position attacker, Game game, Player player, DieStrategy die) {
		int total = 0;
		// Get the attackers strength.
		total += ((UnitImpl)game.getUnitAt(attacker)).getAttackingStrength();
		
		// Get nearby friend support and add it to the total attack.
		total += Utility.getFriendlySupport(game, attacker, player);
		
		// Multiply by terrianFactor.
		total *= Utility.getTerrainFactor(game, attacker);
		
		// Return total.
		return total * die.rollDie();
	}
	
	public int combinedDefenceBonus(Position defender, Game game,  Player player, DieStrategy die) {
		int total = 0;
		// Get the defenders strength.
		total += ((UnitImpl)game.getUnitAt(defender)).getDefensiveStrength();
		
		// Get nearby friend support and add it to the total defense.
		total += Utility.getFriendlySupport(game, defender, player);
				
		// Multiply by terrianFactor.
		total *= Utility.getTerrainFactor(game, defender);
		
		// Return total.
		return total * die.rollDie();
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
