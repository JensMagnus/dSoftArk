package hotciv.view;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import hotciv.framework.Game;
import hotciv.framework.Position;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Tool;

public class SetFocusTool implements Tool {

	// Passed through the constructor.
	private Game game;
	@SuppressWarnings("unused")
	private DrawingEditor editor;

	public SetFocusTool(Game game, DrawingEditor editor) {
		this.game = game;
		this.editor = editor;
	}
	
	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		// I'm using my code from FRS 36.38
		Position p = GfxConstants.getPositionFromXY(x, y);
		game.setTileFocus(p);
	}

	@Override
	public void keyDown(KeyEvent arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDrag(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMove(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseUp(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
