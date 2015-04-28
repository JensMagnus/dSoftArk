package hotciv.view;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import hotciv.framework.Game;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.ImageFigure;

public class EndOfTurnTool implements Tool {
	private Game game;
	private DrawingEditor editor;

	public EndOfTurnTool(Game game, DrawingEditor editor) {
		this.game = game;
		this.editor = editor;
	}
	
	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		// Check if it is our turn shield which have been clicked and then call endOfTurn();
		Figure figure = editor.drawing().findFigure(x, y);

		// Prevent all types of errors with this check.
		if(figure instanceof ImageFigure) {
			if(figure.displayBox().contains(new Point(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y))) {
				game.endOfTurn();
			}
		}
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
