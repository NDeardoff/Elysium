package game;

import Audio.SoundEffects;
import display.Display;
import elysium.Handler;
import entities.creatures.Controller;
import entities.creatures.Laser;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import gfx.Assets;
import gfx.GameCamera;
import input.KeyManager;
import input.MouseManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import states.GameState;
import states.MenuState;
import states.State;


/**
 *
 * Main file
 */
public class Game implements Runnable {
    
    SoundEffects player = new SoundEffects("Laser");
    private Display display;    
    private int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState; 
    public State menuState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    //Shooting stuff
    private Controller c;
    private boolean isShooting = false;
    public static int shootDirection;
    
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title; 
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    private void init()
    {
       display = new Display(title, width, height);
       display.getFrame().addKeyListener(keyManager);
       display.getFrame().addMouseListener(mouseManager);
       display.getFrame().addMouseMotionListener(mouseManager);
       display.getCanvas().addMouseListener(mouseManager);
       display.getCanvas().addMouseMotionListener(mouseManager);        
       Assets.init();
       
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
       
       gameState = new GameState(handler);
       menuState = new MenuState(handler);
       State.setState(menuState);
       
       c = new Controller(this);
    }
    
    
    
    private void tick()
    {
        keyManager.tick();
        c.tick();
        laserDirection();
        shoot();
        resetShoot();
         
        if(State.getState() != null)
          State.getState().tick();    
      
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Begin Drawing 
        
        
        
        if(State.getState() != null)
          State.getState().render(g);        
        
        c.render(g);
        
        //End Drawing
        bs.show();
        g.dispose();
    } 
    
    public void laserDirection(){
        if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp&& handler.getKeyManager().shootRight) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootUp && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().left && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 1;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp&& handler.getKeyManager().shootRight) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootUp && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().right && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 2;
        }else if (handler.getKeyManager().up && handler.getKeyManager().down && handler.getKeyManager().shootUp) {
            shootDirection = 3;  
        }else if (handler.getKeyManager().up && handler.getKeyManager().down && handler.getKeyManager().shootLeft) {
            shootDirection = 1; 
        }else if (handler.getKeyManager().up && handler.getKeyManager().down && handler.getKeyManager().shootRight) {
            shootDirection = 2; 
        }else if (handler.getKeyManager().up && handler.getKeyManager().down) {
            shootDirection = 4;    
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp&& handler.getKeyManager().shootRight) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootUp && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().up && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 3;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootLeft) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp&& handler.getKeyManager().shootRight) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootUp && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootLeft && handler.getKeyManager().shootRight) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootLeft && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if (handler.getKeyManager().shootRight && handler.getKeyManager().shootDown) {
            shootDirection = 4;
        }else if(handler.getKeyManager().shootUp){
            shootDirection = 3;            
        }else if(handler.getKeyManager().shootDown){
            shootDirection = 4;
        }else if(handler.getKeyManager().right && handler.getKeyManager().shootLeft){
            shootDirection = 1;
        }else if(handler.getKeyManager().right){
            shootDirection = 2;    
        }else if(handler.getKeyManager().left && handler.getKeyManager().shootRight){
            shootDirection = 2;
        }else if(handler.getKeyManager().left){
            shootDirection = 1;        
        }else if(handler.getKeyManager().shootLeft){
            shootDirection = 1;
        }else if(handler.getKeyManager().shootRight){
            shootDirection = 2;
        }else if (handler.getKeyManager().up){
            shootDirection = 3;
        }else if (handler.getKeyManager().down){
            shootDirection = 4; 
        }else
            shootDirection = 4;
    }
   

    public void shoot() {
        if(handler.getKeyManager().shootLaser && !isShooting){
            isShooting = true;
            c.addLaser(new Laser(250, 265, this, shootDirection)); 
            LaserSound();
        }      
               
    }  
    
    public void resetShoot(){
        if(!handler.getKeyManager().shootLaser){
            isShooting = false;
        }                    
    }
             
    public void run()
    {
        init();        
        
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
            tick();
            render();
            ticks++;
            delta--;
            }
            
            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }       
        stop();
    }
    
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() 
    {
        if(!running)
            return;
        running = false;
        try{
       thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void LaserSound(){
        thread = new Thread(player);
        thread.start();
    }
}
