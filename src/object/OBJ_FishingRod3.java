package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FishingRod3 extends Entity{
        public OBJ_FishingRod3(GamePanel gp){
            super(gp);
            caught = true;
            name = "Fishing Rod 3";
            price = 30;
            count = 0;
            rod = 3;
            collection_image = setup("Item/fishingrod3",gp.tileSize,gp.tileSize);
            tradeState_image = setup("Item/fishingrod3",gp.tileSize,gp.tileSize);
            desTrading = "A long, thin, and flexible tool to catch level 3\nfishes";
        }
}
