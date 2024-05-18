package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_SOFA_BOTTOM extends Entity {
    public OBJ_SOFA_BOTTOM(GamePanel gp) {
        super(gp);
        name = "sofa_2";
        size = gp.tileSize;
        down1 = setup("interior/sofa_2", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
