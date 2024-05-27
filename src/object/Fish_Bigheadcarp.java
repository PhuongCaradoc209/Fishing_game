package object;

import entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class Fish_Bigheadcarp extends Entity {
    public Fish_Bigheadcarp(GamePanel gp) {
        super(gp);
        fishRarity = "COMMON";
        name = "Bighead Carp";
        price = 1;
        fishStar = 1;

        getImage(gp);
        size = gp.tileSize * 3;
        speed = 2;

        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A large, deep-bodied fish native to\nEast Asia, known for their scaleless\nhead and filter-feeding behavior" ;
        desTrading = "A large, deep-bodied fish native to East Asia,\nknown for their scaleless head and\nfilter-feeding behavior" ;
        desCollections = "A large, deep-bodied fish native to East\nAsia, known for their scaleless head\nand filter-feeding behavior";
    }

    public void getImage(GamePanel gp) {
        //Image for Collections
        collection_image = setup("Fish/Bigheadcarp_1", gp.tileSize * 5 / 2, gp.tileSize * 5 / 2);
        //Image for tradeState
        tradeState_image = setup("Fish/Bigheadcarp_1", gp.tileSize, gp.tileSize);

        //Image for FishTank
        diagonal_down_left1 = setup("Animal/Fish_Bigheadcarp_left", 100, 100);
        diagonal_down_left2 = setup("Animal/Fish_Bigheadcarp_left_2", 100, 100);
        diagonal_down_right1 = setup("Animal/Fish_Bigheadcarp_right", 100, 100);
        diagonal_down_right2 = setup("Animal/Fish_Bigheadcarp_right_2", 100, 100);

        left1 = setup("Animal/Fish_Bigheadcarp_left", 100, 100);
        left2 = setup("Animal/Fish_Bigheadcarp_left_2", 100, 100);
        right1 = setup("Animal/Fish_Bigheadcarp_right", 100, 100);
        right2 = setup("Animal/Fish_Bigheadcarp_right_2", 100, 100);

        diagonal_up_left1 = setup("Animal/Fish_Bigheadcarp_left", 100, 100);
        diagonal_up_left2 = setup("Animal/Fish_Bigheadcarp_left_2", 100, 100);
        diagonal_up_right1 = setup("Animal/Fish_Bigheadcarp_right", 100, 100);
        diagonal_up_right2 = setup("Animal/Fish_Bigheadcarp_right_2", 100, 100);
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
