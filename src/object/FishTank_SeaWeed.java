package object;

import Main.GamePanel;
import entity.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FishTank_SeaWeed extends Entity {
    private BufferedImage down3, down4, down5;
    public FishTank_SeaWeed(GamePanel gp, int size) {
        super(gp);
        name = "Sea Weed";
        direction = "down";
        speed = 0;
        this.size = size;
        getImage();
    }

    public void getImage() {
        down1 = setup("objects/seaWeed1", 28, 62);
        down2 = setup("objects/seaWeed2", 28, 62);
        down3 = setup("objects/seaWeed3", 28, 62);
        down4 = setup("objects/seaWeed4", 28, 62);
        down5 = setup("objects/seaWeed5", 28, 62);
    }
    public void update(boolean isDuck) {
        if (!isDuck) {
            spriteCounter++;
            if (spriteCounter > 17) {
                if (spriteNum == 1)
                    spriteNum = 2;
                else  if (spriteNum == 2)
                    spriteNum = 3;
                else if (spriteNum == 3)
                    spriteNum = 4;
                else if (spriteNum == 4)
                    spriteNum = 5;
                else if (spriteNum == 5)
                    spriteNum = 1;
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
            else if (spriteNum == 4) {
                image = down4;
            }
            else if (spriteNum == 5) {
                image = down5;
            }
        }
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, (int) screenX, (int) screenY, size, size*2, null);
        } else if (gp.player.screenX > gp.player.worldX ||
                gp.player.screenY > gp.player.worldY ||
                rightOffSet > gp.worldWidth - gp.player.worldX ||
                bottomOffSet > gp.worldHeight - gp.player.worldY) {
            g2.drawImage(image, (int) screenX, (int) screenY, size, size*2, null);
        }
    }
}
