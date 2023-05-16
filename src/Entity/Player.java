package Entity;

import Test.GamePanel;
import Test.KeyHandling;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandling keyH;

    public Player(GamePanel gp, KeyHandling keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keyH.upPressed){
            y -= speed;
        }
        else if(keyH.downPressed){
            y += speed;
        }
        else if(keyH.leftPressed){
            x -= speed;
        }
        else if(keyH.rightPressed){
            x += speed;
        }
        /*if(keyH.upPressed2){
            player2Y -= playerSpeed;
        }
        else if(keyH.downPressed2){
            player2Y += playerSpeed;
        }
        else if(keyH.leftPressed2){
            player2X -= playerSpeed;
        }
        else if(keyH.rightPressed2){
            player2X += playerSpeed;
        }*/
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillRect(x,y, gp.tileSize, gp.tileSize);
    }
}