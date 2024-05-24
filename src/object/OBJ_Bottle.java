package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Bottle extends Entity {
    public OBJ_Bottle(GamePanel gp){
        super(gp);
        name = "Bottle";
        price = 0;
        fishStar = 0;
        down1 = setup("Item/Bottle",gp.tileSize*5/2,gp.tileSize*5/2);
        down2 = setup("Item/Bottle",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishRarity = "TRASH";
        fishFrame = setup("Fishingframe/Trash",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A narrow-necked container typically\nmade of glass, plastic, or aluminum\nthat is used to store and transport\nliquids";
        desTrading = "A narrow-necked container typically made of\nglass, plastic, or aluminum that is used to\nstore and transport liquids";

    }
}
