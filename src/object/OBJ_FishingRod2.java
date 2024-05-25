package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod2 extends Entity{
        public OBJ_FishingRod2(GamePanel gp){
            super(gp);
            caught = true;
            name = "FishingRod2";
            price = 15;
            count = 0;
            down1 = setup("Item/fishingrod2",gp.tileSize,gp.tileSize);
            down2 = setup("Item/fishingrod2",gp.tileSize,gp.tileSize);
        }


}
