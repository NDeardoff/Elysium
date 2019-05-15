package entities.creatures;

import entities.EntityManager;
import game.Game;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 *
 * Controller for laser
 */
public class Controller {
    
    private LinkedList<Laser> l = new LinkedList<Laser>();
    
    public Laser TempLaser;
    
    Game game;
    
    public Controller(Game game){
        this.game = game;         
     
    }     
        
    public void tick(){
        for(int i = 0; i < l.size(); i++){
            TempLaser = l.get(i);
            
            TempLaser.tick();            
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < l.size(); i++){
            TempLaser = l.get(i);
            
            TempLaser.render(g);
        }
    }
    
    public void addLaser(Laser block){
        l.add(block);
    }
    public void removeLaser(Laser block){
        l.remove(block);        
    }
    
}
