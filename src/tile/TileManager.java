package tile;

import Test.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public Tile[] background;
    public int[][] mapTileNum;
    private int randomNum;

    public TileManager(GamePanel gp){
        this.gp = gp;
        randomNum = (int) (Math.random()*10);
        tile = new Tile[10];
        background = new Tile[10];
        mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/testMap.txt");
    }
    public void getTileImage(){
        try{

            File file = new File("res/tiles/sky.png.png");
            FileInputStream fis = new FileInputStream(file);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fis);

            file = new File("res/tiles/castle_brick.png");
            fis = new FileInputStream(file);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fis);
            tile[1].collision = true;

            file = new File("res/maps/black_clover_skull_map.png");
            fis = new FileInputStream(file);
            background[0] = new Tile();
            background[0].image = ImageIO.read(fis);

            file = new File("res/maps/boar_hat_map.jpeg");
            fis = new FileInputStream(file);
            background[1] = new Tile();
            background[1].image = ImageIO.read(fis);

            file = new File("res/maps/final_valley_map.png");
            fis = new FileInputStream(file);
            background[2] = new Tile();
            background[2].image = ImageIO.read(fis);

            file = new File("res/maps/greed_island_map.png");
            fis = new FileInputStream(file);
            background[3] = new Tile();
            background[3].image = ImageIO.read(fis);

            file = new File("res/maps/hueco_mundo_map.png");
            fis = new FileInputStream(file);
            background[4] = new Tile();
            background[4].image = ImageIO.read(fis);

            file = new File("res/maps/jjk_kyoto_high_map.png");
            fis = new FileInputStream(file);
            background[5] = new Tile();
            background[5].image = ImageIO.read(fis);

            file = new File("res/maps/morioh_rohan_map.jpeg");
            fis = new FileInputStream(file);
            background[6] = new Tile();
            background[6].image = ImageIO.read(fis);

            file = new File("res/maps/ua_map.png");
            fis = new FileInputStream(file);
            background[7] = new Tile();
            background[7].image = ImageIO.read(fis);

            file = new File("res/maps/wall_rose_map.jpeg");
            fis = new FileInputStream(file);
            background[8] = new Tile();
            background[8].image = ImageIO.read(fis);

            file = new File("res/maps/wisteria_kny_map.jpeg");
            fis = new FileInputStream(file);
            background[9] = new Tile();
            background[9].image = ImageIO.read(fis);
            /*tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/tiles/sky.png.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/tiles/castle_brick.png")));*/
        }catch(IOException e){

            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while(col < gp.maxScreenCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
        g2.drawImage(background[randomNum].image,0,0,gp.screenWidth,gp.screenHeight,null);
    }
}
