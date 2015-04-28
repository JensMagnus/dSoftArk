package hotciv.framework;

public interface Factory {
	// Winner strategy.
	public WinnerStrategy createWinnerStrategy();
	
	// Age strategy
	public AgeStrategy createAgeStrategy();

	// Unit strategy
	public UnitStrategy createUnitStrategy();
	
	// World Strategy, more specifically the lay out pattern.
	public WorldLayout createWorldLayout();

	// Attack strategy.
	public AttackStrategy createAttackingStrategy();

	// Die strategy.
	public DieStrategy createDieStrategy();
}
