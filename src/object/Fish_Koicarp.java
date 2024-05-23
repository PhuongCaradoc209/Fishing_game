package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Koicarp extends Entity {
    public Fish_Koicarp(GamePanel gp){
        super(gp);
        fishRarity = "LEGENDARY";
        name = "Koi Carp";
        price = 13;
        fishStar = 2;
        //Image for Collections
        down1 = setup("Fish/Koicarp_2",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Koicarp_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Legendary",gp.tileSize*18,gp.tileSize*15);
    }
}
