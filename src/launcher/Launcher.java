package launcher;

import display.Display;
import game.Game;

/**
 *Launches the game
 * 
 */
public class Launcher {
    
    public static void main(String[] args)
    {
        Game game = new Game("Elysium", 500, 500);
        game.start();
        
        
    }
    
}
