package hotciv.framework;

import hotciv.standard.GameImpl;

public interface AttackStrategy {
	boolean battle(Position attacker, Position defender, GameImpl gameImpl,
			Player player, DieStrategy die);
}
