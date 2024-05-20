package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Bigheadcarp extends Entity {
    public Fish_Bigheadcarp(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Big Head Carp";
        price = 1;
        fishStar = 1;
        down1 = setup("Fish/Bigheadcarp_1",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
    }


}
