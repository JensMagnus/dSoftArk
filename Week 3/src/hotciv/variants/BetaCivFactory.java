package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class BetaCivFactory implements Factory {

	@Override
	public WinnerStrategy createWinnerStrategy() {
		return new BetaCivWinningStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
		return new BetaCivAgeStrategy();
	}

	@Override
	public UnitStrategy createUnitStrategy() {
		return new AlphaCivUnitStrategy();
	}

	@Override
	public WorldLayout createWorldLayout() {
		return new AlphaCivWorldLayout();
	}

	@Override
	public AttackStrategy createAttackingStrategy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DieStrategy createDieStrategy() {
		return new RandomDieStrategy();
	}
}
