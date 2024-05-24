package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Ray extends Entity {
    public Fish_Ray(GamePanel gp){
        super(gp);
        fishRarity = "COMMON";
        name = "Ray";
        price = 11;
        fishStar = 3;
        //Image for Collections
        down1 = setup("Fish/Ray_3",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Ray_3",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Common",gp.tileSize*18,gp.tileSize*15);
        desFishing = "A cartilaginous fish with flattened\nbodies, enlarged pectoral fins fused\nwith the head, and venomous spines" ;
        desCollections = "A cartilaginous fish with\nflattened bodies, enlarged pectoral\nfins fused with the head, and\nvenomous spines" ;
        desTrading = "A cartilaginous fish with flattened bodies,\nenlarged pectoral fins fused with the head,\nand venomous spines" ;


    }
}
