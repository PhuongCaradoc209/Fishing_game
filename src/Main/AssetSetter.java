package Main;

import entity.Animal_Cow;
import entity.Animal_Duck;
import entity.NPC_OldMan;
import object.*;
import tile_interactive.IT_Door_close;

import java.util.Random;

public class AssetSetter {
    GamePanel gp;
    private int i, mapNum;
    private Random random;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
        random = new Random();
    }

    public void setObject() {
        mapNum = 0;
        i = 0;
        gp.obj[mapNum].add(new OBJ_WALL_BOT(gp));
        gp.obj[mapNum].get(i).worldX = 19 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_BOT(gp));
        gp.obj[mapNum].get(i).worldX = 21 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_BOT(gp));
        gp.obj[mapNum].get(i).worldX = 22 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_LEFT(gp));
        gp.obj[mapNum].get(i).worldX = 18 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_LEFT(gp));
        gp.obj[mapNum].get(i).worldX = 18 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_LEFT(gp));
        gp.obj[mapNum].get(i).worldX = 18 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_LEFT(gp));
        gp.obj[mapNum].get(i).worldX = 18 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_RIGHT(gp));
        gp.obj[mapNum].get(i).worldX = 23 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_RIGHT(gp));
        gp.obj[mapNum].get(i).worldX = 23 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_RIGHT(gp));
        gp.obj[mapNum].get(i).worldX = 23 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_RIGHT(gp));
        gp.obj[mapNum].get(i).worldX = 23 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_TOP(gp));
        gp.obj[mapNum].get(i).worldX = 19 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 7 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_TOP(gp));
        gp.obj[mapNum].get(i).worldX = 20 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 7 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_TOP(gp));
        gp.obj[mapNum].get(i).worldX = 21 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 7 * gp.tileSize;
        i++;

        gp.obj[mapNum].add(new OBJ_WALL_TOP(gp));
        gp.obj[mapNum].get(i).worldX = 22 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 7 * gp.tileSize;
        i++;

        //Interior
        gp.obj[mapNum].add(new OBJ_SHELF(gp));
        gp.obj[mapNum].get(i).worldX = 22 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SHELF(gp));
        gp.obj[mapNum].get(i).worldX = 21 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SHELF(gp));
        gp.obj[mapNum].get(i).worldX = 20 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SHELF(gp));
        gp.obj[mapNum].get(i).worldX = 19 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 9 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SHELF_LEFT(gp));
        gp.obj[mapNum].get(i).worldX = 19 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 8 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SHELF_RIGHT(gp));
        gp.obj[mapNum].get(i).worldX = 22 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 8 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new OBJ_SOFA_TOP(gp));
        gp.obj[mapNum].get(i).worldX = (23 * gp.tileSize) - 16;
        gp.obj[mapNum].get(i).worldY = (11 * gp.tileSize) - 30;
        i++;
        gp.obj[mapNum].add(new OBJ_SOFA_BOTTOM(gp));
        gp.obj[mapNum].get(i).worldX = (23 * gp.tileSize) - 16;
        gp.obj[mapNum].get(i).worldY = (12 * gp.tileSize) - 30;
        i++;
        gp.obj[mapNum].add(new OBJ_CHEST(gp));
        gp.obj[mapNum].get(i).worldX = (19 * gp.tileSize) + 33;
        gp.obj[mapNum].get(i).worldY = (7 * gp.tileSize) + 22;
        i++;
        gp.obj[mapNum].add(new OBJ_CHEST(gp));
        gp.obj[mapNum].get(i).worldX = (20 * gp.tileSize) + 30;
        gp.obj[mapNum].get(i).worldY = (7 * gp.tileSize) + 22;
        i++;
        gp.obj[mapNum].add(new OBJ_CHEST(gp));
        gp.obj[mapNum].get(i).worldX = (21 * gp.tileSize) + 27;
        gp.obj[mapNum].get(i).worldY = (7 * gp.tileSize) + 22;
        i++;
        gp.obj[mapNum].add(new OBJ_FLOWER(gp));
        gp.obj[mapNum].get(i).worldX = (21 * gp.tileSize) + 5;
        gp.obj[mapNum].get(i).worldY = (13 * gp.tileSize) - 15;
        i++;
        gp.obj[mapNum].add(new OBJ_FLOWER(gp));
        gp.obj[mapNum].get(i).worldX = (22 * gp.tileSize) - 5;
        gp.obj[mapNum].get(i).worldY = (13 * gp.tileSize) - 15;
        i++;
        gp.obj[mapNum].add(new OBJ_FLOWER(gp));
        gp.obj[mapNum].get(i).worldX = (23 * gp.tileSize) - 15;
        gp.obj[mapNum].get(i).worldY = (13 * gp.tileSize) - 15;
        i++;

        mapNum = 1;
        i = 0;
        gp.obj[mapNum].add(new FishTank_SeaWeed(gp, 4 * gp.tileSize));
        gp.obj[mapNum].get(i).worldX = 16 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 5 * gp.tileSize;
        i++;
        gp.obj[mapNum].add(new FishTank_SeaWeed(gp, 3 * gp.tileSize));
        gp.obj[mapNum].get(i).worldX = 1 * gp.tileSize;
        gp.obj[mapNum].get(i).worldY = 5 * gp.tileSize;
        i++;
    }

    public void setNPC() {
        mapNum = 0;

        gp.npc[mapNum].add(new NPC_OldMan(gp));
        gp.npc[mapNum].get(0).worldX = gp.tileSize * 20;
        gp.npc[mapNum].get(0).worldY = gp.tileSize * 8;
    }

    public void setAnimal(int mapNum) {
        //PLAYER STATE
        i = 0;
        if (mapNum == 0) {
            gp.animal[mapNum].add(new Animal_Duck(gp));
            gp.animal[mapNum].get(i).worldX = gp.tileSize * 3;
            gp.animal[mapNum].get(i).worldY = gp.tileSize * 3;
            i++;

            gp.animal[mapNum].add(new Animal_Duck(gp));
            gp.animal[mapNum].get(i).worldX = gp.tileSize * 2;
            gp.animal[mapNum].get(i).worldY = gp.tileSize * 9;
            i++;

            gp.animal[mapNum].add(new Animal_Duck(gp));
            gp.animal[mapNum].get(i).worldX = gp.tileSize * 4;
            gp.animal[mapNum].get(i).worldY = gp.tileSize * 15;
            i++;

            gp.animal[mapNum].add(new Animal_Duck(gp));
            gp.animal[mapNum].get(i).worldX = gp.tileSize * 5;
            gp.animal[mapNum].get(i).worldY = gp.tileSize * 20;
            i++;

            gp.animal[mapNum].add(new Animal_Cow(gp));
            gp.animal[mapNum].get(i).worldX = gp.tileSize * 17;
            gp.animal[mapNum].get(i).worldY = gp.tileSize * 2;
            i++;
        } else if (mapNum == 1) {
            //FISH TANK STATE
            for (int j = 0; j < gp.player.inventory.size(); j++) {
                if (gp.player.inventory.get(j).caught) {
                    switch (gp.player.inventory.get(j).name) {
                        case "Big Head Carp":
                            gp.animal[mapNum].add(new Fish_Bigheadcarp(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Clown Fish":
                            gp.animal[mapNum].add(new Fish_Clownfish(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Coelacanth":
                            gp.animal[mapNum].add(new Fish_Coelacanths(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Grasscarp":
                            gp.animal[mapNum].add(new Fish_Grasscarp(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Hammer Head":
                            gp.animal[mapNum].add(new Fish_Hammerhead(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Herring":
                            gp.animal[mapNum].add(new Fish_Herring(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Koi Carp":
                            gp.animal[mapNum].add(new Fish_Koicarp(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Pomfret":
                            gp.animal[mapNum].add(new Fish_Pomfret(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Ray":
                            gp.animal[mapNum].add(new Fish_Ray(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Red Arowana":
                            gp.animal[mapNum].add(new Fish_Redarowna(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Remora":
                            gp.animal[mapNum].add(new Fish_Remora(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Shark":
                            gp.animal[mapNum].add(new Fish_Shark(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Silvercarp":
                            gp.animal[mapNum].add(new Fish_Silvercarp(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Sun Fish":
                            gp.animal[mapNum].add(new Fish_Sunfish(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                        case "Sword Fish":
                            gp.animal[mapNum].add(new Fish_Swordfish(gp));
                            gp.animal[mapNum].get(i).worldX = gp.tileSize * random.nextInt(11) + 3;
                            gp.animal[mapNum].get(i).worldY = gp.tileSize * random.nextInt(7) + 2;
                            i++;
                            break;
                    }
                }
            }
        }
    }

//    public void setDoorStatus(boolean isClosed){
//        if (!isClosed){
//            gp.obj[0] = doorOpen;
//        }
//        else gp.obj[0] = doorClose;
//    }

    public void setInteractiveTile() {
        mapNum = 0;

        i = 0;
        gp.iTile[mapNum].add(new IT_Door_close(gp,20,12));
    }
}