package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Grasscarp extends Entity {
    public Fish_Grasscarp(GamePanel gp){
        super(gp);
        fishRarity = "UNCOMMON";
        name = "Grasscarp";
        price = 2;
        fishStar = 1;
        down1 = setup("Fish/Grasscarp_1",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Uncommon",gp.tileSize*18,gp.tileSize*15);
    }
}
