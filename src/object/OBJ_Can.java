package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Can extends Entity {
    public OBJ_Can(GamePanel gp){
        super(gp);
        name = "Can";
        price = 0;
        fishStar = 0;
        collection_image = setup("Item/Can",gp.tileSize*5/2,gp.tileSize*5/2);
        tradeState_image = setup("Item/Can",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishRarity = "TRASH";
        fishFrame= setup("Fishingframe/Trash",gp.tileSize*18,gp.tileSize*15);
        desFishing ="A container made of thin metal,\ntypically steel or aluminum, used\nfor storing various goods";
        desTrading ="A container made of thin metal, typically steel\nor aluminum, used for storing various goods";


    }
}
