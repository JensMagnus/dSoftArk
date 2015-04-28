package hotciv.standard;

import java.util.HashMap;

import hotciv.framework.*;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

public class GameImpl implements Game {
	// Strategy Patterns and factory
	private WinnerStrategy winnerStrategy;
	private AgeStrategy ageStrategy;
	private UnitStrategy unitStrategy;
	private WorldLayout worldLayout;
	
	// Game Variables
	private int age;
	private Player playerInTurn = Player.RED;
	
	// HashMaps for Cities, Units and Tiles.
	private HashMap<Position, TileImpl> tileMap = new HashMap<Position, TileImpl>();
	private HashMap<Position, CityImpl> cityMap = new HashMap<Position, CityImpl>();
	private HashMap<Position, UnitImpl> unitMap = new HashMap<Position, UnitImpl>();
	
	public HashMap<Position, CityImpl> getCityHashMap() {
		return this.cityMap;
	}
	
	public GameImpl(Factory factory) {
		this.winnerStrategy = factory.createWinnerStrategy();
		this.ageStrategy = factory.createAgeStrategy();
		this.unitStrategy = factory.createUnitStrategy();
		this.worldLayout = factory.createWorldLayout();
		
		// Negative number is "BC"
		this.age = -4000;
	
		
		// Create world layout.
		cityMap = worldLayout.defineWorldCities();
		unitMap = worldLayout.defineWorldUnits();
		tileMap = worldLayout.defineWorldTiles();
	}
	
	// Used when Delta Civ or similar has a requirement for custom layouts.
	public void setLayout(String [] layout) {
		// Not yet implemented, because I'm not sure how to...
	}
	
	public void addUnit(City c) {
		// Take the production from the City.
		((CityImpl) c).removeResource(
			getCostOfCurrentProduction(
						((CityImpl) c).getProduction()
			)
		);
		// Add new unit for our city.
		unitMap.put(new Position(1,1), new UnitImpl(((CityImpl) c).getProduction(), c.getOwner()));
	}

	public int getCostOfCurrentProduction(String currentProduction) {
		if(currentProduction == GameConstants.LEGION) {
			return 15; 
		}
		if(currentProduction == GameConstants.SETTLER) {
			return 30;
		}
		if(currentProduction == GameConstants.ARCHER) {
			return 10;
		}
		return 0;
	}

	public Tile getTileAt(Position p) {
    	TileImpl tile = (TileImpl) tileMap.get(p);
    	if(tile != null) {
    		return (TileImpl) tileMap.get(p);
    	}
    	// Should be plains where there isn't a fixed specific 
        // type of tile previously defined per coordinates.
		return new TileImpl(GameConstants.PLAINS);
    }
    
    public UnitImpl getUnitAt(Position p) {
        return unitMap.get(p);
    }
    
    public City getCityAt(Position p) {
        return cityMap.get(p);
    }
    
    public Player getPlayerInTurn() {
        return playerInTurn;
    }
    
    public Player getWinner() {
        return winnerStrategy.getWinner(this);
    }
    
    public int getAge() {
        return age;
    }
    
    public boolean distanceBetween(Position a, Position b) {
		int movesUsedForThis = (int) Math.sqrt(
    			Math.pow(a.getColumn(), a.getRow()) +
    			Math.pow(b.getColumn(), b.getRow())
    	);
    	if(((UnitImpl)getUnitAt(a)).getMoveCount() < movesUsedForThis) {
    		return false;
    	}
    
    	return true;
    }
    

    public boolean moveUnit(Position from, Position to) {
    	Object typeOfEntryTo = unitMap.get(to);
    	Object typeOfEntryFrom = unitMap.get(from);
    	
    	if(typeOfEntryFrom == null) return false;
    	

    	// Handle unit actions.
    	if(typeOfEntryFrom instanceof UnitImpl) {
    		// Check if we can move this far.
        	if(distanceBetween(from, to) == false)  {
        		return false;
        	}

        	// Handle Unit Specific Actions
        	if(((UnitImpl) typeOfEntryFrom).getTypeString() == GameConstants.ARCHER) {
        		if(((UnitImpl) typeOfEntryFrom).isFortified() == 1) {
        			return false;
        		}
        	}
        	
    		// Handle unit to tile actions
    		if(typeOfEntryTo instanceof TileImpl) {
    			TileImpl t = (TileImpl) getTileAt(to);
    			// Don't allow us to move over mountains
    			if(t.getTypeString() == GameConstants.MOUNTAINS || t.getTypeString() == GameConstants.OCEANS) {
    				return false;
    			}
    					
    		}

    		// Handle Unit to unit actions
    		if(typeOfEntryTo instanceof UnitImpl) {
    			UnitImpl u = (UnitImpl) getUnitAt(to);
    			// Check if "to" is owned by "from"'s owner,
    			// don't allow us to move to a tile which has a unit already.
    			if(u.getOwner() == getPlayerInTurn()) {
    				return false;
    			}
    			
    			// If it is owned by an enemy, move to and remove enemy unit.
    			unitMap.remove(to);
    			unitMap.put(from, getUnitAt(from));
    			return true;
    		}
 
    		if(typeOfEntryTo == null) {
    			// Just move to the tile, there's nothing. Just return true,
    			// because fake it as you make it.
    			return true;
    		}
    	}

        return false;
    }
    
    public void endOfTurn() {
    	// If it's player RED's turn now, it most be blue afterwards.
    	playerInTurn = (playerInTurn == Player.RED) ? Player.BLUE : Player.RED;
 
    	// Add 6 production to all cities and the end of the turn.  
    	// This can still be our fixed test f or city 1,1.
    	City c = getCityAt(new Position(1,1));
    	((CityImpl) c).addResource(6);
    	
    	// Move forward in time.
    	this.age += ageStrategy.endOfTurn(age);
    }
    
    public void changeWorkForceFocusInCityAt(Position p, String balance) {
    	CityImpl c = (CityImpl) getCityAt(p);
    	c.setWorkforceFocus(balance);
    	
    }
    public void changeProductionInCityAt(Position p, String unitType) {
    	City c = getCityAt(p);
    	((CityImpl) c).setProduction(unitType);
    }
    public void performUnitActionAt(Position p) {
    	unitStrategy.performUnitActionAt(p, this);
    }

	public void killUnitAt(Position p) {
		unitMap.remove(p);
	}

	public void createCityAt(Position p, Player owner) {
		cityMap.put(p, new CityImpl(owner));
	}
}
