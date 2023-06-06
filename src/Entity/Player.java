package Entity;

import Test.GamePanel;
import Test.KeyHandling;
import Test.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static Test.Constants.Directions.*;
import static Test.Constants.PlayerConstants.*;


public class Player extends Entity{
    GamePanel gp;
    KeyHandling keyH;
    UI ui;
    Characters characters;

    private int jumpHeight; //test
    private boolean falling = true;

    private boolean jumping = false;
    private float gravity = 0.0f;
    private final float MAX_SPEED = 10;
    private boolean wasFacingLeft;
    private boolean wasFacingRight;


    private int aniTick, aniIndex, aniSpeed = 6;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;
    //private BufferedImage[] rightRunningAnimations, leftRunningAnimations, rightIdleAnimations, leftIdleAnimations, rightUltiAnimations;
    //private BufferedImage[] rightBasicAnimations, leftBasicAnimations, rightSpecialAnimations, leftSpecialAnimations, leftUltiAnimations;

    public Player(GamePanel gp, KeyHandling keyH, UI ui, Characters characters){
        this.gp = gp;
        this.keyH = keyH;
        this.ui = ui;
        this.characters = characters;
        solidArea = new Rectangle(24,32,80,96);
        setDefaultValues();
        getPLayerMovementImage();
        loadAnimations();
        //getPlayerAttackImage();
    }

