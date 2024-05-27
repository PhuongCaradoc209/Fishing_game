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
                if ( value <= 35) {
                    num = 0;

                } else if ( value <= 70) {
                    num = 1;

                } else if (value <= 75) {
                    num = 15;

                } else if ( value <= 80) {
                    num = 16;

                } else if (value <= 92) {
                    num = 2;

                } else if (value <= 99) {
                    num = 3;

                } else  {
                    num = 4;
                }
                setCollectionAndDisplay(num);
                gp.gameState = gp.fishingState;
                break;
            case 2:
                value = rd.nextInt(1000) + 1;
                if ( value <= 16) {
                    num = 0;

                } else if (value <= 32) {
                    num = 1;

                } else if (value <= 72) {
                    num = 15;

                } else if (value <= 112) {
                    num = 16;

                } else if ( value <= 144) {
                    num = 2;

                } else if (value <= 180) {
                    num = 3;

                } else if (value <= 200) {
                    num = 4;

                } else if (value <= 520) {
                    num = 5;

                } else if (value <= 840) {
                    num = 6;

                } else if (value <= 920) {
                    num = 7;

                } else if (value <= 970) {
                    num = 8;

                } else {
                    num = 9;
                }
                setCollectionAndDisplay(num);
                gp.gameState = gp.fishingState;
                break;

            case 3:
                value = rd.nextInt(1000) + 1;
                if ( value <= 9) {
                    num = 0;

                } else if (value <= 18) {
                    num = 1;

                } else if (value <= 58) {
                    num = 15;

                } else if (value <= 98) {
                    num = 16;

                } else if ( value <= 123) {
                    num = 2;

                } else if (value <= 150) {
                    num = 3;

                } else if (value <= 180) {
                    num = 4;

                } else if (value <= 196) {
                    num = 5;

                } else if (value <= 212) {
                    num = 6;

                } else if (value <= 244) {
                    num = 7;

                } else if (value <= 280) {
                    num = 8;

                } else if( value <= 310){
                    num = 9;

                }
                else if( value <= 590){
                    num = 10;

                }
                else if( value <= 870){
                    num = 11;

                }
                else if( value <= 940){
                    num = 12;

                }
                else if( value <= 980){
                    num = 13;

                }else {
                    num = 14;

                }
                setCollectionAndDisplay(num);
                gp.gameState = gp.fishingState;
                break;
        }
        //Adding fish to inventory
        gp.player.canObtainItem(gp.iManage.inventory[num]);
    }
    public void setImage(Entity e){
        if(e.caught == true){
            e.fishFinalImage = e.collection_image;
        }
    }

    public void setCollectionAndDisplay(int i){
        gp.iManage.inventory[i].count ++;
        gp.iManage.inventory[i].caught = true;
        gp.ui.fishName = gp.iManage.inventory[i].name;
        gp.ui.fishPrice = gp.iManage.inventory[i].price+"";
        gp.ui.fishRarity = gp.iManage.inventory[i].fishRarity;
        gp.ui.fishImage = gp.iManage.inventory[i].down1;
        gp.ui.fishFrame = gp.iManage.inventory[i].fishFrame;
        gp.ui.desFishing = gp.iManage.inventory[i].desFishing;
        statistic(i);
    }

    public void statistic(int i){
            gp.ui.total ++;
            if(i == 4 || i == 9 || i == 14){
                gp.ui.legendaryFish ++;
            }
            else if(i == 3 || i == 8 || i == 13){
                gp.ui.rareFish ++;
            }
            else if(i == 2 || i == 7 || i == 12){
                gp.ui.uncommonFish ++;
            }
            else if(i == 15 || i == 16){
                gp.ui.total --;
            }
            else{
                gp.ui.commonFish ++;
            }
    }
}
