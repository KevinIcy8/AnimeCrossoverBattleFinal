package tile;

import Test.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();

    }
    public void getTileImage(){
        try{
            File file = new File("res/tiles/castle_brick.png");
            FileInputStream fis = new FileInputStream(file);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fis);
            tile[0].collision = true;
            /*tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/castle_brick.png")));
        */
        }catch(IOException e){

            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        g2.drawImage(tile[0].image, 0, 600, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 128, 600, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 256, 600, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 384, 600, gp.tileSize, gp.tileSize, null);
       /* while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }*/

    }
}
