package hotciv.variants;

import java.util.HashMap;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WorldLayout;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

public class AlphaCivWorldLayout implements WorldLayout {
	private HashMap<Position, TileImpl> tileMap = new HashMap<Position, TileImpl>();
	private HashMap<Position, UnitImpl> unitMap = new HashMap<Position, UnitImpl>();
	private HashMap<Position, CityImpl> cityMap = new HashMap<Position, CityImpl>();

	@Override
	public HashMap<Position, TileImpl> defineWorldTiles() {
		tileMap.put(new Position(1,0), new TileImpl(GameConstants.OCEANS));
		tileMap.put(new Position(0,1), new TileImpl(GameConstants.HILLS));
		tileMap.put(new Position(2,2), new TileImpl(GameConstants.MOUNTAINS));
		return tileMap;
	}

	@Override
	public HashMap<Position, CityImpl> defineWorldCities() {
		cityMap.put(new Position(1,1), new CityImpl(Player.RED)); 
		cityMap.put(new Position(4,1), new CityImpl(Player.BLUE));
		return cityMap;
	}

	@Override
	public HashMap<Position, UnitImpl> defineWorldUnits() {
		unitMap.put(new Position(2,0), new UnitImpl(GameConstants.ARCHER, Player.RED));
		unitMap.put(new Position(3,2), new UnitImpl(GameConstants.LEGION, Player.BLUE));
		unitMap.put(new Position(4,3), new UnitImpl(GameConstants.SETTLER, Player.RED));
		return unitMap;
	}
}
