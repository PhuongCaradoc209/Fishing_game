package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Milk extends Entity {
    public OBJ_Milk(GamePanel gp){
        super(gp);
        caught = true;
        name = "Milk";
        price = 1;
        count = 0;
        collection_image = setup("Item/Milk",gp.tileSize,gp.tileSize);
        tradeState_image = setup("Item/Milk",gp.tileSize,gp.tileSize);
        desTrading ="Cow's milk, using to recover your energy";
    }
}
