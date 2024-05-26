package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Sunfish extends Entity {
    public Fish_Sunfish(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Sun Fish";
        price = 11;
        fishStar = 3;
        //Image for Collections
        down1 = setup("Fish/Sunfish_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Sunfish_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A deep, rough-scaled bodies fish\nwith a single continuous dorsal fin.\nIt is native to tropical and temperate\nwaters worldwide";
        desCollections = "A deep, rough-scaled bodies fish with a\nsingle continuous dorsal fin. It is native to\ntropical and temperate waters worldwide";
        desTrading = "A deep, rough-scaled bodies fish with a single\ncontinuous dorsal fin.It is native to tropical\nand temperate waters worldwide";


    }
}
