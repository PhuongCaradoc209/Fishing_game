package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Clownfish extends Entity {
    public Fish_Clownfish(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Clown Fish";
        price = 7;
        fishStar = 1;
        down1 = setup("Fish/Clownfish_1",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Legendary",gp.tileSize*18,gp.tileSize*15);
    }
}
