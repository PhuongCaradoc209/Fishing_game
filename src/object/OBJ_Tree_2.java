package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Tree_2 extends Entity {
    public OBJ_Tree_2(GamePanel gp) {
        super(gp);
        size = gp.tileSize * 3;
        name = "Tree";
        down1 = setup("objects/tree1", 96, 96);
        collision = true;

        solidArea.x = gp.tileSize/2 - 20;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize + gp.tileSize/2 + 40;
        solidArea.height = gp.tileSize + gp.tileSize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}