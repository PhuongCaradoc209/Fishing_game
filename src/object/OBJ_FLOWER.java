package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_FLOWER extends Entity {
    public OBJ_FLOWER(GamePanel gp) {
        super(gp);
        name = "flower";
        size = gp.tileSize;
        down1 = setup("interior/flower", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
