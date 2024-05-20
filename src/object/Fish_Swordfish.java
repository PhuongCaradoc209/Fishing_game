package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Swordfish extends Entity {
    public Fish_Swordfish(GamePanel gp){
        super(gp);
        fishRarity = "UNCOMMON";
        name = "Sword Fish";
        price = 12;
        fishStar = 3;
        down1 = setup("Fish/Swordfish_3",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Uncommon",gp.tileSize*18,gp.tileSize*15);
    }
}
