package object;

import entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class Fish_Koicarp extends Entity {
    public Fish_Koicarp(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Koi Carp";
        price = 13;
        fishStar = 2;

        getImage(gp);
        size = gp.tileSize * 3;
        speed = 2;

        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Legendary",gp.tileSize*18,gp.tileSize*15);
        desFishing = "Known as nishikigoi, these fishes\nare colorful varieties, originating\nfrom Japan";
        desCollections = "Known as nishikigoi, these fishes are\ncolorful varieties, originating from Japan";
        desTrading = "Known as nishikigoi, these fishes are\ncolorful varieties, originating from Japan";

    }


    public void getImage(GamePanel gp) {
        //Image for Collections
        collection_image = setup("Fish/Koicarp_2",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        tradeState_image = setup("Fish/Koicarp_2",gp.tileSize,gp.tileSize);

        //Image for FishTank
        diagonal_down_left1 = setup("Animal/Fish_Koicarp_left", 100, 100);
        diagonal_down_left2 = setup("Animal/Fish_Koicarp_left_2", 100, 100);
        diagonal_down_right1 = setup("Animal/Fish_Koicarp_right", 100, 100);
        diagonal_down_right2 = setup("Animal/Fish_Koicarp_right_2", 100, 100);

        left1 = setup("Animal/Fish_Koicarp_left", 100, 100);
        left2 = setup("Animal/Fish_Koicarp_left_2", 100, 100);
        right1 = setup("Animal/Fish_Koicarp_right", 100, 100);
        right2 = setup("Animal/Fish_Koicarp_right_2", 100, 100);

        diagonal_up_left1 = setup("Animal/Fish_Koicarp_left", 100, 100);
        diagonal_up_left2 = setup("Animal/Fish_Koicarp_left_2", 100, 100);
        diagonal_up_right1 = setup("Animal/Fish_Koicarp_right", 100, 100);
        diagonal_up_right2 = setup("Animal/Fish_Koicarp_right_2", 100, 100);
    }

    public void setAction() {
        actionLookCounter++;
        if (actionLookCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(150) + 1;
            if (i <= 25) {
                direction = "diagonalDownLeft";
            } else if (i <= 50) {
                direction = "diagonalDownRight";
            } else if (i <= 75) {
                direction = "right";
            } else if (i <= 100) {
                direction = "left";
            } else if (i <= 125) {
                direction = "diagonalUpLeft";
            } else {
                direction = "diagonalUpRight";
            }
            actionLookCounter = 0;
        }
    }
}
