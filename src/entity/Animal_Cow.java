package entity;

import Main.GamePanel;

import java.util.Random;

public class Animal_Cow extends Entity{
    public Animal_Cow(GamePanel gp) {
        super(gp);
        name = "Cow";
        speed = 0;
        getImage();
        direction = "down";
        size = gp.tileSize * 2;
        solidArea.x = 5;
        solidArea.y = 5;
        solidArea.width = size - 30;
        solidArea.height = size - 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        down1 = setup("NPC/cow_down1", gp.tileSize, gp.tileSize);
        down2 = setup("NPC/cow_down2", gp.tileSize, gp.tileSize);
        left1 = setup("NPC/cow_left1", gp.tileSize, gp.tileSize);
        left2 = setup("NPC/cow_left2", gp.tileSize, gp.tileSize);
        right1 = setup("NPC/cow_right1", gp.tileSize, gp.tileSize);
        right2 = setup("NPC/cow_right2", gp.tileSize, gp.tileSize);
        up1 = setup("NPC/cow_up1", gp.tileSize, gp.tileSize);
        up2 = setup("NPC/cow_up2", gp.tileSize, gp.tileSize);
    }

//    public void setAction() {
//        actionLookCounter++;
//        if (actionLookCounter == 120) {
//            Random random = new Random();
//            int i = random.nextInt(100) + 1;
//            if (i <= 25) {
//                direction = "up";
//                solidArea.x = size * 9 / 32;
//                solidArea.y = size * 2 / 32;
//                solidArea.width = 17;
//                solidArea.height = 29;
//            } else if (i <= 50) {
//                direction = "down";
//                solidArea.x = solidAreaDefaultX;
//                solidArea.y = solidAreaDefaultY;
//                solidArea.width = 18;
//                solidArea.height = 24;
//            } else if (i <= 75) {
//                direction = "right";
//                solidArea.x = size * 4 / 32;
//                solidArea.y = size * 16 / 32;
//                solidArea.width = 27;
//                solidArea.height = 16;
//            } else {
//                direction = "left";
//                solidArea.x = size * 3 / 32;
//                solidArea.y = size * 17 / 32;
//                solidArea.width = 27;
//                solidArea.height = 16;
//            }
//            actionLookCounter = 0;
//        }
//    }
}
