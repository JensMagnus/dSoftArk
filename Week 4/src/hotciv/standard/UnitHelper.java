package hotciv.standard;

public class UnitHelper {
	private int attack;
	private int defence;
	private int cost;
	private String action;

	public UnitHelper(int attack, int defence, int cost, String action) {
		this.attack = attack;
		this.defence = defence;
		this.cost = cost;
		this.action = action;
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

	public String getAction() {
		return action;
	}
}
