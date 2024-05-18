package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Sunfish extends Entity {
    public Fish_Sunfish(GamePanel gp){
        super(gp);
        fishRarity = "Common";
        name = "Sun Fish";
        price = 11;
        fishStar = 3;
        down1 = setup("Fish/Sunfish_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Common");
    }
}
