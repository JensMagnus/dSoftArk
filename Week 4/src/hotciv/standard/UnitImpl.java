package hotciv.standard;

import java.util.HashMap;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.framework.DieStrategy;
import hotciv.framework.UnitList;

public class UnitImpl implements Unit {
	private String type;
	private Player p;
	private int fortified = 0;
	private UnitList list;
	// Roll two dies, but since we fake it they'll both roll 5.
	int die1 = 5;
	int die2 = 5;
	
	public UnitImpl(String type, Player p, UnitList list) {
		this.type = type;
		this.p = p;
		this.list = list;
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
		return list.getMap().get(getTypeString()).getDefence() * factor;
	}

	@Override
	public int getAttackingStrength() {
		return 50;
	}
	
	public int getAttack() {
		return list.getMap().get(getTypeString()).getAttack();
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
	
	public int getCost(String unit) {
		return list.getMap().get(unit).getCost();
	}
	
}
