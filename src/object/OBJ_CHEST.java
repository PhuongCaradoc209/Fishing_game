package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_CHEST extends Entity {
    public OBJ_CHEST(GamePanel gp) {
        super(gp);
        name = "chest";
        size = gp.tileSize;
        down1 = setup("interior/chest", gp.tileSize, gp.tileSize);
        collision = false;
    }
}