    public void loadAnimations(){
        try {
            BufferedImage leftIdleImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_idle_flipped-removebg-preview.png")));
            leftIdleAnimations = new BufferedImage[4];
            for (int i = 0; i < leftIdleAnimations.length; i++) {
                leftIdleAnimations[i] = leftIdleImg.getSubimage(i * 123, 0, 123, 126);
            }

            BufferedImage rightIdleImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_idle-removebg-preview.png")));
            rightIdleAnimations = new BufferedImage[4];
                for (int i = 0; i < rightIdleAnimations.length; i++) {
                    rightIdleAnimations[i] = rightIdleImg.getSubimage(i * 123, 0, 123, 126);
                }

            BufferedImage leftRunningImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_run_flipped-removebg-preview.png")));
            leftRunningAnimations = new BufferedImage[6];
            for (int i = 0; i < leftRunningAnimations.length; i++) {
                leftRunningAnimations[i] = leftRunningImg.getSubimage(i * 105, 0, 105, 112);
            }

            BufferedImage rightRunningImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_run-removebg-preview.png")));
            rightRunningAnimations = new BufferedImage[6];
                for (int i = 0; i < rightRunningAnimations.length; i++) {
                    rightRunningAnimations[i] = rightRunningImg.getSubimage(i * 105, 0, 105, 112);
                }
            BufferedImage leftBasicImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_basic_flipped-removebg-preview.png")));
            leftBasicAnimations = new BufferedImage[5];
            for (int i = 0; i < leftBasicAnimations.length; i++) {
                leftBasicAnimations[i] = leftBasicImg.getSubimage(i * 144, 0, 144, 114);
            }
            BufferedImage rightBasicImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_basic-removebg-preview.png")));
            rightBasicAnimations = new BufferedImage[5];
            for (int i = 0; i < rightBasicAnimations.length; i++) {
                rightBasicAnimations[i] = rightBasicImg.getSubimage(i * 144, 0, 144, 114);
            }

            BufferedImage leftSpecialImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_special_flipped-removebg-preview (1).png")));
            leftSpecialAnimations = new BufferedImage[3];
            for (int i = 0; i < leftSpecialAnimations.length; i++) {
                leftSpecialAnimations[i] = leftSpecialImg.getSubimage(i * 144, 0, 144, 110);
            }
            BufferedImage rightSpecialImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_special.png")));
            rightSpecialAnimations = new BufferedImage[3];
            for (int i = 0; i < rightSpecialAnimations.length; i++) {
                rightSpecialAnimations[i] = rightSpecialImg.getSubimage(i * 144, 0, 144, 110);
            }

            BufferedImage leftUltiImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_ult-removebg-preview.png")));
            leftUltiAnimations = new BufferedImage[7];
            for (int i = 0; i < leftUltiAnimations.length; i++) {
                leftUltiAnimations[i] = leftUltiImg.getSubimage(i * 176, 0, 176, 136);
            }

            BufferedImage rightUltiImg =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/naruto_ult-removebg-preview.png")));
            rightUltiAnimations = new BufferedImage[7];
            for (int i = 0; i < rightUltiAnimations.length; i++) {
                rightUltiAnimations[i] = rightUltiImg.getSubimage(i * 176, 0, 176, 136);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void updateAnimationTick(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
                attacking = false;
            }
        }
    }

//    public void setDirection(int direction){
//        this.playerDirection = direction;
//        moving = true;
//    }
//    public void setMoving(boolean moving){
//        this.moving = moving;
//    }

//    private void updatePos(){
//        if(moving){
//            switch(playerDirection){
//                case LEFT:
//                    x -= 5;
//                case UP:
//                    y += 5;
//                case RIGHT:
//                    x += 5;
//                case DOWN:
//                    y -= 5;
//            }
//        }
//    }
    public void setAnimations(){
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            playerAction = RUNNING;
        }
        else{
            playerAction = IDLE;
        }
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 10;
        jumpHeight = 25; //test
        direction = "right";
        playerAction = IDLE;
        wasFacingRight = true;
    }
    public void getPLayerMovementImage(){
        //gp.characters.loadMovementImage();
//        System.out.println(gp.ui.characterSelectedP1);
//
            try {
                if(gp.ui.characterSelectedP1.equals("dark_deku")) {
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left1.png.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left2.png.png")));
                    left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_left3.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right1.png.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right2.png.png")));
                    right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("characters/dark_deku/dark_deku_right3.png")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
//    public void getPlayerAttackImage(){
//        try{
////            basicLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/BasicAtk/basic_attackleft1.png")));
////            basicLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackleft2.png")));
////            basicLeft3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackleft3.png")));
////            basicRight1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright1.png")));
////            basicRight2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright2.png")));
////            basicRight3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/basic_attackright3.png")));
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//    }

    //SAVE FOR A LATER DATE
//    public BufferedImage setUp(String imagePath){
//        UtilityTool uTool = new UtilityTool;
//
//    }
    public void update(){
        //System.out.println(playerAction);
        //gp.characters.loadMovementImage();
        getPLayerMovementImage();
        updateAnimationTick();
       // setAnimations();
            //updatePos();
        //System.out.println(aniIndex);

        //System.out.println(keyH.attacking);
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
        if(keyH.basicPressed){
            attacking = true;
            playerAction = BASIC_ATK;
//            spriteCounter ++;
//            if(spriteCounter <= 5){
//                spriteNum = 1;
//            }
//            if(spriteNum > 5 && spriteCounter <= 10){
//                spriteNum = 2;
//            }
//            if(spriteNum > 10 && spriteCounter <= 25){
//                spriteNum = 3;
//            }
//            if(spriteNum > 25){
//                spriteNum = 1;
//                spriteCounter = 0;
//                attacking = false;
//            }
        }
        else if(keyH.specialPressed){

            attacking = true;
            playerAction = SPECIAL_ATK;
        }
        else if(keyH.ultiPressed){
            attacking = true;
            playerAction = ULTI;
        }
        else if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(spriteNum == 3){
                spriteNum = 1;
            }

            if(keyH.upPressed){//&& keyH.jumpCounter <= 1){
                direction = "up";
                playerAction = RUNNING;
            }
            /*if(keyH.downPressed){
                direction = "down";
            }*/
            if(keyH.leftPressed){
                direction = "left";
                wasFacingRight = false;
                wasFacingLeft = true;
                playerAction = RUNNING;
            }
            if(keyH.rightPressed){
                direction = "right";
                wasFacingLeft = false;
                wasFacingRight = true;
                playerAction = RUNNING;
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
            if (attacking) {
                return;
            }
            spriteNum = 3;
            playerAction = IDLE;
        }
    }
    public void draw(Graphics2D g2){
//        BufferedImage image = null;
        switch (direction){
            case "up":
            case "falling":
               if(wasFacingRight){
                   if(playerAction == RUNNING) {
                       g2.drawImage(rightRunningAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                   }
                   if(playerAction == IDLE){
                       g2.drawImage(rightIdleAnimations[aniIndex], (int)x, (int)y, 160, 168, null);
                   }
               }
                if(wasFacingLeft){
                    if(playerAction == RUNNING) {
                        g2.drawImage(leftRunningAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                    }
                    if(playerAction == IDLE){
                        g2.drawImage(leftIdleAnimations[aniIndex], (int)x, (int)y, 160, 168, null);
                    }
                }

                break;
//          case "down":

            case "left":


                if(playerAction != BASIC_ATK && playerAction != SPECIAL_ATK && playerAction != ULTI) {
                if (playerAction == RUNNING) {
                    g2.drawImage(leftIdleAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                }
                if (playerAction == IDLE) {
                    g2.drawImage(leftIdleAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                }
                }
                else {
                    if (playerAction == BASIC_ATK) {
                        g2.drawImage(leftBasicAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                    if (playerAction == SPECIAL_ATK) {
                        g2.drawImage(leftSpecialAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                    if (playerAction == ULTI) {
                        g2.drawImage(leftUltiAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                }
//                if(!keyH.attacking) {
//                    if (spriteNum == 1) {
//                        image = left1;
//                    }
//                    if (spriteNum == 2) {
//                        image = left2;
//                    }
//                    if (spriteNum == 3) {
//                        image = left3;
//                    } //left3 = stationary
//                }
//                if(keyH.attacking && wasFacingLeft){
//                    if (spriteNum == 1) {
//                        image = basicLeft1;
//                    }
//                    if (spriteNum == 2) {
//                        image = basicLeft2;
//                    }
//                    if (spriteNum == 3) {
//                        image = basicLeft3;
//                    }
//                }
                break;
            case "right":
                if(playerAction != BASIC_ATK && playerAction != SPECIAL_ATK && playerAction != ULTI) {
                    if (playerAction == RUNNING) {
                        g2.drawImage(rightRunningAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                    }
                    if (playerAction == IDLE) {
                        g2.drawImage(rightIdleAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                    }
                }
                else {
                    if (playerAction == BASIC_ATK) {
                        g2.drawImage(rightBasicAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                    if (playerAction == SPECIAL_ATK) {
                        g2.drawImage(rightSpecialAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                    if (playerAction == ULTI) {
                        g2.drawImage(rightUltiAnimations[aniIndex], (int) x, (int) y, 160, 168, null);
                        //attacking = false;
                    }
                }

//                if(!keyH.attacking) {
//                    if (spriteNum == 1) {
//                        image = right1;
//                    }
//                    if (spriteNum == 2) {
//                        image = right2;
//                    }
//                    if (spriteNum == 3) {
//                        image = right3;
//                    } //right3 = stationary
//                }
//                if(keyH.attacking){
//                    if (spriteNum == 1) {
//                        image = basicRight1;
//                    }
//                    if (spriteNum == 2) {
//                        image = basicRight2;
//                    }
//                    if (spriteNum == 3) {
//                        image = basicRight3;
//                    }
//                }
                break;
        }
//        g2.drawImage(image, (int)x, (int)y, gp.tileSize, gp.tileSize, null);
    }
}
