package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;

public class CityImpl implements City {
	private Player p;
	private int resource = 1;
	private String currentProduction = GameConstants.foodFocus;
	private String workForceFocus = GameConstants.productionFocus;
	
	public CityImpl(Player p) {
		this.p = p;
	}
	

	@Override
	public Player getOwner() {
		// Return our expected player RED.
		return p;
	}
	
	public void setOwner(Player p) {
		this.p = p;
	}
	

	@Override
	public int getSize() {
		// Should be population size 1, which is a fixed entry.
		return 1;
	}

	@Override
	public String getProduction() {
		return currentProduction;
	}

	public void setProduction(String currentProduction) {
		this.currentProduction = currentProduction;
	}
	
	@Override
	public String getWorkforceFocus() {
		return workForceFocus;
	}

	public int getResource() {
		return resource;
	}
	
	public void addResource(int i) {
		// TODO Auto-generated method stub
		this.resource += i;
	}
	
	public void removeResource(int i) {
		this.resource -= i;
	}

	public void setWorkforceFocus(String balance) {
		this.workForceFocus = balance;
	}	
}
