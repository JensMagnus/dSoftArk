package hotciv.variants;

import java.util.HashMap;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WorldLayout;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

public class DeltaCivWorldLayout implements WorldLayout {
	private String[] layout = null;
	private String[] defaultLayout =
		      new String[] {
	          "...ooMooooo.....",
	          "..ohhoooofffoo..",
	          ".oooooMooo...oo.",
	          ".ooMMMoooo..oooo",
	          "...ofooohhoooo..",
	          ".ofoofooooohhoo.",
	          "...ooo..........",
	          ".ooooo.ooohooM..",
	          ".ooooo.oohooof..",
	          "offfoooo.offoooo",
	          "oooooooo...ooooo",
	          ".ooMMMoooo......",
	          "..ooooooffoooo..",
	          "....ooooooooo...",
	          "..ooohhoo.......",
	          ".....ooooooooo..",
	         };
	
	private HashMap<Position, TileImpl> tileMap = new HashMap<Position, TileImpl>();
	private HashMap<Position, CityImpl> cityMap = new HashMap<Position, CityImpl>();

	@Override
	public HashMap<Position, TileImpl> defineWorldTiles() {
		if(layout == null) {
			layout = defaultLayout;
		}
		
		// Copied from StubGame1.java provided by the lecturer.
		String line;
		for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
			line = layout[r];
			for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
			    char tileChar = line.charAt(c);
				String type = "error";
				if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
				if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
				if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
				if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
				if ( tileChar == 'h' ) { type = GameConstants.HILLS; }
			    Position p = new Position(r,c);
			    tileMap.put( p, new TileImpl(type));
			}
		}
	    return tileMap;
	}

	@Override
	public HashMap<Position, CityImpl> defineWorldCities() {
		cityMap.put(new Position(8,12), new CityImpl(Player.RED));
		cityMap.put(new Position(4,5), new CityImpl(Player.BLUE));
		return cityMap;
	}

	@Override
	public HashMap<Position, UnitImpl> defineWorldUnits(Game game) {
		return new HashMap<Position, UnitImpl>();
	}

	public void setLayout(String[] layout) {
		this.layout = layout;
	}
}
