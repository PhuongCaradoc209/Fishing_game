package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Herring extends Entity {
    public Fish_Herring(GamePanel gp){
        super(gp);
        fishRarity = "Common";
        name = "Herring";
        price = 1;
        fishStar = 1;
        down1 = setup("Fish/Herring_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Common");
    }


}
