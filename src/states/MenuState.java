package states;

import Audio.Music;
import elysium.Handler;
import game.Game;
import gfx.ImageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Menu State
 */
public class MenuState extends State {
    
    Music player = new Music("NewTest");
    private Thread thread;
    private boolean musicM = false;
    private BufferedImage menuImage;
    
    public MenuState(Handler handler){
        super(handler);
        
        
    }

    @Override
    public void tick() {
       if(handler.getKeyManager().shootLaser){
            State.setState(handler.getGame().gameState);
            
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        menuImage = ImageLoader.LoadImage("/textures/Elysium.png");
        g.drawImage(menuImage, 35, 75, null);
    }
}
