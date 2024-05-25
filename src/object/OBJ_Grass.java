package object;

import entity.Entity;
import Main.GamePanel;

public class OBJ_Grass extends Entity{
        public OBJ_Grass(GamePanel gp){
            super(gp);
            name = "Grass";
            price = 2;
            count = 0;
            down1 = setup("Item/Grass",gp.tileSize,gp.tileSize);
            down2 = setup("Item/Grass",gp.tileSize,gp.tileSize);

        }


}
