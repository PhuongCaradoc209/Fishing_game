package object;

import entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class Fish_Shark extends Entity {
    public Fish_Shark(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Shark";
        price = 19;
        fishStar = 3;

        getImage(gp);
        size = gp.tileSize * 3;
        speed = 2;

        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame= setup("Fishingframe/Legendary",gp.tileSize*18,gp.tileSize*15);
        desFishing ="A cold-blooded fish have fins, breath\nwith gills and inhabit various\nenvironments worldwide, from\nfreshwater lakes to polar seas.";
        desCollections ="A cold-blooded fish have fins, breath with\ngills and inhabit various environments\nworldwide, from freshwater lakes to\npolar seas.";
        desTrading ="A cold-blooded fish have fins, breath with gills\nand inhabit various environments worldwide,\nfrom freshwater lakes to polar seas.";

    }


    public void getImage(GamePanel gp) {
        //Image for Collections
        collection_image = setup("Fish/Shark_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        tradeState_image = setup("Fish/Shark_3",gp.tileSize,gp.tileSize);

        //Image for FishTank
        diagonal_down_left1 = setup("Animal/Fish_Shark_left", 100, 100);
        diagonal_down_left2 = setup("Animal/Fish_Shark_left_2", 100, 100);
        diagonal_down_right1 = setup("Animal/Fish_Shark_right", 100, 100);
        diagonal_down_right2 = setup("Animal/Fish_Shark_right_2", 100, 100);

        left1 = setup("Animal/Fish_Shark_left", 100, 100);
        left2 = setup("Animal/Fish_Shark_left_2", 100, 100);
        right1 = setup("Animal/Fish_Shark_right", 100, 100);
        right2 = setup("Animal/Fish_Shark_right_2", 100, 100);

        diagonal_up_left1 = setup("Animal/Fish_Shark_left", 100, 100);
        diagonal_up_left2 = setup("Animal/Fish_Shark_left_2", 100, 100);
        diagonal_up_right1 = setup("Animal/Fish_Shark_right", 100, 100);
        diagonal_up_right2 = setup("Animal/Fish_Shark_right_2", 100, 100);
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
