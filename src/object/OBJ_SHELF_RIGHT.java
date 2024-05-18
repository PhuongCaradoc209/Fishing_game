package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_SHELF_RIGHT extends Entity {
    public OBJ_SHELF_RIGHT(GamePanel gp) {
        super(gp);
        name = "shelf_right";
        size = gp.tileSize;
        down1 = setup("interior/shelf_right", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
