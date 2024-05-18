package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Pomfret extends Entity {
    public Fish_Pomfret(GamePanel gp){
        super(gp);
        fishRarity = "Rare";
        name = "Pomfret";
        price = 7;
        fishStar = 2;
        down1 = setup("Fish/Pomfret_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Rare");
    }
}
