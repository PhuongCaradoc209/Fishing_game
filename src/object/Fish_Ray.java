package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Ray extends Entity {
    public Fish_Ray(GamePanel gp){
        super(gp);
        fishRarity = "Common";
        name = "Ray";
        price = 11;
        fishStar = 3;
        down1 = setup("Fish/Ray_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Common");
    }
}
