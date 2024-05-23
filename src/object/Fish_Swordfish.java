package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Swordfish extends Entity {
    public Fish_Swordfish(GamePanel gp){
        super(gp);
        fishRarity = "UNCOMMON";
        name = "Sword Fish";
        price = 12;
        fishStar = 3;
        //Image for Collections
        down1 = setup("Fish/Swordfish_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Swordfish_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Uncommon",gp.tileSize*18,gp.tileSize*15);
        desFishing ="A long, flat, pointed bill fish and can\nbe found in tropical and temperate\nparts of the Atlantic, Pacific, and\nIndian Oceans";
        desCollections ="A long, flat, pointed bill fish and can\nbe found in tropical and temperate\nparts of the Atlantic, Pacific, and\nIndian Oceans";
        desTrading ="A long, flat, pointed bill fish and can be found in\ntropical and temperate parts of the Atlantic,\nPacific, and Indian Oceans";


    }
}
