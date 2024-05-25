package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod1 extends Entity{
        public OBJ_FishingRod1(GamePanel gp){
            super(gp);
            caught = true;
            name = "FishingRod1";
            price = 5;
            count = 0;
            down1 = setup("Item/fishingrod1",gp.tileSize,gp.tileSize);
            down2 = setup("Item/fishingrod1",gp.tileSize,gp.tileSize);
        }


}
