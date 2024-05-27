package object;

import entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class Fish_Grasscarp extends Entity {
    public Fish_Grasscarp(GamePanel gp){
        super(gp);
        fishRarity = "UNCOMMON";
        name = "Grasscarp";
        price = 2;
        fishStar = 1;

        getImage(gp);
        size = gp.tileSize * 3;
        speed = 2;
        
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Uncommon",gp.tileSize*18,gp.tileSize*15);

        desFishing = "A large herbivorous with torpedo-\nshaped bodies and dark olive\ncoloration fish, native to the Pacific\nFar East";
        desCollections = "A large herbivorous with torpedo-shaped\nbodies and dark olive coloration fish,\nnative to the Pacific Far East";
        desTrading = "A large herbivorous with torpedo-shaped\nbodies and dark olive coloration fish, native\nto the Pacific Far East";

    }


    public void getImage(GamePanel gp) {
        //Image for Collections
        collection_image = setup("Fish/Grasscarp_1",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        tradeState_image = setup("Fish/Grasscarp_1",gp.tileSize,gp.tileSize);

        //Image for FishTank
        diagonal_down_left1 = setup("Animal/Fish_Grasscarp_left", 100, 100);
        diagonal_down_left2 = setup("Animal/Fish_Grasscarp_left_2", 100, 100);
        diagonal_down_right1 = setup("Animal/Fish_Grasscarp_right", 100, 100);
        diagonal_down_right2 = setup("Animal/Fish_Grasscarp_right_2", 100, 100);

        left1 = setup("Animal/Fish_Grasscarp_left", 100, 100);
        left2 = setup("Animal/Fish_Grasscarp_left_2", 100, 100);
        right1 = setup("Animal/Fish_Grasscarp_right", 100, 100);
        right2 = setup("Animal/Fish_Grasscarp_right_2", 100, 100);

        diagonal_up_left1 = setup("Animal/Fish_Grasscarp_left", 100, 100);
        diagonal_up_left2 = setup("Animal/Fish_Grasscarp_left_2", 100, 100);
        diagonal_up_right1 = setup("Animal/Fish_Grasscarp_right", 100, 100);
        diagonal_up_right2 = setup("Animal/Fish_Grasscarp_right_2", 100, 100);
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
