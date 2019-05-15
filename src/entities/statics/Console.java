package entities.statics;

import elysium.Handler;
import entities.Entity;
import entities.creatures.Controller;
import entities.creatures.Laser;
import game.Game;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;
import tiles.Tile;

/**
 *
 * Console
 */
public class Console extends StaticEntity {
    
    public Console(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        
        bounds.x = 0;
        bounds.y = (int) (32);
        bounds.width = width;
        bounds.height = (int) (height - 32);
    }
    
    public void LaserDetection() {
         for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(Laser.laserRect))
                hurt(1);          
                System.out.println("HIT");
        } 
    }

    @Override
    public void tick() {  
        
    }
    
    @Override
    public void die() {
        System.out.println("KABOOM!");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.console, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    
}
