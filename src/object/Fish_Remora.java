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
        //Image for Collections
        down1 = setup("Fish/Remora_2",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Remora_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
    }
}
