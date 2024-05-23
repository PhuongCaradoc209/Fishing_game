package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Shark extends Entity {
    public Fish_Shark(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Shark";
        price = 19;
        fishStar = 3;
        //Image for Collections
        down1 = setup("Fish/Shark_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Shark_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame= setup("Fish/Shark_3",gp.tileSize*18,gp.tileSize*15);
    }
}
