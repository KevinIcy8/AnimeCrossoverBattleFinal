package Entity;

import Test.GamePanel;
import Test.KeyHandling;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandling keyH;

    public Player(GamePanel gp, KeyHandling keyH){
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle(21,42,86,86);
        setDefaultValues();
        getPLayerImage();

    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 10;
        direction = "right";
    }
    public void getPLayerImage(){
        try{

        left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_left1.png.png")));
        left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_left2.png.png")));
        left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_left3.png")));
        right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_right1.png.png")));
        right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_right2.png.png")));
        right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/dark_deku_right3.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(spriteNum == 3){
                spriteNum = 1;
            }
            if(keyH.upPressed){
                direction = "up";

            }
            else if(keyH.downPressed){
                direction = "down";

            }
            else if(keyH.leftPressed){
                direction = "left";
            }
            else if(keyH.rightPressed){
                direction = "right";
            }
            collisionOn = false;
            gp.cChecker.checkTile(this);
            if(collisionOn == false){
                switch(direction){
                    case "up":
                        y -= speed;
                    break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else{
            spriteNum = 3;
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
        /*g2.setColor(Color.BLACK);
        g2.fillRect(x,y, gp.tileSize, gp.tileSize);*/
        BufferedImage image = null;
        switch (direction){
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3; //left3 = stationary
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3; //right3 = stationary
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
