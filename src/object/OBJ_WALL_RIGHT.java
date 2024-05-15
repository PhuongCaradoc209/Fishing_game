package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_WALL_RIGHT extends Entity {
    public OBJ_WALL_RIGHT(GamePanel gp) {
        super(gp);
        size = gp.tileSize;
        name = "Wall right";
        down1 = setup("objects/Wall_right", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 28;
        solidArea.y = 0;
        solidArea.width = 35;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
