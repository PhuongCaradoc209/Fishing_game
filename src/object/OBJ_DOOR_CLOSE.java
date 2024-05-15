package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_DOOR_CLOSE extends Entity {
    public OBJ_DOOR_CLOSE(GamePanel gp) {
        super(gp);
        size = gp.tileSize;
        name = "Door close";
        down1 = setup("objects/door_close", gp.tileSize, gp.tileSize);
        collision = false;
    }
}