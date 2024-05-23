package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Herring extends Entity {
    public Fish_Herring(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Herring";
        price = 1;
        fishStar = 1;
        //Image for Collections
        down1 = setup("Fish/Herring_1",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Herring_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A small-headed, streamlined fish,\nfound primarily in temperate waters\nof the North Pacific and North\nAtlantic Oceans";
        desCollections = "A small-headed, streamlined fish,\nfound primarily in temperate waters\nof the North Pacific and North\nAtlantic Oceans";
        desTrading = "A small-headed, streamlined fish, found\nprimarily in temperate waters of the North\nPacific and North Atlantic Oceans";

    }


}
