package Entity;

import Test.GamePanel;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class Characters extends Entity{
    GamePanel gp;
    String[][] charOrder = new String[3][3];

    public Characters(GamePanel gp){
        this.gp = gp;
        loadMovementImage();
        try {
            InputStream is = getClass().getResourceAsStream("/characterSelection/characterSelectionOrder.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < charOrder[0].length && row < charOrder.length) {
                String line = br.readLine();
                while (col < charOrder[0].length) {
                    String[] characters = line.split(",");
                    String character = characters[col];
                    charOrder[col][row] = character;
                    col++;
                }
                if (col == charOrder[0].length) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e){

        }
    }

    public void loadMovementImage(){
        try{
            //if(gp.ui.characterSelectedP1.equals("dark_deku")){
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left1.png.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left2.png.png")));
                left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left3.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right1.png.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right2.png.png")));
                right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right3.png")));
            //}
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getCharacterSelected(int charSelectNumX, int charSelectNumY){
        String chara = charOrder[charSelectNumX][charSelectNumY];
        return chara;

    }

    public void update(){
        loadMovementImage();
    }



    //public void printCharacter(){
        //System.out.println(charOrder[0][1]);
//        for(int row = 0; row < 3; row++){
//            for(int col = 0; col < 3; col++){
//                System.out.print(charOrder[row][col]+", ");
//            }
//        }

    //}
}
