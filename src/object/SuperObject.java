package object;

import Main.AssetSetter;
import Main.GamePanel;
import Main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image, image2, image3, image4, image5;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, GamePanel gp) {

        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

        //STOP MOVING THE CAMERA AT EDGE (OBJECTS CAN NOT MOVE IF AT EDGE)
        if(gp.player.worldX < gp.player.screenX) {
            screenX = worldX;
        }
        if(gp.player.worldY < gp.player.screenY) {
            screenY = worldY;
        }
        double rightOffSet = gp.screenWidth - gp.player.screenX;
        if(rightOffSet > gp.worldWidth - gp.player.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        double bottomOffSet = gp.screenHeight - gp.player.screenY;
        if(bottomOffSet > gp.worldHeight - gp.player.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }
        else if (gp.player.screenX > gp.player.worldX ||
                gp.player.screenY > gp.player.worldY ||
                rightOffSet > gp.worldWidth - gp.player.worldX ||
                bottomOffSet > gp.worldHeight - gp.player.worldY)
        {
            g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}