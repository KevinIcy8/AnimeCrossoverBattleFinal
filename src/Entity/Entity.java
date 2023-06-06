package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public double x,y;
    public int speed;

    public BufferedImage[] rightRunningAnimations, leftRunningAnimations, rightIdleAnimations, leftIdleAnimations, rightUltiAnimations;
    public BufferedImage[] rightBasicAnimations, leftBasicAnimations, rightSpecialAnimations, leftSpecialAnimations, leftUltiAnimations;


    public BufferedImage up1, up2, down1, down2, left1, left2, left3, right1, right2, right3;
    public BufferedImage basicLeft1, basicLeft2, basicLeft3, basicRight1, basicRight2, basicRight3;
    public String direction;
    //public boolean falling;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean groundCollisionOn = false;
    public boolean leftCollisionOn = false;
    public boolean rightCollisionOn = false;
    boolean attacking = false;



}
