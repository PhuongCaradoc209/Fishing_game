package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_SHELF extends Entity {
    public OBJ_SHELF(GamePanel gp) {
        super(gp);
        name = "shelf";
        size = gp.tileSize;
        down1 = setup("interior/shelf", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
