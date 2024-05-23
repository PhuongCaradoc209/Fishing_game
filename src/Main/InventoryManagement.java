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
//                int value = rd.nextInt(100) + 1;
                int value = 35;
                if (value >= 1 && value <= 35) {
                    gp.iManage.inventory[0].caught = true;
                    gp.iManage.inventory[0].count++;
                    num = 0;

                } else if (value >= 36 && value <= 70) {
                    gp.iManage.inventory[1].caught = true;
                    gp.iManage.inventory[1].count++;
                    num = 1;

                } else if (value >= 70 && value <= 75) {
                    gp.iManage.inventory[15].caught = true;
                    gp.iManage.inventory[15].count++;
                    num = 15;

                } else if (value >= 76 && value <= 80) {
                    gp.iManage.inventory[16].caught = true;
                    gp.iManage.inventory[16].count++;
                    num = 16;

                } else if (value >= 81 && value <= 92) {
                    gp.iManage.inventory[2].caught = true;
                    gp.iManage.inventory[2].count++;
                    num = 2;

                } else if (value >= 93 && value <= 99) {
                    gp.iManage.inventory[3].caught = true;
                    gp.iManage.inventory[3].count++;
                    num = 3;

                } else if (value == 100) {
                    gp.iManage.inventory[4].caught = true;
                    gp.iManage.inventory[4].count++;
                    num = 4;
                }
                gp.gameState = gp.fishingState;
                setDisplay(num);
                break;
            case 2:
                   value = rd.nextInt(1000) + 1;
                 //value = 74;
                if (value >= 1 && value <= 16) {
                    gp.iManage.inventory[0].caught = true;
                    gp.iManage.inventory[0].count++;
                    num = 0;

                } else if (value >= 17 && value <= 32) {
                    gp.iManage.inventory[1].caught = true;
                    gp.iManage.inventory[1].count++;
                    num = 1;

                } else if (value >= 33 && value <= 72) {
                    gp.iManage.inventory[15].caught = true;
                    gp.iManage.inventory[15].count++;
                    num = 15;

                } else if (value >= 73 && value <= 112) {
                    gp.iManage.inventory[16].caught = true;
                    gp.iManage.inventory[16].count++;
                    num = 16;

                } else if (value >= 113 && value <= 144) {
                    gp.iManage.inventory[2].caught = true;
                    gp.iManage.inventory[2].count++;
                    num = 2;

                } else if (value >= 145 && value <= 180) {
                    gp.iManage.inventory[3].caught = true;
                    gp.iManage.inventory[3].count++;
                    num = 3;

                } else if (value >= 181 && value <= 200) {
                    gp.iManage.inventory[4].caught = true;
                    gp.iManage.inventory[4].count++;
                    num = 4;

                } else if (value >= 201 && value <= 520) {
                    gp.iManage.inventory[5].caught = true;
                    gp.iManage.inventory[5].count++;
                    num = 5;

                } else if (value >= 521 && value <= 840) {
                    gp.iManage.inventory[6].caught = true;
                    gp.iManage.inventory[6].count++;
                    num = 6;

                } else if (value >= 841 && value <= 920) {
                    gp.iManage.inventory[7].caught = true;
                    gp.iManage.inventory[7].count++;
                    num = 7;


                } else if (value >= 921 && value <= 970) {
                    gp.iManage.inventory[8].caught = true;
                    gp.iManage.inventory[8].count++;
                    num = 8;


                } else if (value >= 971 && value <= 1000) {
                    gp.iManage.inventory[9].caught = true;
                    gp.iManage.inventory[9].count++;
                    num = 9;

                }
                setDisplay(num);
                gp.gameState = gp.fishingState;

                break;

            case 3:
                break;
        }

        //Adding fish to inventory
        gp.player.canObtainItem(gp.iManage.inventory[num]);
    }
    public void setImage(Entity e){
        if(e.caught == true){
            e.fishFinalImage = e.down1;
        }

    }

    public void setDisplay(int i){
        gp.ui.fishName = gp.iManage.inventory[i].name;
        gp.ui.fishPrice = gp.iManage.inventory[i].price+"";
        gp.ui.fishRarity = gp.iManage.inventory[i].fishRarity;
        gp.ui.fishImage = gp.iManage.inventory[i].down1;
        gp.ui.fishFrame = gp.iManage.inventory[i].fishFrame;

    }


}
