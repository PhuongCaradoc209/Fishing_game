package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Clownfish extends Entity {
    public Fish_Clownfish(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Clown Fish";
        price = 7;
        fishStar = 1;
        //Image for Collections
        down1 = setup("Fish/Clownfish_1",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Clownfish_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Legendary",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A small, colorful fish found in\ntropical oceans, known for its\nsymbiotic relationship with sea\nanemones";
        desCollections = "A small, colorful fish found in\ntropical oceans,known for its\nsymbiotic relationship with sea\nanemones";
        desTrading = "A small, colorful fish found in tropical oceans,\nknown for its symbiotic relationship with\nsea anemones";

    }
}
