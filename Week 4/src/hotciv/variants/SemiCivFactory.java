package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class SemiCivFactory implements Factory {

	@Override
	public WinnerStrategy createWinnerStrategy() {
		// TODO Auto-generated method stub
		return new EpsilonWinnerStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
		// TODO Auto-generated method stub
		return new BetaCivAgeStrategy();
	}

	@Override
	public UnitStrategy createUnitStrategy() {
		// TODO Auto-generated method stub
		return new GammaCivUnitStrategy();
	}

	@Override
	public WorldLayout createWorldLayout() {
		// TODO Auto-generated method stub
		return new DeltaCivWorldLayout();
	}

	@Override
	public AttackStrategy createAttackingStrategy() {
		// TODO Auto-generated method stub
		return new EpsilonAttackStrategy();
	}

	@Override
	public DieStrategy createDieStrategy() {
		// TODO Auto-generated method stub
		return new RandomDieStrategy();
	}
	@Override
	public DefaultUnitList createUnitList() {
		// TODO Auto-generated method stub
		return new DefaultUnitList();
	}
}
