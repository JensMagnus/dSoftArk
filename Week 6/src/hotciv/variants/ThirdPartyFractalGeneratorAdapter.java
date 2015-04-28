package hotciv.variants;

import java.util.HashMap;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.WorldLayout;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;
import thirdparty.ThirdPartyFractalGenerator;

// Had to change the class name to "+Adapter" so we could import the library. :)
public class ThirdPartyFractalGeneratorAdapter implements WorldLayout {
	ThirdPartyFractalGenerator generator = new ThirdPartyFractalGenerator();
	String layout[] = new String[16];
	
	@Override
	public HashMap<Position, TileImpl> defineWorldTiles() {
		DeltaCivWorldLayout newMap = new DeltaCivWorldLayout();
		String line;
		for (int r = 0; r < 16; r++ ) {
			line = "";
			for(int c = 0; c < 16; c++ ) {
				line = line + generator.getLandscapeAt(r,c);
			}
			layout[r] = line;
		}
		
		newMap.setLayout(layout);
		return newMap.defineWorldTiles();
		
	}

	@Override
	public HashMap<Position, CityImpl> defineWorldCities() {
		// TODO Auto-generated method stub
		return new HashMap<Position, CityImpl>();
	}

	@Override
	public HashMap<Position, UnitImpl> defineWorldUnits(Game game) {
		// TODO Auto-generated method stub
		return new HashMap<Position, UnitImpl>();
	}

}
