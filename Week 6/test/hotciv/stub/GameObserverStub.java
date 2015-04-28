package hotciv.stub;

import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class GameObserverStub implements GameObserver {
	private boolean change = false;
	private boolean ends = false;
	private boolean focus = false;
	
	
	

	@Override
	public void worldChangedAt(Position pos) {
		setChange(true);
	}

	@Override
	public void turnEnds(Player nextPlayer, int age) {
		setEnds(true);
	}

	@Override
	public void tileFocusChangedAt(Position position) {
		setFocus(true);
	}

	// Getters and setters.
	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		this.change = change;
	}

	public boolean isEnds() {
		return ends;
	}

	public void setEnds(boolean ends) {
		this.ends = ends;
	}

	public boolean isFocus() {
		return focus;
	}

	public void setFocus(boolean focus) {
		this.focus = focus;
	}
}
