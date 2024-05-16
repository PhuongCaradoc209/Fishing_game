package Main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public boolean isWater = false;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkAtEdge(Entity entity) {
        //IF PLAYER MOVING TO THE EDGE
        switch (entity.direction) {
            case "up":
                if (entity.worldY <= 0) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                if (gp.worldHeight - entity.worldY - gp.tileSize - 5 <= 0) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                if (entity.worldX <= 0) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                if (gp.worldWidth - entity.worldX - gp.tileSize - 5 <= 0) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public void checkTile(Entity entity, boolean isDuck) {
        //CREATE COORDINATE OF 4 EDGES OF AN ENTITY
        double entityLeftWorldX = (entity.worldX + entity.solidArea.x);
        double entityRightWorldX = (entity.worldX + entity.solidArea.x + entity.solidArea.width);

        double entityTopWorldY = (entity.worldY + entity.solidArea.y);
        double entityBottomWorldY = (entity.worldY + entity.solidArea.y + entity.solidArea.height);

        int entityLeftCol = (int) (entityLeftWorldX / gp.tileSize);
        int entityRightCol = (int) (entityRightWorldX / gp.tileSize);

        int entityTopRow = (int) (entityTopWorldY / gp.tileSize);
        int entityBottomRow = (int) (entityBottomWorldY / gp.tileSize);

//        System.out.println("leftx " + entityLeftWorldX);
//        System.out.println("rightx " + entityRightWorldX);
//        System.out.println("right " + entityRightCol);
//        System.out.println("left " + entityLeftCol);
//
//        System.out.println("topy " + entityTopWorldY);
//        System.out.println("boty " + entityBottomWorldY);
//        System.out.println("topr " + entityTopRow);
//        System.out.println("botr " + entityBottomRow);

        //CHECK WHICH ARE TWO TILES FOR TWO SIDES OF ENTITY
        int tileNum1, tileNum2;
        switch (entity.direction) {
            case "up":
                //because when Entity go up, the first one that interacts with tiles is Top Edge,
                entityTopRow = (int) ((entityTopWorldY - entity.speed) / gp.tileSize);
                //so we find out what tile the player is trying to step in
                //tileNum1 is the point at the left-top conner of the entity
                tileNum1 = gp.tileMgr.mapTileNum[entityTopRow][entityLeftCol];
                //tileNum1 is the point at the right-top conner of the entity
                tileNum2 = gp.tileMgr.mapTileNum[entityTopRow][entityRightCol];
                if (gp.tileMgr.tile[tileNum1].collision || gp.tileMgr.tile[tileNum2].collision) {
                    entity.collisionOn = !isDuck;
                }
                
                for(int i = 27; i<=40 ; i++){
                if (gp.tm.tile[tileNum1] == gp.tm.tile[3] || gp.tm.tile[tileNum2] == gp.tm.tile[3]) {
                    isWater = true;
                    break;
                    }
                }
                
                break;

            case "down":
                entityBottomRow = (int) ((entityBottomWorldY + entity.speed) / gp.tileSize);
                tileNum1 = gp.tileMgr.mapTileNum[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileMgr.mapTileNum[entityBottomRow][entityRightCol];
                if (gp.tileMgr.tile[tileNum1].collision || gp.tileMgr.tile[tileNum2].collision) {
                    entity.collisionOn = !isDuck;
                }
                for(int i = 27; i<=40 ; i++){
                if (gp.tm.tile[tileNum1] == gp.tm.tile[3] || gp.tm.tile[tileNum2] == gp.tm.tile[3]) {
                    isWater = true;
                    break;
                    }
                }
                break;

            case "right":
                entityRightCol = (int) ((entityRightWorldX + entity.speed) / gp.tileSize);
                tileNum1 = gp.tileMgr.mapTileNum[entityTopRow][entityRightCol];
                tileNum2 = gp.tileMgr.mapTileNum[entityBottomRow][entityRightCol];
                if (gp.tileMgr.tile[tileNum1].collision || gp.tileMgr.tile[tileNum2].collision) {
                    entity.collisionOn = !isDuck;
                }
                for(int i = 27; i<=40 ; i++){
                if (gp.tm.tile[tileNum1] == gp.tm.tile[3] || gp.tm.tile[tileNum2] == gp.tm.tile[3]) {
                    isWater = true;
                    break;
                    }
                }
                break;

            case "left":
                entityLeftCol = (int) ((entityLeftWorldX - entity.speed) / gp.tileSize);
                tileNum1 = gp.tileMgr.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileMgr.mapTileNum[entityBottomRow][entityLeftCol];
                if (gp.tileMgr.tile[tileNum1].collision || gp.tileMgr.tile[tileNum2].collision) {
                    entity.collisionOn = !isDuck;
                }
                for(int i = 27; i<=40 ; i++){
                if (gp.tm.tile[tileNum1] == gp.tm.tile[3] || gp.tm.tile[tileNum2] == gp.tm.tile[3]) {
                    isWater = true;
                    break;
                    }
                }
                break;
        }
    }

    public int checkObj(Entity entity, boolean isPlayer) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                //get the entity's solid area position within the game world
                entity.solidArea.x = (int) (entity.worldX + entity.solidArea.x);
                entity.solidArea.y = (int) (entity.worldY + entity.solidArea.y);
                //get the object's solid area position within the game world
                gp.obj[i].solidArea.x = (int) (gp.obj[i].worldX + gp.obj[i].solidArea.x);
                gp.obj[i].solidArea.y = (int) (gp.obj[i].worldY + gp.obj[i].solidArea.y);

                switch (entity.direction) {
                    //SIMULATING ENTITY'S MOVEMENT AND CHECK WHERE IT WILL BE AFTER IT MOVED
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                    if (gp.obj[i].collision == true) {
                        entity.collisionOn = true;
                    }
                    if (isPlayer) {
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                //get the entity's solid area position within the game world
                entity.solidArea.x = (int) (entity.worldX + entity.solidArea.x);
                entity.solidArea.y = (int) (entity.worldY + entity.solidArea.y);
                //get the npc's solid area position within the game world
                target[i].solidArea.x = (int) (target[i].worldX + target[i].solidArea.x);
                target[i].solidArea.y = (int) (target[i].worldY + target[i].solidArea.y);

                switch (entity.direction) {
                    //SIMULATING ENTITY'S MOVEMENT AND CHECK WHERE IT WILL BE AFTER IT MOVED
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(target[i].solidArea)) {
                    if (target[i] != entity){
                        entity.collisionOn = true;
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    public void checkPlayer(Entity entity) {
        //get the entity's solid area position within the game world
        entity.solidArea.x = (int) (entity.worldX + entity.solidArea.x);
        entity.solidArea.y = (int) (entity.worldY + entity.solidArea.y);
        //get the player's solid area position within the game world
        gp.player.solidArea.x = (int) (gp.player.worldX + gp.player.solidArea.x);
        gp.player.solidArea.y = (int) (gp.player.worldY + gp.player.solidArea.y);

        switch (entity.direction) {
            //SIMULATING ENTITY'S MOVEMENT AND CHECK WHERE IT WILL BE AFTER IT MOVED
            case "up":
                entity.solidArea.y -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entity.solidArea.y += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }
}
