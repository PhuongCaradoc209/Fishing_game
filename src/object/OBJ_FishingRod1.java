package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod1 extends Entity{
        public OBJ_FishingRod1(GamePanel gp){
            super(gp);
            caught = true;
            name = "Fishing Rod 1";
            price = 5;
            count = 0;
            collection_image = setup("Item/fishingrod1",gp.tileSize,gp.tileSize);
            tradeState_image = setup("Item/fishingrod1",gp.tileSize,gp.tileSize);
            desTrading = "A long, thin, and flexible tool to catch level 1\nfishes";

        }


}
