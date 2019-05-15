package states;

import Audio.Music;
import elysium.Handler;
import entities.creatures.Player;
import entities.statics.Console;
import game.Game;
import gfx.Assets;
import java.awt.Graphics;
import tiles.Tile;
import worlds.World;

/**
 *
 * Game State
 */
public class GameState extends State {
    
    Music player = new Music("NewTest");
    private Thread thread;
    private World world;
    private boolean musicG = false;
            
    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");       
        handler.setWorld(world);        
    }

    @Override
    public void tick() {
        world.tick();
        if (musicG == false){
            GameMusic();
            musicG = true;
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g); 
    }
        
    public void GameMusic(){
        thread = new Thread(player);
        thread.start();
    }
}


