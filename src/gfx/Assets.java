package gfx;

import java.awt.image.BufferedImage;

/**
 *Assets
 */
public class Assets {
    
    private static final int width = 32, height = 32;
    
    public static BufferedImage floor, wall, console, grateFloor, eastFloor, westFloor, northFloor, 
            southFloor, nEastCorner, sEastCorner, nWestCorner, sWestCorner, laser, orFloor, orEastFloor, 
            orWestFloor, orNorthFloor, orSouthFloor, orNEastCorner, orSEastCorner, orNWestCorner, orSWestCorner, whFloor, whEastFloor, 
            whWestFloor, whNorthFloor, whSouthFloor, whNEastCorner, whSEastCorner, whNWestCorner, whSWestCorner, rdFloor, rdEastFloor, 
            rdWestFloor, rdNorthFloor, rdSouthFloor, rdNEastCorner, rdSEastCorner, rdNWestCorner, rdSWestCorner, grFloor, grEastFloor, 
            grWestFloor, grNorthFloor, grSouthFloor, grNEastCorner, grSEastCorner, grNWestCorner, grSWestCorner;
    public static BufferedImage[] player_down, player_left, player_right, player_up, player_stand, laserShot;
       
    public static void init()
    {
       SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sheet.png"));
       SpriteSheet player = new SpriteSheet(ImageLoader.LoadImage("/textures/main sheet.png"));
       
       player_stand = new BufferedImage[1];
       
       player_stand[0] = player.crop(width * 11, height * 4, width, height);
       
       player_down = new BufferedImage[2];
       
       player_down[0] = player.crop(width * 10, height * 4, width, height);
       player_down[1] = player.crop(width * 12, height * 4, width, height);
              
       player_left = new BufferedImage[2];
       
       player_left[0] = player.crop(width * 10, height * 5, width, height);
       player_left[1] = player.crop(width * 12, height * 5, width, height);
              
       player_right = new BufferedImage[2];
       
       player_right[0] = player.crop(width * 10, height * 6, width, height);
       player_right[1] = player.crop(width * 12, height * 6, width, height);
              
       player_up = new BufferedImage[2];
       
       player_up[0] = player.crop(width * 10, height * 7, width, height);
       player_up[1] = player.crop(width * 12, height * 7, width, height);
       
       
       floor = sheet.crop((width * 3), (height * 2), width, height);
       wall = sheet.crop(0, (height * 8), width, height);
       console = player.crop(width * 10, (height * 12), width, height * 2);
       grateFloor = player.crop(width * 4, (height * 4), width, height);
       eastFloor = sheet.crop(width * 5, (height * 3), width, height);
       westFloor = sheet.crop(width * 1, (height * 2), width, height);
       northFloor = sheet.crop(width * 2, (height), width, height);
       southFloor = sheet.crop(width * 2, (height * 5), width, height);
       nEastCorner = sheet.crop(width * 5, (height), width, height);
       sEastCorner = sheet.crop(width * 5, (height * 5), width, height);
       nWestCorner = sheet.crop(width, (height), width, height);
       sWestCorner = sheet.crop(width, (height * 5), width, height);
       
       orFloor = player.crop((width), (height), width, height);
       orEastFloor = player.crop(width * 2, (height), width, height);
       orWestFloor = player.crop(0, (height), width, height);
       orNorthFloor = player.crop(width, (0), width, height);
       orSouthFloor = player.crop(width, (height * 2), width, height);
       orNEastCorner = player.crop(width * 2, (0), width, height);
       orSEastCorner = player.crop(width * 2, (height * 2), width, height);
       orNWestCorner = player.crop(0, (0), width, height);
       orSWestCorner = player.crop(0, (height * 2), width, height);
       
       whFloor = player.crop((width), (height * 4), width, height);
       whEastFloor = player.crop(width * 2, (height * 4), width, height);
       whWestFloor = player.crop(0, (height * 4), width, height);
       whNorthFloor = player.crop(width, (height * 3), width, height);
       whSouthFloor = player.crop(width, (height * 5), width, height);
       whNEastCorner = player.crop(width * 2, (height * 3), width, height);
       whSEastCorner = player.crop(width * 2, (height * 5), width, height);
       whNWestCorner = player.crop(0, (height * 3), width, height);
       whSWestCorner = player.crop(0, (height * 5), width, height);
       
       rdFloor = player.crop((width), (height * 7), width, height);
       rdEastFloor = player.crop(width * 2, (height * 7), width, height);
       rdWestFloor = player.crop(0, (height * 7), width, height);
       rdNorthFloor = player.crop(width, (height * 6), width, height);
       rdSouthFloor = player.crop(width, (height * 8), width, height);
       rdNEastCorner = player.crop(width * 2, (height * 7), width, height);
       rdSEastCorner = player.crop(width * 2, (height * 8), width, height);
       rdNWestCorner = player.crop(0, (height * 7), width, height);
       rdSWestCorner = player.crop(0, (height * 8), width, height);
       
       grFloor = player.crop((width), (height * 10), width, height);
       grEastFloor = player.crop(width * 2, (height * 10), width, height);
       grWestFloor = player.crop(0, (height * 10), width, height);
       grNorthFloor = player.crop(width, (height * 9), width, height);
       grSouthFloor = player.crop(width, (height * 11), width, height);
       grNEastCorner = player.crop(width * 2, (height * 9), width, height);
       grSEastCorner = player.crop(width * 2, (height * 11), width, height);
       grNWestCorner = player.crop(0, (height * 9), width, height);
       grSWestCorner = player.crop(0, (height * 11), width, height);
       
       laser = sheet.crop(width * 6 + 13, height * 7 + 13, 5, 5);
    }
    
}
