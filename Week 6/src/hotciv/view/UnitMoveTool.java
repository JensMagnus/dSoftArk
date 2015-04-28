package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
public class UnitMoveTool implements Tool {
	// Passed through the constructor.
	private Game game;
	private DrawingEditor editor;
	
	// Actual unit movement.
	private int x, y, sX, sY;
	private Figure unit;
	
	public UnitMoveTool(Game game, DrawingEditor editor) {
		this.game = game;
		this.editor = editor;
	}

	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		Position p = GfxConstants.getPositionFromXY(x, y);
		if(game.getUnitAt(p) != null) {
			unit = editor.drawing().findFigure(x, y);
			this.x = sX = x;
			this.y = sY = y;
		}
	}
	
	@Override
	public void mouseDrag(MouseEvent e, int x, int y) {
		if(unit != null) {
			unit.moveBy(x - this.x, y - this.y);
			this.x = x;
			this.y = y;
		}
	}
	
	@Override
	public void mouseUp(MouseEvent e, int x, int y) {
		if(unit != null) {
			Position from = GfxConstants.getPositionFromXY(sX, sY);
			Position unitP = GfxConstants.getPositionFromXY(x, y);
			if(!game.moveUnit(from, unitP)) {
				unit.moveBy(sX - x, sY - y);
			}
			unit = null;
		}
	}

	@Override
	public void keyDown(KeyEvent arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMove(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}