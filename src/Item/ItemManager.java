package Item;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


public class ItemManager {
    public Item[] item ;
    GamePanel gp;

    public BufferedImage qm,legendaryFrame,rareFrame,uncommonFrame,commonFrame,starFill,starZero;
    public ItemManager(GamePanel gp){
        this.gp = gp;
        item = new Item[24];
        getitemInformation();
    }

    public void getitemInformation(){
        try {

            item[0] = new Item();
            item[0].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Bigheadcarp_1.png"));
            item[0].rarity = "Common";
            item[0].fishName = "Big Head Carp";
            item[0].price = 1;
            item[0].star = 1;

            item[2] = new Item();
            item[2].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Grasscarp_1.png"));
            item[2].rarity = "Uncommon";
            item[2].fishName = "Grass Carp";
            item[2].price = 2;
            item[2].star = 1;

            item[3] = new Item();
            item[3].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Silvercarp_1.png"));
            item[3].rarity = "Rare";
            item[3].fishName = "Silver Carp";
            item[3].price = 3;
            item[3].star = 1;

            item[4] = new Item();
            item[4].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Clownfish_1.png"));
            item[4].rarity = "Legendary";
            item[4].fishName = "Clown Fish";
            item[4].price = 7;
            item[4].star = 1;

            item[5] = new Item();
            item[5].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Remora_2.png"));
            item[5].rarity = "Common";
            item[5].fishName = "Remora";
            item[5].price = 5;
            item[5].star = 2;

            item[6] = new Item();
            item[6].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Coelacanths_2.png"));
            item[6].rarity = "Common";
            item[6].fishName = "Coelacanths";
            item[6].price = 5;
            item[6].star = 2;

            item[7] = new Item();
            item[7].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Redarowna_2.png"));
            item[7].rarity = "Uncommon";
            item[7].fishName = "Redarowna";
            item[7].price = 6;
            item[7].star = 2;

            item[8] = new Item();
            item[8].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Pomfret_2.png"));
            item[8].rarity = "Rare";
            item[8].fishName = "Pomfret";
            item[8].price = 7;
            item[8].star = 2;

            item[9] = new Item();
            item[9].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Koicarp_2.png"));
            item[9].rarity = "Legendary";
            item[9].fishName = "Koi Carp";
            item[9].price = 13;
            item[9].star = 2;

            item[10] = new Item();
            item[10].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Sunfish_3.png"));
            item[10].rarity = "Common";
            item[10].fishName = "Sun Fish";
            item[10].price = 11;
            item[10].star = 3;

            item[11] = new Item();
            item[11].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Ray_3.png"));
            item[11].rarity = "Common";
            item[11].fishName = "Ray";
            item[11].price = 11;
            item[11].star = 3;

            item[12] = new Item();
            item[12].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Swordfish_3.png"));
            item[12].rarity = "Uncommon";
            item[12].fishName = "Sword Fish";
            item[12].price = 12;
            item[12].star = 3;

            item[13] = new Item();
            item[13].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Hammerhead_3.png"));
            item[13].rarity = "Rare";
            item[13].fishName = "Hammer Head";
            item[13].price = 13;
            item[13].star = 3;

            item[14] = new Item();
            item[13].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Fish/Shark_3.png"));
            item[13].rarity = "Legendary";
            item[14].fishName = "Shark";
            item[14].price = 19;
            item[14].star = 3;

            item[15] = new Item();
            item[15].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Item/Trash1.png"));
            item[15].rarity = "";
            item[15].fishName = "Can";
            item[15].price = 0;
            item[15].star = 0;

            item[16] = new Item();
            item[16].imageOfFish = ImageIO.read(getClass().getResourceAsStream("/Item/Trash2.png"));
            item[16].rarity = "";
            item[16].fishName = "Bottle";
            item[16].price = 0;
            item[16].star = 0;

            qm = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Item/Qm.png")));
            legendaryFrame = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Fishingframe/Legendary.png")));
            rareFrame = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Fishingframe/Rare.png")));
            uncommonFrame = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Fishingframe/Uncommon.png")));
            commonFrame = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Fishingframe/Common.png")));
            starFill = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Item/Starfill.png")));
            starZero = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Item/Starzero.png")));



        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public void Fishing(int rod) {
            Random rd = new Random();
            Item item = new Item();
            switch (rod) {
                case 1:
                    int value = rd.nextInt(100) + 1;
                    //int value = 100;
                    if (value >= 1 && value <= 35) {
                        item = gp.itemManager.item[0];
                        gp.itemManager.item[0].caught = true;
                        gp.itemManager.item[0].count++;
                    } else if (value >= 36 && value <= 70) {
                        item = gp.itemManager.item[1];
                        gp.itemManager.item[1].caught = true;
                        gp.itemManager.item[1].count++;
                    } else if (value >= 70 && value <= 75) {
                        item = gp.itemManager.item[15];
                        gp.itemManager.item[15].caught = true;
                        gp.itemManager.item[15].count++;
                    } else if (value >= 76 && value <= 80) {
                        item = gp.itemManager.item[16];
                        gp.itemManager.item[16].caught = true;
                        gp.itemManager.item[16].count++;
                    } else if (value >= 81 && value <= 92) {
                        item = gp.itemManager.item[2];
                        gp.itemManager.item[2].caught = true;
                        gp.itemManager.item[2].count++;
                    } else if (value >= 93 && value <= 99) {
                        item = gp.itemManager.item[3];
                        gp.itemManager.item[3].caught = true;
                        gp.itemManager.item[3].count++;
                    } else if (value == 100) {
                        item = gp.itemManager.item[4];
                        gp.itemManager.item[4].caught = true;
                        gp.itemManager.item[4].count++;
                    }
                    gp.gameState = gp.fishingState;
                    setItem(item);
                    break;
                case 2:
                      value = rd.nextInt(1000) + 1;
                   // value = 969;
                    if (value >= 1 && value <= 16) {
                        item = gp.itemManager.item[0];
                        gp.itemManager.item[0].caught = true;
                        gp.itemManager.item[0].count++;
                    } else if (value >= 17 && value <= 32) {
                        item = gp.itemManager.item[1];
                        gp.itemManager.item[1].caught = true;
                        gp.itemManager.item[1].count++;
                    } else if (value >= 33 && value <= 72) {
                        item = gp.itemManager.item[15];
                        gp.itemManager.item[15].caught = true;
                        gp.itemManager.item[15].count++;
                    } else if (value >= 73 && value <= 112) {
                        item = gp.itemManager.item[16];
                        gp.itemManager.item[16].caught = true;
                        gp.itemManager.item[16].count++;
                    } else if (value >= 113 && value <= 144) {
                        item = gp.itemManager.item[2];
                        gp.itemManager.item[2].caught = true;
                        gp.itemManager.item[2].count++;
                    } else if (value >= 145 && value <= 180) {
                        item = gp.itemManager.item[3];
                        gp.itemManager.item[3].caught = true;
                        gp.itemManager.item[3].count++;
                    } else if (value >= 181 && value <= 200) {
                        item = gp.itemManager.item[4];
                        gp.itemManager.item[4].caught = true;
                        gp.itemManager.item[4].count++;
                    } else if (value >= 201 && value <= 520) {
                        item = gp.itemManager.item[5];
                        gp.itemManager.item[5].caught = true;
                        gp.itemManager.item[5].count++;
                    } else if (value >= 521 && value <= 840) {
                        item = gp.itemManager.item[6];
                        gp.itemManager.item[6].caught = true;
                        gp.itemManager.item[6].count++;
                    } else if (value >= 841 && value <= 920) {
                        item = gp.itemManager.item[7];
                        gp.itemManager.item[7].caught = true;
                        gp.itemManager.item[7].count++;
                    } else if (value >= 921 && value <= 970) {
                        item = gp.itemManager.item[8];
                        gp.itemManager.item[8].caught = true;
                        gp.itemManager.item[8].count++;
                    } else if (value >= 971 && value <= 1000) {
                        item = gp.itemManager.item[9];
                        gp.itemManager.item[9].caught = true;
                        gp.itemManager.item[9].count++;
                    }

                    gp.gameState = gp.fishingState;
                    setItem(item);
                    break;

                case 3:
                    break;
            }
        }

    public void setImage(Item i){
        if(i.caught == true){
            i.finalImage = i.imageOfFish;
        }
        else{
            i.finalImage = qm;
        }

    }

    public void setItem(Item item){
        gp.ui.text1 =  item.fishName;
        gp.ui.text2 = item.price + "";
        gp.ui.text3 =  item.rarity;
        gp.ui.imageOfFish =  item.imageOfFish;

        if(item.rarity.equals("Legendary")){
            item.fishingFrame = legendaryFrame;
        }
        else if(item.rarity.equals("Rare")){
            item.fishingFrame = rareFrame;
        }
        if(item.rarity.equals("Uncommon")){
            item.fishingFrame = uncommonFrame;
        }
        if(item.rarity.equals("Common")){
            item.fishingFrame = commonFrame;
        }
        gp.ui.fishingFrame =  item.fishingFrame;

        gp.ui.star = item.star;


    }

}
