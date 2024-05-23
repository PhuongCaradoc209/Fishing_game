package object;

import entity.Entity;
import Main.GamePanel;

public class Fish_Redarowna extends Entity {
    public Fish_Redarowna(GamePanel gp){
        super(gp);
        fishRarity = "UNCOMMON";
        name = "Red Arowana";
        price = 5;
        fishStar = 2;
        //Image for Collections
        down1 = setup("Fish/Redarowna_2",gp.tileSize*5/2,gp.tileSize*5/2);
        //Image for tradeState
        down2 = setup("Fish/Redarowna_2",gp.tileSize,gp.tileSize);
        count = 0;
        fishFinalImage = setup("Item/Qm",gp.tileSize,gp.tileSize);
        fishFrame = setup("Fishingframe/Uncommon",gp.tileSize*18,gp.tileSize*15);
        desFishing="A type of freshwater fish known\nfor its vibrant red coloration and\nsleek, elongated body";
        desCollections="A type of freshwater fish known for\nits vibrant red coloration and sleek,\nelongated body";
        desTrading="A type of freshwater fish known for its\nvibrant red coloration and sleek, elongated\nbody";

    }
}
