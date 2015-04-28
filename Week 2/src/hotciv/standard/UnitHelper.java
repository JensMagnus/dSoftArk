package hotciv.standard;

public class UnitHelper {
	private int attack;
	private int defence;
	private int cost;

	public UnitHelper(int attack, int defence, int cost) {
		this.attack = attack;
		this.defence = defence;
		this.cost = cost;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence;
	}
	public int getCost() { 
		return cost;
	}
}
