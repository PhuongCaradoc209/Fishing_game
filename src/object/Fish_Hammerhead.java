package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Hammerhead extends Entity {
    public Fish_Hammerhead(GamePanel gp){
        super(gp);
        fishRarity = "Rare";
        name = "Big Head Carp";
        price = 13;
        fishStar = 3;
        down1 = setup("Fish/Hammerhead_3",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Rare");
    }
}
