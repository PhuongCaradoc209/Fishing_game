package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Bigheadcarp extends Entity {
    public Fish_Bigheadcarp(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Bighead Carp";
        price = 1;
        fishStar = 1;
        //Image for Collections
        down1 = setup("Fish/Bigheadcarp_1",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Bigheadcarp_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A large, deep-bodied fish native to\nEast Asia, known for their scaleless\nhead and filter-feeding behavior" ;
        desTrading = "A large, deep-bodied fish native to East Asia,\nknown for their scaleless head and\nfilter-feeding behavior" ;
        desCollections = "A large, deep-bodied fish native to East\nAsia, known for their scaleless head\nand filter-feeding behavior";
    }


}
