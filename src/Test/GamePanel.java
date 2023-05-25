package Test;

import Entity.Player;
import Entity.PlayerTwo;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int origTileSize = 32;
    final int scale = 4;
    public final int tileSize = origTileSize * scale;
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandling keyH = new KeyHandling();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    Player player = new Player(this, keyH);
    PlayerTwo playerTwo = new PlayerTwo(this, keyH);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    /*public void run() {

        double drawInterval = (double)1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            update(); //updates information (i.e. character location)

            repaint(); //draws the screen according to the update

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
    public void run(){
        double drawInterval = (double)1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        /*if(keyH.upPressed){
            player1Y -= playerSpeed;
        }
        else if(keyH.downPressed){
            player1Y += playerSpeed;
        }
        else if(keyH.leftPressed){
            player1X -= playerSpeed;
        }
        else if(keyH.rightPressed){
            player1X += playerSpeed;
        }
        if(keyH.upPressed2){
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
        player.update();
        playerTwo.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        /*p1.setColor(Color.BLACK);
        p1.fillRect(player1X,player1Y, tileSize, tileSize);*/
        Graphics2D p2 = (Graphics2D) g;
        /*p2.setColor(Color.BLUE);
        p2.fillRect(player2X,player2Y,tileSize,tileSize);*/
        tileM.draw(g2);
        player.draw(g2);
        playerTwo.draw(g2);
        g2.dispose();
        p2.dispose();
    }
}
