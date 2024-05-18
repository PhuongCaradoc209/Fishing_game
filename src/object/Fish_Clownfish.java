package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Clownfish extends Entity {
    public Fish_Clownfish(GamePanel gp){
        super(gp);
        fishRarity = "Legendary";
        name = "Clown Fish";
        price = 7;
        fishStar = 1;
        down1 = setup("Fish/Clownfish_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Legendary");
    }
}
