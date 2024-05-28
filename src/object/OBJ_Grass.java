package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Grass extends Entity{
        public OBJ_Grass(GamePanel gp){
            super(gp);
            name = "Grass";
            price = 2;
            count = 0;
            tradeCount = 0;
            collection_image = setup("Item/Grass",gp.tileSize,gp.tileSize);
            tradeState_image = setup("Item/Grass",gp.tileSize,gp.tileSize);
            desTrading ="Grass is a type of plant characterized by\nnarrow leaves, using to feed cows";
        }
}