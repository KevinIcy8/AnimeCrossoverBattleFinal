package Entity;

import Test.GamePanel;
import Test.KeyHandling;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerTwo extends Entity{
    GamePanel gp;
    KeyHandling keyH;
    private int jumpHeight; //test
    private boolean falling = true;

    private boolean jumping = false;
    private float gravity = 0.0f;
    private final float MAX_SPEED = 10;

    public PlayerTwo(GamePanel gp, KeyHandling keyH){
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle(24,32,80,96);
        setDefaultValues();
        getPLayerImage();
    }

    public void setDefaultValues(){
        x = 1000;
        y = 100;
        speed = 10;
        jumpHeight = 25; //test
        direction = "left";
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
        groundCollisionOn = false;
        leftCollisionOn = false;
        rightCollisionOn = false;
        gp.cChecker.checkTile(this);

        //System.out.println(direction);
        if(!groundCollisionOn) {
            direction = "falling";
        }
        //if(jumping || falling){ //gravity
        gravity += 1;
        y += gravity;
        if(groundCollisionOn){
            //System.out.println(gravity);
            //System.out.println(y);
            y = 511.999999;
            //y = (y + (0 - gravity));
            //System.out.println(y);
            gravity = 0;
        }
        y += 1;

        y -= 1;
        //}

        if(keyH.spacePressed){ //reset
            x = 500;
            y = 511.9;
            gravity = 0;
        }
        if(keyH.upPressed2 || keyH.downPressed2 || keyH.leftPressed2 || keyH.rightPressed2){
            if(spriteNum == 3){
                spriteNum = 1;
            }

            if(keyH.upPressed2){//&& keyH.jumpCounter <= 1){
                direction = "up";
            }
            /*if(keyH.downPressed2){
                direction = "down";
            }*/
            if(keyH.leftPressed2){
                direction = "left";
            }
            if(keyH.rightPressed2){
                direction = "right";
            }

            if(groundCollisionOn){
                if ("up".equals(direction)) {
                    gravity = jumpHeight * (-1);
                }
                if(!leftCollisionOn) {
                    if ("left".equals(direction)) {
                        x -= speed;
                    }
                }
                if(!rightCollisionOn){
                    if ("right".equals(direction)) {
                        x += speed;
                    }
                }
            }

            if(!groundCollisionOn && !leftCollisionOn && !rightCollisionOn){
                switch (direction) {
                    //case "up" -> gravity = jumpHeight * (-1);
                    //case "down" -> y += speed;
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
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
            case "up":
            case "falling":
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
            case "down":
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
        g2.drawImage(image, (int)x, (int)y, gp.tileSize, gp.tileSize, null);
    }
}

