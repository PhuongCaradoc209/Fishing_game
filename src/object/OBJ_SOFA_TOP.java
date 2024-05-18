package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_SOFA_TOP extends Entity {
    public OBJ_SOFA_TOP(GamePanel gp) {
        super(gp);
        name = "sofa_1";
        size = gp.tileSize;
        down1 = setup("interior/sofa_1", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
