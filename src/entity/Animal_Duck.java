package entity;

import Main.GamePanel;

import java.util.Random;

public class Animal_Duck extends Entity {
    public Animal_Duck(GamePanel gp) {
        super(gp);
        name = "Duck";
        direction = "down";
        speed = 0.5;
        getImage();
        size = gp.tileSize - 5;
    }

    public void getImage() {
        down1 = setup("NPC/duck_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("NPC/duck_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("NPC/duck_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("NPC/duck_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("NPC/duck_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("NPC/duck_right_2", gp.tileSize, gp.tileSize);
        up1 = setup("NPC/duck_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("NPC/duck_up_2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {
        actionLookCounter++;
        if (actionLookCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            } else if (i <= 50) {
                direction = "down";
            } else if (i <= 75) {
                direction = "right";
            } else {
                direction = "left";
            }
            actionLookCounter = 0;
        }
    }
}