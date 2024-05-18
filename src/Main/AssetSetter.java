package Main;

import entity.Animal_Cow;
import entity.Animal_Duck;
import entity.NPC_OldMan;
import object.*;
import tile_interactive.IT_Door_close;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int i = 0;
        gp.obj[i] = new OBJ_WALL_BOT(gp);
        gp.obj[i].worldX = 19 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_BOT(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_BOT(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_LEFT(gp);
        gp.obj[i].worldX = 18 * gp.tileSize;
        gp.obj[i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_LEFT(gp);
        gp.obj[i].worldX = 18 * gp.tileSize;
        gp.obj[i].worldY = 10 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_LEFT(gp);
        gp.obj[i].worldX = 18 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_LEFT(gp);
        gp.obj[i].worldX = 18 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[i]= new OBJ_WALL_RIGHT(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_RIGHT(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 10 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_RIGHT(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_RIGHT(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_TOP(gp);
        gp.obj[i].worldX = 19 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_TOP(gp);
        gp.obj[i].worldX = 20 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_TOP(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_WALL_TOP(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;

        //Interior
        gp.obj[i] = new OBJ_SHELF(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SHELF(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SHELF(gp);
        gp.obj[i].worldX = 20 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SHELF(gp);
        gp.obj[i].worldX = 19 * gp.tileSize;
        gp.obj[i].worldY = 9 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SHELF_LEFT(gp);
        gp.obj[i].worldX = 19 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SHELF_RIGHT(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_SOFA_TOP(gp);
        gp.obj[i].worldX = (23 * gp.tileSize)-16;
        gp.obj[i].worldY = (11 * gp.tileSize)-30;
        i++;
        gp.obj[i] = new OBJ_SOFA_BOTTOM(gp);
        gp.obj[i].worldX = (23 * gp.tileSize)-16;
        gp.obj[i].worldY = (12 * gp.tileSize)-30;
        i++;
        gp.obj[i] = new OBJ_CHEST(gp);
        gp.obj[i].worldX = (19 * gp.tileSize)+33;
        gp.obj[i].worldY = (7 * gp.tileSize)+22;
        i++;
        gp.obj[i] = new OBJ_CHEST(gp);
        gp.obj[i].worldX = (20 * gp.tileSize)+30;
        gp.obj[i].worldY = (7 * gp.tileSize)+22;
        i++;
        gp.obj[i] = new OBJ_CHEST(gp);
        gp.obj[i].worldX = (21 * gp.tileSize)+27;
        gp.obj[i].worldY = (7 * gp.tileSize)+22;
        i++;
        gp.obj[i] = new OBJ_FLOWER(gp);
        gp.obj[i].worldX = (21 * gp.tileSize)+5;
        gp.obj[i].worldY = (13 * gp.tileSize)-15;
        i++;
        gp.obj[i] = new OBJ_FLOWER(gp);
        gp.obj[i].worldX = (22 * gp.tileSize)-5;
        gp.obj[i].worldY = (13 * gp.tileSize)-15;
        i++;
        gp.obj[i] = new OBJ_FLOWER(gp);
        gp.obj[i].worldX = (23 * gp.tileSize)-15;
        gp.obj[i].worldY = (13 * gp.tileSize)-15;
        i++;

    }

    public void setNPC() {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 20;
        gp.npc[0].worldY = gp.tileSize * 8;
    }
    
    public void setAnimal(){
        gp.animal[0] = new Animal_Duck(gp);
        gp.animal[0].worldX = gp.tileSize * 5;
        gp.animal[0].worldY = gp.tileSize * 3;

        gp.animal[1] = new Animal_Duck(gp);
        gp.animal[1].worldX = gp.tileSize * 2;
        gp.animal[1].worldY = gp.tileSize * 9;

        gp.animal[2] = new Animal_Duck(gp);
        gp.animal[2].worldX = gp.tileSize * 4;
        gp.animal[2].worldY = gp.tileSize * 10;

        gp.animal[3] = new Animal_Duck(gp);
        gp.animal[3].worldX = gp.tileSize * 5;
        gp.animal[3].worldY = gp.tileSize * 20;

        gp.animal[4] = new Animal_Cow(gp);
        gp.animal[4].worldX = gp.tileSize * 17;
        gp.animal[4].worldY = gp.tileSize * 2;
    }

//    public void setDoorStatus(boolean isClosed){
//        if (!isClosed){
//            gp.obj[0] = doorOpen;
//        }
//        else gp.obj[0] = doorClose;
//    }

    public void setInteractiveTile(){
        int i = 0;
        gp.iTile[i] = new IT_Door_close(gp, 10,12);
    }
}