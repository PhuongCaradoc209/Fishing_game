package Main;

import java.awt.*;
import java.util.IllegalFormatCodePointException;

public class EventHandler {
    GamePanel gp;
    EventRect[][] eventRect;
    private int count;

    public EventHandler(GamePanel gp) {
        this.gp = gp;
        eventRect = new EventRect[gp.maxWorldRow][gp.maxWorldCol];

        int col = 0;
        int row = 0;
        while (row < gp.maxWorldRow && col < gp.maxWorldCol){
            eventRect[row][col] = new EventRect();
            eventRect[row][col].x = 23;
            eventRect[row][col].y = 23;
            eventRect[row][col].width = 2;
            eventRect[row][col].height = 2;
            eventRect[row][col].eventRectDefaultX = eventRect[row][col].x;
            eventRect[row][col].eventRectDefaultY = eventRect[row][col].y;

            col++;
            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
    }

    public void checkEvent(int level_Rod) {
        if (gp.keyHandler.spacePressed) {
            count++;
            if (count == 1) {
                if (gp.player.physical >= level_Rod)
                {
                    expendPhysical(level_Rod);
                }
                else
                {
                    outOfEnergy(gp.notificationState);
                }
            }
        }
        if (!gp.keyHandler.spacePressed) {
            count = 0;
        }
        if (hit(20, 12, "Up")){

        }
    }

    public boolean hit(int col, int row, String reqDirection){
        boolean hit =false;
        gp.player.solidArea.x = (int) (gp.player.worldX + gp.player.solidArea.x);
        gp.player.solidArea.y = (int) (gp.player.worldY + gp.player.solidArea.y);

        eventRect[row][col].x = row*gp.tileSize +eventRect[row][col].x;
        eventRect[row][col].y = col*gp.tileSize + eventRect[row][col].y;

        if (gp.player.solidArea.intersects(eventRect[row][col])){
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[row][col].x = eventRect[row][col].eventRectDefaultX;
        eventRect[row][col].y = eventRect[row][col].eventRectDefaultY;
        return hit;
    }

    public void expendPhysical(int level_Rod)
    {
        gp.player.physical -= level_Rod;
    }
    public void outOfEnergy(int game_State)
    {
        gp.gameState = game_State;
        gp.ui.currentTittle = "OOPS!";
        gp.ui.currentNotification = "No more energy";
    }
}