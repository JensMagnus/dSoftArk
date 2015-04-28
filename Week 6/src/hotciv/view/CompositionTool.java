package hotciv.view;

import hotciv.framework.Game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor;
import minidraw.framework.Tool;

public class CompositionTool implements Tool {
	private Tool UnitMoveTool;
	private Tool SetFocusTool;
	private Tool EndOfTurnTool;
	private Tool ActionTool;
	
	public CompositionTool(Game game, DrawingEditor editor) {
		UnitMoveTool = new UnitMoveTool(game, editor);
		SetFocusTool = new SetFocusTool(game, editor);
		EndOfTurnTool = new EndOfTurnTool(game, editor);
		ActionTool = new ActionTool(game, editor);
	}
	
	
	@Override
	public void keyDown(KeyEvent arg0, int arg1) { }

	@Override
	public void mouseDown(MouseEvent arg0, int arg1, int arg2) {
		UnitMoveTool.mouseDown(arg0, arg1, arg2);
		SetFocusTool.mouseDown(arg0, arg1, arg2);
		EndOfTurnTool.mouseDown(arg0, arg1, arg2);
		ActionTool.mouseDown(arg0, arg1, arg2);
	}

	@Override
	public void mouseDrag(MouseEvent arg0, int arg1, int arg2) {
		UnitMoveTool.mouseDrag(arg0, arg1, arg2);
	}

	@Override
	public void mouseMove(MouseEvent arg0, int arg1, int arg2) { }

	@Override
	public void mouseUp(MouseEvent arg0, int arg1, int arg2) {
		UnitMoveTool.mouseUp(arg0, arg1, arg2);
	}

}
