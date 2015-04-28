package hotciv.variants;

import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitImpl;


public class EpsilonAttackStrategy implements AttackStrategy {
	@Override
	public boolean battle(Position attacker, Position defender, GameImpl gameImpl, Player player, DieStrategy die) {
		// Our units
		UnitImpl attackerUnit = ((GameImpl) gameImpl).getUnitAt(attacker);	
		UnitImpl defenderUnit = ((GameImpl) gameImpl).getUnitAt(defender);	
		
		// Check if A is larger than D, return O.
		if(
			(attackerUnit.combinedAttackBonus(attacker, gameImpl, player, die))
			>
			(defenderUnit.combinedDefenceBonus(defender, gameImpl, (gameImpl.getUnitAt(defender)).getOwner(), die))
		) {			
			return true;
		}
		return false;
	}
}
