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
    private int jumpHeight; //test
    private boolean falling = true;

    private boolean jumping = false;
    private float gravity = 0.0f;
    private final float MAX_SPEED = 10;
    private boolean wasFacingLeft;
    private boolean wasFacingRight;

    public Player(GamePanel gp, KeyHandling keyH){
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle(24,32,80,96);
        setDefaultValues();
        getPLayerImage();
        getPlayerAttackImage();

    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 10;
        jumpHeight = 25; //test
        direction = "right";
        wasFacingRight = true;
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
    public void getPlayerAttackImage(){
        try{
            basicLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackleft1.png")));
            basicLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackleft2.png")));
            basicLeft3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackleft3.png")));
            basicRight1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright1.png")));
            basicRight2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright2.png")));
            basicRight3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright3.png")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //SAVE FOR A LATER DATE
//    public BufferedImage setUp(String imagePath){
//        UtilityTool uTool = new UtilityTool;
//
//    }
    public void update(){
        System.out.println(keyH.attacking);
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
        if(keyH.jPressed){
            attacking = true;
            spriteCounter ++;
            if(spriteCounter <= 5){
                spriteNum = 1;
            }
            if(spriteNum > 5 && spriteCounter <= 10){
                spriteNum = 2;
            }
            if(spriteNum > 10 && spriteCounter <= 25){
                spriteNum = 3;
            }
            if(spriteNum > 25){
                spriteNum = 1;
                spriteCounter = 0;
                attacking = false;
            }
        }
        else if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(spriteNum == 3){
                spriteNum = 1;
            }

            if(keyH.upPressed){//&& keyH.jumpCounter <= 1){
                direction = "up";
            }
            /*if(keyH.downPressed){
                direction = "down";
            }*/
            if(keyH.leftPressed){
                direction = "left";
                wasFacingRight = false;
                wasFacingLeft = true;
            }
            if(keyH.rightPressed){
                direction = "right";
                wasFacingLeft = false;
                wasFacingRight = true;
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
                if(wasFacingRight){image = right3;}
                if(wasFacingLeft){image = left3;}
//                if(spriteNum == 1){
//                    image = left1;
//                }
//                if(spriteNum == 2){
//                    image = left2;
//                }
//                if(spriteNum == 3){
//                    image = left3; //left3 = stationary
//                }
                break;
//            case "down":
//                if(spriteNum == 1){
//                    image = right1;
//                }
//                if(spriteNum == 2){
//                    image = right2;
//                }
//                if(spriteNum == 3){
//                    image = right3; //right3 = stationary
//                }
//                break;
            case "left":
                if(!keyH.attacking) {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    } //left3 = stationary
                }
                if(keyH.attacking && wasFacingLeft){
                    if (spriteNum == 1) {
                        image = basicLeft1;
                    }
                    if (spriteNum == 2) {
                        image = basicLeft2;
                    }
                    if (spriteNum == 3) {
                        image = basicLeft3;
                    }
                }
                break;
            case "right":
                if(!keyH.attacking) {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    } //right3 = stationary
                }
                if(keyH.attacking){
                    if (spriteNum == 1) {
                        image = basicRight1;
                    }
                    if (spriteNum == 2) {
                        image = basicRight2;
                    }
                    if (spriteNum == 3) {
                        image = basicRight3;
                    }
                }
                break;
        }
        g2.drawImage(image, (int)x, (int)y, gp.tileSize, gp.tileSize, null);
    }
}
