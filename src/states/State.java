package states;

import elysium.Handler;
import game.Game;
import java.awt.Graphics;

/**
 *
 * States
 */
public abstract class State {
    
   //Can be in seperate class: GAME STATE MANAGER
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }    
    //Can be in seperate class^^^ 
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);
    
}
