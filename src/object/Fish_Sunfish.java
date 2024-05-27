package object;

import entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class Fish_Sunfish extends Entity {
    public Fish_Sunfish(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Sun Fish";
        price = 11;
        fishStar = 3;

        getImage(gp);
        size = gp.tileSize * 4 + gp.tileSize/2;
        speed = 0.5;
        
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A deep, rough-scaled bodies fish\nwith a single continuous dorsal fin.\nIt is native to tropical and temperate\nwaters worldwide";
        desCollections = "A deep, rough-scaled bodies fish with a\nsingle continuous dorsal fin. It is native to\ntropical and temperate waters worldwide";
        desTrading = "A deep, rough-scaled bodies fish with a single\ncontinuous dorsal fin.It is native to tropical\nand temperate waters worldwide";


    }


    public void getImage(GamePanel gp) {
        //Image for Collections
        collection_image = setup("Fish/Sunfish_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        tradeState_image = setup("Fish/Sunfish_3",gp.tileSize,gp.tileSize);

        //Image for FishTank
        diagonal_down_left1 = setup("Animal/Fish_Sunfish_left", 100, 100);
        diagonal_down_left2 = setup("Animal/Fish_Sunfish_left_2", 100, 100);
        diagonal_down_right1 = setup("Animal/Fish_Sunfish_right", 100, 100);
        diagonal_down_right2 = setup("Animal/Fish_Sunfish_right_2", 100, 100);

        left1 = setup("Animal/Fish_Sunfish_left", 100, 100);
        left2 = setup("Animal/Fish_Sunfish_left_2", 100, 100);
        right1 = setup("Animal/Fish_Sunfish_right", 100, 100);
        right2 = setup("Animal/Fish_Sunfish_right_2", 100, 100);

        diagonal_up_left1 = setup("Animal/Fish_Sunfish_left", 100, 100);
        diagonal_up_left2 = setup("Animal/Fish_Sunfish_left_2", 100, 100);
        diagonal_up_right1 = setup("Animal/Fish_Sunfish_right", 100, 100);
        diagonal_up_right2 = setup("Animal/Fish_Sunfish_right_2", 100, 100);
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
