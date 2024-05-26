package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Hammerhead extends Entity {
    public Fish_Hammerhead(GamePanel gp){
        super(gp);
        fishRarity = "RARE";
        name = "Hammer Head";
        price = 13;
        fishStar = 3;
        //Image for Collections
        down1 = setup("Fish/Hammerhead_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Hammerhead_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Rare",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A unique species known for its\ndistinctive hammer-shaped head and\nfound in warm waters worldwide";
        desCollections = "A unique species known for its distinctive\nhammer-shaped head and found in warm\nwaters worldwide";
        desTrading = "A unique species known for its distinctive\nhammer-shaped head and found in warm\nwaters worldwide";

    }
}
