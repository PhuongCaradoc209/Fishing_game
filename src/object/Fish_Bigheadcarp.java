package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Bigheadcarp extends Entity {
    public Fish_Bigheadcarp(GamePanel gp){
        super(gp);
        fishRarity = "Common";
        name = "Big Head Carp";
        price = 1;
        fishStar = 1;
        down1 = setup("Fish/Bigheadcarp_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("/Fishingframe/Common");
    }


}
