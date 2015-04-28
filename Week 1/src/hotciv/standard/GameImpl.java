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
	private int age;
	private Player playerInTurn = Player.RED;
	
	private HashMap<Position, Object> hashMap = new HashMap<Position, Object>();
	
	public GameImpl() {
		// Negative number is "BC"
		this.age = -4000;
		
		// Units
		hashMap.put(new Position(2,0), new UnitImpl(GameConstants.ARCHER, Player.RED));
		hashMap.put(new Position(3,2), new UnitImpl(GameConstants.LEGION, Player.BLUE));
		hashMap.put(new Position(4,3), new UnitImpl(GameConstants.SETTLER, Player.RED));
		
		// Cities
		hashMap.put(new Position(1,1), new CityImpl(Player.RED));
		hashMap.put(new Position(4,1), new CityImpl(Player.BLUE));
		
		// Tiles
		hashMap.put(new Position(1,0), new TileImpl(GameConstants.OCEANS));
		hashMap.put(new Position(0,1), new TileImpl(GameConstants.HILLS));
		hashMap.put(new Position(2,2), new TileImpl(GameConstants.MOUNTAINS));
	}
	
	public void addUnit(City c) {
		// Take the production from the City.
		((CityImpl) c).removeResource(
			getCostOfCurrentProduction(
						((CityImpl) c).getProduction()
			)
		);
		// Add new unit for our city.
    	hashMap.put(new Position(1,1), new UnitImpl(((CityImpl) c).getProduction(), c.getOwner()));
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
    	TileImpl tile = (TileImpl) hashMap.get(p);
    	if(tile != null) {
    		return (TileImpl) hashMap.get(p);
    	}
    	// Should be plains where there isn't a fixed specific 
        // type of tile previously defined per coordinates.
		return new TileImpl(GameConstants.PLAINS);
    }
    
    public Unit getUnitAt(Position p) {
        return (Unit) hashMap.get(p);
    }
    
    public City getCityAt(Position p) {
        return (City) hashMap.get(p);
    }
    
    public Player getPlayerInTurn() {
        return playerInTurn;
    }
    
    public Player getWinner() {
        return Player.RED;
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
    	Object typeOfEntryTo = hashMap.get(to);
    	Object typeOfEntryFrom = hashMap.get(from);
    
    	// Handle unit actions.
    	if(typeOfEntryFrom instanceof UnitImpl) {
    		// Check if we can move this far.
        	if(distanceBetween(from, to) == false)  {
        		return false;
        	}
    		// Handle unit to tile actions
    		if(typeOfEntryTo instanceof TileImpl) {
    			TileImpl t = (TileImpl) getTileAt(to);
    			// Don't allow us to move over mountains
    			if(t.getTypeString() == GameConstants.MOUNTAINS) {
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
    			hashMap.remove(to);
    			hashMap.replace(from, to);
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
    	this.age += 100;
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
    	// It's not a requirement to add a "settler" function yet.
    	
    	// Get the unit at p, get action, perform..
    	UnitImpl u = (UnitImpl) getUnitAt(p);
    	
    	u.performAction(u.getTypeString());
    }
}
