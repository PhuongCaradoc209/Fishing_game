package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_WALL_BOT extends Entity {
    public OBJ_WALL_BOT(GamePanel gp) {
        super(gp);
        size = gp.tileSize;
        name = "Wall bottom";
        down1 = setup("objects/Wall_bot", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 43;
        solidArea.width = 48;
        solidArea.height = 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}