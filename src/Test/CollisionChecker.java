package Test;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.x + entity.solidArea.x;
    }
}
