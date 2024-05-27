package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod2 extends Entity{
        public OBJ_FishingRod2(GamePanel gp){
            super(gp);
            caught = true;
            name = "Fishing Rod 2";
            price = 15;
            count = 0;
            collection_image = setup("Item/fishingrod2",gp.tileSize,gp.tileSize);
            tradeState_image = setup("Item/fishingrod2",gp.tileSize,gp.tileSize);
            desTrading = "A long, thin, and flexible tool to catch level 2\nfishes";

        }


}
