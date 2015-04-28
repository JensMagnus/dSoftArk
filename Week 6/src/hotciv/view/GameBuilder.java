package hotciv.view;

import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitImpl;
import hotciv.variants.SemiCivFactory;

public class GameBuilder {
	public static void main(String[] args) {
		GameImpl game = new GameImpl(new SemiCivFactory());
		game.createUnit(new Position(4,6), new UnitImpl(GameConstants.ARCHER, Player.RED, game.getUnitList()));
		game.createUnit(new Position(2,2), new UnitImpl(GameConstants.LEGION, Player.BLUE, game.getUnitList()));
		
		DrawingEditor editor = new MiniDrawApplication("HotCiv", new ToolFactory(game));
		editor.open();
		editor.setTool(new CompositionTool(game, editor));
		editor.showStatus("Welcome!");
	}
}
