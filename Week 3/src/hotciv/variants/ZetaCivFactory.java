package hotciv.variants;

import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Factory;
import hotciv.framework.UnitStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.framework.WorldLayout;

public class ZetaCivFactory implements Factory {
	private DieStrategy fixedDieStrategy = new RandomDieStrategy();

	public ZetaCivFactory(DieStrategy fixedDieStrategy) {
		// If we get a fixed use that, otherwise use the default(random).
		this.fixedDieStrategy  = fixedDieStrategy;
	}
	
	@Override
	public WinnerStrategy createWinnerStrategy() {
		return new ZetaCivWinnerStrategy();
	}

	@Override
	public AgeStrategy createAgeStrategy() {
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
		return new EpsilonAttackStrategy();
	}

	@Override
	public DieStrategy createDieStrategy() {
		return fixedDieStrategy;
	}
}
