package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * Tiles
 */
public class Tile {
    
    //STATIC STUFF HERE
    
    public static Tile[] tiles = new Tile[256];
    public static Tile FloorTile = new FloorTile(0);
    public static Tile WallTile = new WallTile(1);
    public static Tile GrateFloor = new GrateFloor(2);    
    public static Tile nwCorner = new nwCorner(3);
    public static Tile neCorner = new neCorner(4);
    public static Tile swCorner = new swCorner(5);
    public static Tile seCorner = new seCorner(6);
    public static Tile wFloor = new wFloor(9);
    public static Tile eFloor = new eFloor(10);
    public static Tile nFloor = new nFloor(7);
    public static Tile sFloor = new sFloor(8);
    public static Tile orFloorTile = new orFloorTile(11);
    public static Tile orNwCorner = new orNwCorner(12);
    public static Tile orNeCorner = new orNeCorner(13);
    public static Tile orSwCorner = new orSwCorner(14);
    public static Tile orSeCorner = new orSeCorner(15);
    public static Tile orWFloor = new orWFloor(16);
    public static Tile orEFloor = new orEFloor(17);
    public static Tile orNFloor = new orNFloor(18);
    public static Tile orSFloor = new orSFloor(19);
    public static Tile whFloorTile = new whFloorTile(21);
    public static Tile whNwCorner = new whNwCorner(22);
    public static Tile whNeCorner = new whNeCorner(23);
    public static Tile whSwCorner = new whSwCorner(24);
    public static Tile whSeCorner = new whSeCorner(25);
    public static Tile whWFloor = new whWFloor(26);
    public static Tile whEFloor = new whEFloor(27);
    public static Tile whNFloor = new whNFloor(28);
    public static Tile whSFloor = new whSFloor(29);
    public static Tile rdFloorTile = new rdFloorTile(31);
    public static Tile rdNwCorner = new rdNwCorner(32);
    public static Tile rdNeCorner = new rdNeCorner(33);
    public static Tile rdSwCorner = new rdSwCorner(34);
    public static Tile rdSeCorner = new rdSeCorner(35);
    public static Tile rdWFloor = new rdWFloor(36);
    public static Tile rdEFloor = new rdEFloor(37);
    public static Tile rdNFloor = new rdNFloor(38);
    public static Tile rdSFloor = new rdSFloor(39);
    public static Tile grFloorTile = new grFloorTile(41);
    public static Tile grNwCorner = new grNwCorner(42);
    public static Tile grNeCorner = new grNeCorner(43);
    public static Tile grSwCorner = new grSwCorner(44);
    public static Tile grSeCorner = new grSeCorner(45);
    public static Tile grWFloor = new grWFloor(46);
    public static Tile grEFloor = new grEFloor(47);
    public static Tile grNFloor = new grNFloor(48);
    public static Tile grSFloor = new grSFloor(49);
    
    //CLASS
    
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id; 
        
        tiles[id] = this;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);        
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId(){
        return id;
    }
    
}
