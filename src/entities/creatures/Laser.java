package entities.creatures;

import entities.*;
import game.Game;
import gfx.Assets;
import input.KeyManager;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * Player Laser
 */
public class Laser {
    
    private double x;
    private double y; 
    private int shootDirection;
    public static Rectangle laserRect;
      
    public Laser(double x, double y, Game game, int d){
        this.x = x;
        this.y = y;
        shootDirection = d;
        
        
    }
    
    public void tick(){ 
        shootDirection();
    }
    
    public void shootDirection(){
        
        switch (shootDirection){
            case 1:
                x -= 5;
                break;
            case 2:
                x += 5;
                break;
            case 3:
                y -= 5;
                break;
            case 4:
                y += 5;
                break;
        }
        
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.laser, (int) x, (int) y, null);
        laserRect = new Rectangle(250, 265, 5, 5);
       
    }

}
