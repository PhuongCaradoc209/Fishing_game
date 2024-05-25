package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Grass extends Entity{
        public OBJ_Grass(GamePanel gp){
            super(gp);
            caught = true;
            name = "Grass";
            price = 0;
            count = 0;
            collection_image = setup("Item/Grass",gp.tileSize,gp.tileSize);
            fishRarity = "";
        }
}
