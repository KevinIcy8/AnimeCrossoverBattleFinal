package Test;

import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class
UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    BufferedImage singlePlayerTitle, twoPlayerTitle, controlTitle, exitTitle;
    BufferedImage darkDekuImage, narutoImage, lightYagamiImage, tanjiroImage, ichigoImage, gonImage, erenImage, gojoImage, astaImage;
    public int commandNum = 0;
    public int charSelectNumX = 0;
    public int charSelectNumY = 0;
    public int charSelectNumX2 = 2;
    public int charSelectNumY2 = 0;
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
        int startX1 = 350;
        int startY1 = 170;
        int pictureSpacing = 10;
        int width = 180;
        int height = 126;
        int startX2 = startX1 + (width + pictureSpacing)*2;
        int startY2 = startY1;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Two Player";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(0,0,0));
        g2.drawString(text,x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        g2.setColor(Color.RED);
        g2.fillRect(10,150,gp.tileSize*2,gp.tileSize*3); //rectangle for where the character is display p1
        text = "P1";
        g2.drawString(text,10, 140);


        g2.setColor(Color.BLUE);
        g2.fillRect(gp.screenWidth-10-(gp.tileSize*2),150,gp.tileSize*2,gp.tileSize*3);//rectangle for where the character is display p2
        text = "P2";
        g2.drawString(text,gp.screenWidth-10-(gp.tileSize+50), 140);


        if(charSelectNumX == charSelectNumX2 && charSelectNumY == charSelectNumY2){
            charSelectSame(startX1,startY1,width,height,spacing);//if player 1 and player 2 chooses the same character
        }
        else {
            characterSelect1(startX1, startY1, width, height, spacing);//rectangle to know which character is player 1 currently hovering over
            characterSelect2(startX1, startY1, width, height, spacing);//rectangle to know which character is player 2 currently hovering over
        }
        g2.drawImage(darkDekuImage,startX1,startY1,width,height,null);
        g2.drawImage(narutoImage, startX1 + width + pictureSpacing, startY1, 180, 126, null);
        g2.drawImage(lightYagamiImage,startX1 + (width + pictureSpacing)*2,startY1,180,126,null); //x = 680
        g2.drawImage(tanjiroImage, startX1, startY1 + height + pictureSpacing, 180, 126, null);
        g2.drawImage(ichigoImage,startX1 + width + pictureSpacing,startY1 + height + pictureSpacing,180,126,null);
        g2.drawImage(gonImage, startX1 + (width + pictureSpacing)*2, startY1 + height + pictureSpacing, 180, 126, null);
        g2.drawImage(gojoImage, startX1, startY1 + (height + pictureSpacing)*2, 180, 126, null);
        g2.drawImage(erenImage,startX1 + width + pictureSpacing,startY1 + (height + pictureSpacing)*2,180,126,null);
        g2.drawImage(astaImage, startX1 + (width + pictureSpacing)*2, startY1 + (height + pictureSpacing)*2, 180, 126, null);
    }



    public void drawControlScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Controls";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(new Color(0,0,0));
        g2.drawString(text,x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text = "P1";
        g2.setColor(Color.RED);
        g2.drawString(text,10, 140);
        g2.setColor(Color.BLACK);
        text = "Up: W\nDown: S\nLeft: cA\nRight: cD\nNormal: C\nSpecial: V\nUlt: X";
        g2.drawString(text,10, 160);

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
    public void charSelectSame(int startX,int startY,int width,int height,int spacing){
        if(charSelectNumX == 0 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX - spacing, startY + height + spacing);
            p2.addPoint(startX - spacing, startY - spacing);
            p2.addPoint(startX + width + spacing, startY - spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width + spacing, startY - spacing);
            p.addPoint(startX + width + spacing, startY + height + spacing);
            p.addPoint(startX - spacing, startY + height + spacing);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 0 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX - spacing, startY + height*2 + spacing*3);
            p2.addPoint(startX - spacing, startY +height+spacing);
            p2.addPoint(startX + width + spacing, startY +height+ spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width + spacing, startY +height+ spacing);
            p.addPoint(startX + width + spacing, startY + height*2 + spacing*3);
            p.addPoint(startX - spacing, startY + height*2 + spacing*3);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 0 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX - spacing, startY + height*3 + spacing*5);
            p2.addPoint(startX - spacing, startY +height*2+ spacing*3);
            p2.addPoint(startX + width + spacing, startY +height*2+ spacing*3);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width + spacing, startY +height*2+ spacing*3);
            p.addPoint(startX + width + spacing, startY + height*3 + spacing*5);
            p.addPoint(startX - spacing, startY + height*3 + spacing*5);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 1 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width + spacing, startY + height + spacing);
            p2.addPoint(startX + width + spacing, startY - spacing);
            p2.addPoint(startX + width*2 + spacing*3, startY - spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*2 + spacing*3, startY - spacing);
            p.addPoint(startX + width*2 + spacing*3, startY + height + spacing);
            p.addPoint(startX + width + spacing, startY + height + spacing);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 1 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width + spacing, startY + height*2 + spacing*3);
            p2.addPoint(startX + width + spacing, startY +height+spacing);
            p2.addPoint(startX + width*2 + spacing*3, startY +height+ spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*2 + spacing*3, startY +height+ spacing);
            p.addPoint(startX + width*2 + spacing*3, startY + height*2 + spacing*3);
            p.addPoint(startX + width + spacing, startY + height*2 + spacing*3);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 1 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width + spacing, startY + height*3 + spacing*5);
            p2.addPoint(startX + width + spacing, startY +height*2+ spacing*3);
            p2.addPoint(startX + width*2 + spacing*3, startY +height*2+ spacing*3);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*2 + spacing*3, startY +height*2+ spacing*3);
            p.addPoint(startX + width*2 + spacing*3, startY + height*3 + spacing*5);
            p.addPoint(startX + width + spacing, startY + height*3 + spacing*5);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 2 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width*2 + spacing*3, startY + height + spacing);
            p2.addPoint(startX + width*2 + spacing*3, startY - spacing);
            p2.addPoint(startX + width*3 + spacing*5, startY - spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*3 + spacing*5, startY - spacing);
            p.addPoint(startX + width*3 + spacing*5, startY + height + spacing);
            p.addPoint(startX + width*2 + spacing*3, startY + height + spacing);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 2 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width*2 + spacing*3, startY + height*2 + spacing*3);
            p2.addPoint(startX + width*2 + spacing*3, startY +height+spacing);
            p2.addPoint(startX + width*3 + spacing*5, startY +height+ spacing);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*3 + spacing*5, startY +height+ spacing);
            p.addPoint(startX + width*3 + spacing*5, startY + height*2 + spacing*3);
            p.addPoint(startX + width*2 + spacing*3, startY + height*2 + spacing*3);
            g2.fillPolygon(p);
        }
        if(charSelectNumX == 2 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            Polygon p2 = new Polygon();
            p2.addPoint(startX + width*2 + spacing*3, startY + height*3 + spacing*5);
            p2.addPoint(startX + width*2 + spacing*3, startY +height*2+ spacing*3);
            p2.addPoint(startX + width*3 + spacing*5, startY +height*2+ spacing*3);
            g2.fillPolygon(p2);

            g2.setColor(Color.BLUE);
            Polygon p = new Polygon();
            p.addPoint(startX + width*3 + spacing*5, startY +height*2+ spacing*3);
            p.addPoint(startX + width*3 + spacing*5, startY + height*3 + spacing*5);
            p.addPoint(startX + width*2 + spacing*3, startY + height*3 + spacing*5);
            g2.fillPolygon(p);
        }
    }
    public void characterSelect2(int startX, int startY, int width, int height, int spacing){
        if(charSelectNumX2 == 0 && charSelectNumY2 == 0){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX-spacing,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 0 && charSelectNumY2 == 1){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX-spacing,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 0 && charSelectNumY2 == 2){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX-spacing,startY+(height*2)+spacing*3,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 1 && charSelectNumY2 == 0){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing + width,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 1 && charSelectNumY2 == 1){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing + width,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 1 && charSelectNumY2 == 2){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing + width,startY+(height*2) + spacing*3,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 2 && charSelectNumY2 == 0){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing*3 + width*2,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 2 && charSelectNumY2 == 1){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing*3 + width*2,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX2 == 2 && charSelectNumY2 == 2){
            g2.setColor(Color.BLUE);
            g2.fillRect(startX+spacing*3 + width*2,startY+(height*2) + spacing*3,180 + spacing*2,126 + spacing*2);
        }
    }

    public void characterSelect1(int startX, int startY, int width, int height, int spacing){
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
            g2.fillRect(startX-spacing,startY+(height*2)+spacing*3,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing + width,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing + width,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 1 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing + width,startY+(height*2) + spacing*3,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 0){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing*3 + width*2,startY-spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 1){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing*3 + width*2,startY+(height)+spacing,180 + spacing*2,126 + spacing*2);
        }
        if(charSelectNumX == 2 && charSelectNumY == 2){
            g2.setColor(Color.RED);
            g2.fillRect(startX+spacing*3 + width*2,startY+(height*2) + spacing*3,180 + spacing*2,126 + spacing*2);
        }
    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
