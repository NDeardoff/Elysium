package input;

import game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * Input
 */
public class KeyManager implements KeyListener{
     
    private boolean[] keys;
    public boolean up, down, left, right, shootUp, shootDown, shootLeft, shootRight, shootLaser;
   
    public KeyManager(){
        keys = new boolean[256];        
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        shootUp = keys[KeyEvent.VK_UP];
        shootDown = keys[KeyEvent.VK_DOWN];
        shootLeft = keys[KeyEvent.VK_LEFT];
        shootRight = keys[KeyEvent.VK_RIGHT];
        shootLaser = keys[KeyEvent.VK_SPACE]; 
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed!");        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;   
    }
    
}
