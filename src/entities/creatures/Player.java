package entities.creatures;

import elysium.Handler;
import game.Game;
import gfx.Animation;
import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * Player
 */
public class Player extends Creature {    
    
    //Animations
    private Animation animDown, animUp, animLeft, animRight, attackDown, attackUp,
            attackLeft, attackRight, animStand;   
           
  
    public Player(Handler handler, float x, float y) {
        super(handler, x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds. height = 32;
        
        //Animations
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        attackDown = new Animation(500, Assets.player_down);
        attackUp = new Animation(500, Assets.player_up);
        attackLeft = new Animation(500, Assets.player_left);
        attackRight = new Animation(500, Assets.player_right);
        animStand = new Animation(500, Assets.player_stand);      
    
    }   
    
    @Override
    public void tick() {
        //Animations
        attackDown.tick();
        attackUp.tick();
        attackLeft.tick();
        attackRight.tick();  
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animStand.tick();
        //Movement
        getInput();       
        move(); 
        handler.getGameCamera().centerOnEntity(this);
        
    }
    
    @Override
    public void die(){
        System.out.println("You lose");
    }   
        
    public void getInput(){
        xMove = 0;
        yMove = 0;
        
        //shooting animation inputs
        if(handler.getKeyManager().shootLeft)
            leftShot = true; 
        else leftShot = false;
        if(handler.getKeyManager().shootRight)
            rightShot = true;
        else rightShot = false;
        if(handler.getKeyManager().shootUp)
            upShot = true;
        else upShot = false;
        if(handler.getKeyManager().shootDown)
            downShot = true;
        else downShot = false;
        
        //should not be able to shoot in more than 1 direction
        if(handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight)
            leftShot = false;
        if(handler.getKeyManager().shootLeft && handler.getKeyManager().shootUp)
            leftShot = false;
        if(handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown)
            leftShot = false;
        if(handler.getKeyManager().shootRight && handler.getKeyManager().shootLeft)
            rightShot = false;
        if(handler.getKeyManager().shootRight && handler.getKeyManager().shootUp)
            rightShot = false;
        if(handler.getKeyManager().shootRight && handler.getKeyManager().shootDown)
            rightShot = false;
        if(handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft)
            upShot = false;
        if(handler.getKeyManager().shootUp && handler.getKeyManager().shootRight)
            upShot = false;
        if(handler.getKeyManager().shootUp && handler.getKeyManager().shootDown)
            upShot = false;
        if(handler.getKeyManager().shootDown && handler.getKeyManager().shootLeft)
            downShot = false;
        if(handler.getKeyManager().shootDown && handler.getKeyManager().shootRight)
            downShot = false;
        if(handler.getKeyManager().shootDown && handler.getKeyManager().shootUp)
            downShot = false;

        
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;       
             
            
    }

    @Override
    public void render(Graphics g) {       

        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
           //    g.setColor(Color.red);
    //   g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
    //            (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
    //            bounds.width, bounds.height);    
    
    }
    
    private BufferedImage getCurrentAnimationFrame(){

        if(leftShot){
            return attackLeft.getCurrentFrame();
        }else if(rightShot){
            return attackRight.getCurrentFrame();
        }else if(upShot){
            return attackUp.getCurrentFrame();
        }else if(downShot){
            return attackDown.getCurrentFrame();        
        }else if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }else{
            return animStand.getCurrentFrame();
        }              
    } 
     
}
           

