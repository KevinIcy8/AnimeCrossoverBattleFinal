package Test;

import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    BufferedImage singlePlayerTitle, twoPlayerTitle, controlTitle, exitTitle;
    BufferedImage darkDekuImage, narutoImage, lightYagamiImage, tanjiroImage, ichigoImage, gonImage, erenImage, gojoImage, astaImage;
    public int commandNum = 0;
    public int charSelectNumX = 0;
    public int charSelectNumY = 0;
    public BufferedImage image;
    public BufferedImage[] images;


    public UI(GamePanel gp){
        this.gp = gp;
        getTitleImages();
        getCharacterSelectionImages();
//        try{
//
//        }
//        catch(){
//
//        }catch(){}
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);

        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        if(gp.gameState == gp.singlePlayState){
            drawSinglePlayerScreen();
        }
        if(gp.gameState == gp.characterSelectionState){
            drawCharSelectionScreen();
        }
        if(gp.gameState == gp.controlState){
            drawControlScreen();
        }

    }
    public void loadCharacterConfiguration(){

    }
    public void getTitleImages(){
        try{
            singlePlayerTitle = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("titleScreen/ichigo_titleScreen.jpeg")));
            twoPlayerTitle = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("titleScreen/sasukevsnaruto.jpeg")));
            controlTitle = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("titleScreen/makima_controls.jpeg")));
            exitTitle = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("titleScreen/animecrossover_exit.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getCharacterSelectionImages(){
        try{

            darkDekuImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/dark_deku_head.png")));
            narutoImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/naruto_head.png")));
            lightYagamiImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/light_yagami_head.png")));
            tanjiroImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/tanjiro_head.png")));
            ichigoImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/ichigo_head.png")));
            gonImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/gon_head.png")));
            gojoImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/gojo_head.png")));
            erenImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/eren_yeager_head.png")));
            astaImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characterSelection/asta_head.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void drawTitleScreen(){
        BufferedImage image = null;
        if(commandNum == 0){
            image = singlePlayerTitle;
            g2.drawImage(image,0,0, gp.screenWidth, gp.screenHeight,null);
        }
        else if(commandNum == 1){
            image = twoPlayerTitle;
            g2.drawImage(image,0,0, gp.screenWidth, gp.screenHeight,null);
        }
        else if(commandNum == 2){
            image = controlTitle;
            g2.drawImage(image,0,0, gp.screenWidth, gp.screenHeight,null);
        }
        else if(commandNum == 3) {
            image = exitTitle;
            g2.drawImage(image,0, 0, gp.screenWidth, gp.screenHeight, null);
        }
        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Anime Smash Bros";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(128,128,128));
        g2.drawString(text,x, y);

        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "Single Player";
        x = getXForCenteredText(text);
        y += gp.tileSize * 1.5;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y);
            //g2.drawString("<", gp.screenWidth-x, y);
        }

        text = "Two Player";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y);
            //g2.drawString("<",x+gp.tileSize, y);
        }

        text = "Controls";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y);
            //g2.drawString("<",x+gp.tileSize, y);
        }

        text = "Exit";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 3){
            g2.drawString(">",x-gp.tileSize, y);
            //g2.drawString("<",x+gp.tileSize, y);
        }
    }

    public void drawCharSelectionScreen(){
        int spacing = 5;
        int startX = 350;
        int startY = 170;
        int pictureSpacing = 10;
        int width = 180;
        int height = 126;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Two Player";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(0,0,0));
        g2.drawString(text,x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        g2.setColor(Color.RED);
        g2.fillRect(10,150,gp.tileSize + 50,gp.tileSize*2); //rectangle for where the character is display p1
        text = "P1";
        g2.drawString(text,10, 140);
        //g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2); //rectangle to know which character is player 1 currently hovering over

        g2.setColor(Color.BLUE);
        g2.fillRect(gp.screenWidth-10-(gp.tileSize+50),150,gp.tileSize + 50,gp.tileSize*2);//rectangle for where the character is display p2
        text = "P2";
        g2.drawString(text,gp.screenWidth-10-(gp.tileSize+50), 140);
        g2.fillRect(startX + (width + pictureSpacing)*2-spacing,startY-spacing,180 + spacing*2,126 + spacing*2); //rectangle to know which character is player 2 currently hovering over

        if(charSelectNumX == 0 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 0 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 0 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY+(height+spacing)*2 + 5,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }


        g2.drawImage(darkDekuImage,startX,startY,width,height,null);
        g2.drawImage(narutoImage, startX + width + pictureSpacing, startY, 180, 126, null);
        g2.drawImage(lightYagamiImage,startX + (width + pictureSpacing)*2,startY,180,126,null); //x = 680
        g2.drawImage(tanjiroImage, startX, startY + height + pictureSpacing, 180, 126, null);
        g2.drawImage(ichigoImage,startX + width + pictureSpacing,startY + height + pictureSpacing,180,126,null);
        g2.drawImage(gonImage, startX + (width + pictureSpacing)*2, startY + height + pictureSpacing, 180, 126, null);
        g2.drawImage(gojoImage, startX, startY + (height + pictureSpacing)*2, 180, 126, null);
        g2.drawImage(erenImage,startX + width + pictureSpacing,startY + (height + pictureSpacing)*2,180,126,null);
        g2.drawImage(astaImage, startX + (width + pictureSpacing)*2, startY + (height + pictureSpacing)*2, 180, 126, null);
    }

    public void drawControlScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Controls";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(0,0,0));
        g2.drawString(text,x, y);

    }
    public void drawSinglePlayerScreen(){ //WIP not gonna completed by due date
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Single Player";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(0,0,0));
        g2.drawString(text,x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,150F));
        text = "WIP";
        x = getXForCenteredText(text);
        y += gp.tileSize * 1.5;
        g2.drawString(text,x,y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "Press escape to return to menu";
        x = getXForCenteredText(text);
        y += gp.tileSize * 1.5;
        g2.drawString(text,x,y);
    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
