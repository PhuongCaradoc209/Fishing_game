package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Silvercarp extends Entity {
    public Fish_Silvercarp(GamePanel gp){
        super(gp);
        fishRarity = "Rare";
        name = "Silvercarp";
        price = 2;
        fishStar = 1;
        down1 = setup("Fish/Silvercarp_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Rare");
    }
}
