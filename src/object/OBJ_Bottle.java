package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Bottle extends Entity {
    public OBJ_Bottle(GamePanel gp){
        super(gp);
        name = "Bottle";
        price = 0;
        fishStar = 0;
        down1 = setup("Item/Bottle",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
    }
}
