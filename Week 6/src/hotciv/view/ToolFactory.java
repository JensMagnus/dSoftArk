package hotciv.view;

import hotciv.framework.Game;

import javax.swing.JTextField;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.DrawingView;
import minidraw.framework.Factory;

public class ToolFactory implements Factory {
	private Game game;
	
	public ToolFactory(Game game) { 
		this.game = game; 
	}

	@Override
	public DrawingView createDrawingView( DrawingEditor editor ) {
		DrawingView view = 
				new MapView(editor, game);
		return view;
	}

	@Override
	public Drawing createDrawing( DrawingEditor editor ) {
		return new CivDrawing( editor, game );
	}

	@Override
	public JTextField createStatusField( DrawingEditor editor ) {
		JTextField f = new JTextField("dSoftArk template code");
		f.setEditable(false);
		return f;
	}

}
