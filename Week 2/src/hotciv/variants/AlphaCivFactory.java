package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class AlphaCivFactory implements Factory {
	@Override
	public WinnerStrategy createWinnerStrategy() {
		return new AlphaCivWinningStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
		// TODO Auto-generated method stub
		return new AlphaCivAgeStrategy();
	}

	@Override
	public UnitStrategy createUnitStrategy() {
		// TODO Auto-generated method stub
		return new AlphaCivUnitStrategy();
	}

	@Override
	public WorldLayout createWorldLayout() {
		// TODO Auto-generated method stub
		return new AlphaCivWorldLayout();
	}
}
