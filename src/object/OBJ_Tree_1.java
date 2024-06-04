package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Tree_1 extends Entity {
    public OBJ_Tree_1(GamePanel gp) {
        super(gp);
        size = gp.tileSize * 3;
        name = "Tree";
        down1 = setup("objects/tree", 96, 96);
        collision = true;

        solidArea.x = gp.tileSize/2;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize + gp.tileSize/2 + 10;
        solidArea.height = gp.tileSize + gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}