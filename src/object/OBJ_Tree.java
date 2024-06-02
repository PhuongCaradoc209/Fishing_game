package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Tree extends Entity {
    public OBJ_Tree(GamePanel gp) {
        super(gp);
        size = gp.tileSize * 3;
        name = "Tree";
        down1 = setup("objects/tree", 96, 96);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 43;
        solidArea.width = 48;
        solidArea.height = 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}