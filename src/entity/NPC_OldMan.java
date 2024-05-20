package entity;

import Main.GamePanel;
import object.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class NPC_OldMan extends Entity {
    private BufferedImage down3;
    public NPC_OldMan(GamePanel gp) {
        super(gp);
        name = "old man";
        direction = "down";
        speed = 0;
        getImage();
        setDialogue();
        setItem();
        size = gp.tileSize + 10;

        solidArea.x = 0;
        solidArea.y = 20;
        solidArea.width = 48;
        solidArea.height = 28;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        down1 = setup("NPC/oldman_down1", gp.tileSize, gp.tileSize);
        down2 = setup("NPC/oldman_down2", gp.tileSize, gp.tileSize);
        down3 = setup("NPC/oldman_down3", gp.tileSize, gp.tileSize);
//        left1 = setup("NPC/oldman");
//        left2 = setup("NPC/oldman");
//        right1 = setup("NPC/oldman");
//        right2 = setup("NPC/oldman");
//        up1 = setup("NPC/oldman");
//        up2 = setup("NPC/oldman");
    }

    public void setDialogue(){
        dialogues[0] = "I have some good stuff. Do you want to trade huh!";
    }

    public void setItem(){
        inventory.add(new Fish_Shark(gp));
        inventory.add(new Fish_Koicarp(gp));
        inventory.add(new Fish_Hammerhead(gp));
        inventory.add(new Fish_Herring(gp));
        inventory.add(new Fish_Sunfish(gp));
    }

    public void speak() {
        super.speak();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }

    public void update(boolean isDuck) {
        if (!isDuck) {
            spriteCounter++;
            if (spriteCounter > 13) {
                if (spriteNum == 2)
                    spriteNum = 3;
                else if (spriteNum == 3)
                    spriteNum = 1;
                else if (spriteNum == 1)
                    spriteNum = 2;
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

        //STOP MOVING THE CAMERA AT EDGE (ENTITY CAN NOT MOVE IF AT EDGE)
        //TOP
        if (gp.player.screenX >= gp.player.worldX) {
            screenX = worldX;
        }
        //LEFT
        if (gp.player.screenY >= gp.player.worldY) {
            screenY = worldY;
        }
        //RIGHT
        double rightOffSet = gp.screenWidth - gp.player.screenX;
        if (rightOffSet >= gp.worldWidth - gp.player.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        //BOTTOM
        double bottomOffSet = gp.screenHeight - gp.player.screenY;
        if (bottomOffSet >= gp.worldHeight - gp.player.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ////////////////////////
        if (direction.equals("down")) {
            if (spriteNum == 1) {
                image = down1;
            }
            else if (spriteNum == 2) {
                image = down2;
            }
            else if (spriteNum == 3) {
                image = down3;
            }
        }
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, (int) screenX, (int) screenY, size, size, null);
        } else if (gp.player.screenX > gp.player.worldX ||
                gp.player.screenY > gp.player.worldY ||
                rightOffSet > gp.worldWidth - gp.player.worldX ||
                bottomOffSet > gp.worldHeight - gp.player.worldY) {
            g2.drawImage(image, (int) screenX, (int) screenY, size, size, null);
        }
    }
}