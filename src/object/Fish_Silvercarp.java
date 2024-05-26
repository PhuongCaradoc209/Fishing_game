package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Silvercarp extends Entity {
    public Fish_Silvercarp(GamePanel gp){
        super(gp);
        fishRarity = "RARE";
        name = "Silvercarp";
        price = 2;
        fishStar = 1;
        //Image for Collections
        down1 = setup("Fish/Silvercarp_1",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Silvercarp_1",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Rare",gp.tileSize*18,gp.tileSize*15);

        desFishing = "A deep, laterally compressed bodies\nwith large, toothless mouths and\nupturned lower jaws";
        desCollections = "A deep, laterally compressed bodies\nwith large, toothless mouths and\nupturned lower jaws";
        desTrading = "A deep, laterally compressed bodies with\nlarge, toothless mouths and upturned lower\njaws";

    }
}
