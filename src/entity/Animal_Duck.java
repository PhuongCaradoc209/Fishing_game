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
        size = gp.tileSize;

//        solidArea.x = -5;
//        solidArea.y = 20;
//        solidArea.width = size;
//        solidArea.height = 28;
//        solidAreaDefaultX = solidArea.x;
//        solidAreaDefaultY = solidArea.y;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = size + 10;
        solidArea.height = size/2 + 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        down1 = setup("Animal/duck_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("Animal/duck_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("Animal/duck_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("Animal/duck_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("Animal/duck_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("Animal/duck_right_2", gp.tileSize, gp.tileSize);
        up1 = setup("Animal/duck_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("Animal/duck_up_2", gp.tileSize, gp.tileSize);
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