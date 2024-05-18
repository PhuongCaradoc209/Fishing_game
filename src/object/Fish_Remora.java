package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Remora extends Entity {
    public Fish_Remora(GamePanel gp){
        super(gp);
        fishRarity = "Common";
        name = "Remora";
        price = 5;
        fishStar = 2;
        down1 = setup("Fish/Remora_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
//        fishFrame = setup("Fishingframe/Common");
    }
}
