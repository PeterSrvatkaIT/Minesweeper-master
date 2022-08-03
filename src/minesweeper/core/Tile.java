package minesweeper.core;

/**
 * Tile of a field.
 */
public abstract class Tile {
    
    /** Tile states. */
    public enum State {
        /** Open tile. */
        OPEN, 
        /** Closed tile. */
        CLOSED,
        /** Marked tile. */
        MARKED
    }
    
    /** Tile state. */
    private State state = State.CLOSED;
        
    /**
     * Returns current state of this tile.
     * @return current state of this tile
     */
    public State getState() {
        return state;
    }

    /**
     * Sets current  state of this tile.  - //ps20220803 changed from current current to current
     * @param state current state of this tile
     */
    void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if(this.state == State.MARKED) {
            return "M";
        } else return "-";
    }
}
