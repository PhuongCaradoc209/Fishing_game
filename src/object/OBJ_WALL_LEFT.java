package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_WALL_LEFT extends Entity {
    public OBJ_WALL_LEFT(GamePanel gp) {
        super(gp);
        size = gp.tileSize;
        name = "Wall left";
        down1 = setup("objects/Wall_left", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = -10;
        solidArea.y = 0;
        solidArea.width = 30;
        solidArea.height = 58;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
