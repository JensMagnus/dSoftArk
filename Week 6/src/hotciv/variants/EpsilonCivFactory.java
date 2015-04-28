package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class EpsilonCivFactory implements Factory {

	private DieStrategy fixedDieStrategy = new RandomDieStrategy();

	public EpsilonCivFactory(DieStrategy fixedDieStrategy) {
		// If we get a fixed use that, otherwise use the default(random).
		this.fixedDieStrategy  = fixedDieStrategy;
	}

	@Override
	public WinnerStrategy createWinnerStrategy() {
		// TODO Auto-generated method stub
		return new EpsilonWinnerStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
		// TODO Auto-generated method stub
		return new AlphaCivAgeStrategy();
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
		return new EpsilonAttackStrategy();
	}
	
	@Override
	public DieStrategy createDieStrategy() {
		return fixedDieStrategy;
	}
	@Override
	public DefaultUnitList createUnitList() {
		// TODO Auto-generated method stub
		return new DefaultUnitList();
	}
}
