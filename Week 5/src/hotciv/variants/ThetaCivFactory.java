package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitList;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class ThetaCivFactory implements Factory {

	@Override
	public WinnerStrategy createWinnerStrategy() {
		// TODO Auto-generated method stub
		return new AlphaCivWinningStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitStrategy createUnitStrategy() {
		// TODO Auto-generated method stub
		return new GammaCivUnitStrategy();
	}

	@Override
	public WorldLayout createWorldLayout() {
		// TODO Auto-generated method stub
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
	
	@Override
	public UnitList createUnitList() {
		// TODO Auto-generated method stub
		return new ThetaUnitList();
	}
}
