package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_WALL_TOP extends Entity {
    public OBJ_WALL_TOP(GamePanel gp) {
        super(gp);
        size = gp.tileSize;
        name = "Wall top";
        down1 = setup("objects/Wall_top", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y =8;
        solidArea.width = 48;
        solidArea.height = 12;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
