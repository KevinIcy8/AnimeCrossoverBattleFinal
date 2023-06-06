package Test;

import Entity.Entity;
import Entity.Player;

public class CollisionChecker {
    GamePanel gp;
    Player player;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = (int) (entity.x + entity.solidArea.x);
        int entityRightWorldX = (int) (entity.x + entity.solidArea.x + entity.solidArea.width);
        int entityTopWorldY = (int) (entity.y + entity.solidArea.y);
        int entityBottomWorldY = (int) (entity.y + entity.solidArea.y + entity.solidArea.height);

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;


        switch (entity.direction) {
            case "falling"-> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                //System.out.println(tileNum1);
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                //System.out.println(tileNum2);
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.groundCollisionOn = true;
                }

                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.leftCollisionOn = true;
                }

                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.rightCollisionOn = true;
                }
            }


           /* case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;*/


            case "left" -> {
                if(entityLeftWorldX - entity.speed <= 0){
                    entity.leftCollisionOn = true;
                }
//                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
//                //System.out.println(entityLeftCol);
//                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
//                    entity.leftCollisionOn = true;
//                }
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.groundCollisionOn = true;
                }
            }
            case "right" -> {
                if(entityRightWorldX + entity.speed >= gp.screenWidth){
                    entity.rightCollisionOn = true;
                }
//                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
//                System.out.println(entityRightCol);
//                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
//                    entity.rightCollisionOn = true;
//                }
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.groundCollisionOn = true;
                }
            }
        }
    }
}

