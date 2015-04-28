package hotciv.framework;

import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

import java.util.HashMap;

public interface WorldLayout {
	public HashMap<Position, TileImpl> defineWorldTiles();
	public HashMap<Position, CityImpl> defineWorldCities();
	public HashMap<Position, UnitImpl> defineWorldUnits();
}
