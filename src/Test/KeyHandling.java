package Test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandling implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upPressed2, downPressed2, leftPressed2, rightPressed2;
    //Attack Keys
    public boolean jPressed;
    public boolean attacking;
    public boolean spacePressed;
    public int jumpCounter;
    public KeyHandling(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(gp.gameState == gp.titleState){
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 3;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 3){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.singlePlayState;
                    //stuff needs to be added for this
                }
                if(gp.ui.commandNum == 1){
                    //gp.gameState = gp.twoPlayState;
                    gp.gameState = gp.characterSelectionState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.controlState;
                    //stuff needs to be added for this
                }
                if(gp.ui.commandNum == 3){
                    System.exit(0);
                }
            }
        }
        if(gp.gameState == gp.singlePlayState){
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titleState;
            }
        }
        if(gp.gameState == gp.controlState){
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titleState;
            }
        }
        if(gp.gameState == gp.characterSelectionState){
            if (code == KeyEvent.VK_W) {
                gp.ui.charSelectNumY--;
                if(gp.ui.charSelectNumY < 0){
                    gp.ui.charSelectNumY = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.charSelectNumY++;
                if(gp.ui.charSelectNumY > 2){
                    gp.ui.charSelectNumY = 0;
                }
            }
            if (code == KeyEvent.VK_A) {
                gp.ui.charSelectNumX--;
                if(gp.ui.charSelectNumX < 0){
                    gp.ui.charSelectNumX = 2;
                }
            }
            if (code == KeyEvent.VK_D) {
                gp.ui.charSelectNumX++;
                if(gp.ui.charSelectNumX > 2){
                    gp.ui.charSelectNumX = 0;
                }
            }
            if (code == KeyEvent.VK_UP) {
                gp.ui.charSelectNumY2--;
                if(gp.ui.charSelectNumY2 < 0){
                    gp.ui.charSelectNumY2 = 2;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.ui.charSelectNumY2++;
                if(gp.ui.charSelectNumY2 > 2){
                    gp.ui.charSelectNumY2 = 0;
                }
            }
            if (code == KeyEvent.VK_LEFT) {
                gp.ui.charSelectNumX2--;
                if(gp.ui.charSelectNumX2 < 0){
                    gp.ui.charSelectNumX2 = 2;
                }
            }
            if (code == KeyEvent.VK_RIGHT) {
                gp.ui.charSelectNumX2++;
                if(gp.ui.charSelectNumX2 > 2){
                    gp.ui.charSelectNumX2 = 0;
                }
            }
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titleState;
            }
            if(code == KeyEvent.VK_C){ //select button player 1
                gp.ui.characterSelectedP1 =  gp.characters.getCharacterSelected(gp.ui.charSelectNumX,gp.ui.charSelectNumY);
            }
            if(code == KeyEvent.VK_8){ //select button player 2
                gp.ui.characterSelectedP2 =  gp.characters.getCharacterSelected(gp.ui.charSelectNumX2,gp.ui.charSelectNumY2);
            }
        }

        if(gp.gameState == gp.singlePlayState || gp.gameState == gp.twoPlayState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
                jumpCounter++;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_UP) {
                upPressed2 = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed2 = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed2 = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed2 = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
            if (code == KeyEvent.VK_J) {
                jPressed = true;
                attacking = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
            jumpCounter = 0;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_UP){
            upPressed2 = false;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed2 = false;
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed2 = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed2 = false;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_J){
            jPressed = false;
            attacking = false;
        }


    }
}
