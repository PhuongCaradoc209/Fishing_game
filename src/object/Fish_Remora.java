package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Remora extends Entity {
    public Fish_Remora(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Remora";
        price = 5;
        fishStar = 2;
        down1 = setup("Fish/Remora_2",gp.tileSize*5/2,gp.tileSize*5/2);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
    }
}
