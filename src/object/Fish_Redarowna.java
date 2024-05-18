package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Redarowna extends Entity {
    public Fish_Redarowna(GamePanel gp){
        super(gp);
        fishRarity = "Uncommon";
        name = "Redarowna";
        price = 5;
        fishStar = 2;
        down1 = setup("Fish/Redarowna_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Uncommon");
    }
}
