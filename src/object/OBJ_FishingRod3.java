package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod3 extends Entity{
        public OBJ_FishingRod3(GamePanel gp){
            super(gp);
            caught = true;
            name = "FishingRod3";
            price = 30;
            count = 0;
            down1 = setup("Item/fishingrod3",gp.tileSize,gp.tileSize);
            down2 = setup("Item/fishingrod3",gp.tileSize,gp.tileSize);
            desTrading = "[Fishing Rod  LV3]";
        }


}
