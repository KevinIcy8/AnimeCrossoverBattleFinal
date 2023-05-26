package Test;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;
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
        if(gp.gameState == gp.controlState){
            drawControlScreen();
        }

    }

    public void drawTitleScreen(){
        g2.setColor(new Color(192,192,192));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Anime Fighting Game";
        int x = getXForCenteredText(text);
        int y = gp.tileSize;

        g2.setColor(Color.BLACK);
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

    public void drawControlScreen(){
        //g2.drawRenderableImage();
    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
