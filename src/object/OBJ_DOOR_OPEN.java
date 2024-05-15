package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_DOOR_OPEN extends Entity {
    public OBJ_DOOR_OPEN(GamePanel gp) {
        super(gp);
        name = "Door open";
        size = gp.tileSize;
        down1 = setup("objects/door_open", gp.tileSize, gp.tileSize);
        collision = false;
    }
}