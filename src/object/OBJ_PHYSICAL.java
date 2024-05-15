package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_PHYSICAL extends Entity {
    GamePanel gp;

    public OBJ_PHYSICAL(GamePanel gp) {
        super(gp);
        name = "Physical";

        image = setup("objects/0", gp.tileSize, gp.tileSize);
        image2 = setup("objects/0.5", gp.tileSize, gp.tileSize);
        image3 = setup("objects/1", gp.tileSize, gp.tileSize);
        image4 = setup("objects/1.5", gp.tileSize, gp.tileSize);
        image5 = setup("objects/2", gp.tileSize, gp.tileSize);

        collision = false;
    }
}
