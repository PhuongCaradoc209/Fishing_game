package Main;

import entity.Entity;

import java.util.Random;
import object.*;

public class InventoryManagement {
    public Entity[] inventory;
    GamePanel gp;

    public InventoryManagement(GamePanel gp){
        this.gp = gp;
        inventory = new Entity[24];
        getInformation();
    }

    public void getInformation(){
        inventory[0] = new Fish_Bigheadcarp(gp);
        inventory[1] = new Fish_Herring(gp);
        inventory[2] = new Fish_Grasscarp(gp);
        inventory[3] = new Fish_Silvercarp(gp);
        inventory[4] = new Fish_Clownfish(gp);
        inventory[5] = new Fish_Remora(gp);
        inventory[6] = new Fish_Coelacanths(gp);
        inventory[7] = new Fish_Redarowna(gp);
        inventory[8] = new Fish_Pomfret(gp);
        inventory[9] = new Fish_Koicarp(gp);
        inventory[10] = new Fish_Sunfish(gp);
        inventory[11] = new Fish_Ray(gp);
        inventory[12] = new Fish_Swordfish(gp);
        inventory[13] = new Fish_Hammerhead(gp);
        inventory[14] = new Fish_Shark(gp);
        inventory[15] = new OBJ_Can(gp);
        inventory[16] = new OBJ_Bottle(gp);
    }

    public void Fishing(int rod) {
        int num = 100;
        Random rd = new Random();
        switch (rod) {
            case 1:
                int value = rd.nextInt(100) + 1;
                if (value >= 1 && value <= 35) {
                    gp.inventoryMng.inventory[0].caught = true;
                    gp.inventoryMng.inventory[0].count++;
                    num = 0;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[0]);
                } else if (value >= 36 && value <= 70) {
                    gp.inventoryMng.inventory[1].caught = true;
                    gp.inventoryMng.inventory[1].count++;
                    num = 1;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[1]);
                } else if (value >= 70 && value <= 75) {
                    gp.inventoryMng.inventory[15].caught = true;
                    gp.inventoryMng.inventory[15].count++;
                    num = 15;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[15]);
                } else if (value >= 76 && value <= 80) {
                    gp.inventoryMng.inventory[16].caught = true;
                    gp.inventoryMng.inventory[16].count++;
                    num = 16;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[16]);
                } else if (value >= 81 && value <= 92) {
                    gp.inventoryMng.inventory[2].caught = true;
                    gp.inventoryMng.inventory[2].count++;
                    num = 2;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[2]);
                } else if (value >= 93 && value <= 99) {
                    gp.inventoryMng.inventory[3].caught = true;
                    gp.inventoryMng.inventory[3].count++;
                    num = 3;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[3]);
                } else if (value == 100) {
                    gp.inventoryMng.inventory[4].caught = true;
                    gp.inventoryMng.inventory[4].count++;
                    num = 4;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[4]);
                }
                gp.gameState = gp.fishingState;
                setDisplay(num);
                break;
            case 2:
                   value = rd.nextInt(1000) + 1;
                 //value = 74;
                if (value >= 1 && value <= 16) {
                    gp.inventoryMng.inventory[0].caught = true;
                    gp.inventoryMng.inventory[0].count++;
                    num = 0;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[0]);
                } else if (value >= 17 && value <= 32) {
                    gp.inventoryMng.inventory[1].caught = true;
                    gp.inventoryMng.inventory[1].count++;
                    num = 1;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[1]);
                } else if (value >= 33 && value <= 72) {
                    gp.inventoryMng.inventory[15].caught = true;
                    gp.inventoryMng.inventory[15].count++;
                    num = 15;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[15]);
                } else if (value >= 73 && value <= 112) {
                    gp.inventoryMng.inventory[16].caught = true;
                    gp.inventoryMng.inventory[16].count++;
                    num = 16;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[16]);
                } else if (value >= 113 && value <= 144) {
                    gp.inventoryMng.inventory[2].caught = true;
                    gp.inventoryMng.inventory[2].count++;
                    num = 2;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[2]);
                } else if (value >= 145 && value <= 180) {
                    gp.inventoryMng.inventory[3].caught = true;
                    gp.inventoryMng.inventory[3].count++;
                    num = 3;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[3]);
                } else if (value >= 181 && value <= 200) {
                    gp.inventoryMng.inventory[4].caught = true;
                    gp.inventoryMng.inventory[4].count++;
                    num = 4;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[4]);
                } else if (value >= 201 && value <= 520) {
                    gp.inventoryMng.inventory[5].caught = true;
                    gp.inventoryMng.inventory[5].count++;
                    num = 5;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[5]);
                } else if (value >= 521 && value <= 840) {
                    gp.inventoryMng.inventory[6].caught = true;
                    gp.inventoryMng.inventory[6].count++;
                    num = 6;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[6]);
                } else if (value >= 841 && value <= 920) {
                    gp.inventoryMng.inventory[7].caught = true;
                    gp.inventoryMng.inventory[7].count++;
                    num = 7;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[7]);

                } else if (value >= 921 && value <= 970) {
                    gp.inventoryMng.inventory[8].caught = true;
                    gp.inventoryMng.inventory[8].count++;
                    num = 8;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[8]);

                } else if (value >= 971 && value <= 1000) {
                    gp.inventoryMng.inventory[9].caught = true;
                    gp.inventoryMng.inventory[9].count++;
                    num = 9;
                    gp.player.canObtainItem(gp.inventoryMng.inventory[9]);

                }
                setDisplay(num);
                gp.gameState = gp.fishingState;

                break;

            case 3:
                break;
        }
    }
    public void setImage(Entity e){
        if(e.caught == true){
            e.fishFinalImage = e.collection_image;
        }
    }

    public void setDisplay(int i){
        gp.ui.fishName = gp.inventoryMng.inventory[i].name;
        gp.ui.fishPrice = gp.inventoryMng.inventory[i].price+"";
        gp.ui.fishRarity = gp.inventoryMng.inventory[i].fishRarity;
        gp.ui.fishImage = gp.inventoryMng.inventory[i].collection_image;
        gp.ui.fishFrame = gp.inventoryMng.inventory[i].fishFrame;
    }
}
