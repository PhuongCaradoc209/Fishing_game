package tile;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[150];
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        for (int i = 0; i <= 130; i++) {
            setUp(i);
            if (i >= 41 && i <= 62 || i >= 65 && i <= 70) {
                tile[i].collision = true;
            } else {
                switch (i) {
                    case 71:
                    case 74:
                    case 75:
                    case 78:
                    case 79:
                    case 82:
                    case 83:
                    case 86:
                    case 87:
                    case 91:
                    case 95:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        tile[i].collision = true;
                        break;
                }
            }
        }
    }

    private void setUp(int index) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            String img = String.format("tiles/" + "%03d" + ".png", index);
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(img)));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map2.txt");
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            String line;
            while ((line = br.readLine()) != null && row < gp.maxWorldRow) {
                String[] numbers = line.split(" ");
                for (int col = 0; col < gp.maxWorldCol && col < numbers.length; col++) {
                    mapTileNum[row][col] = Integer.parseInt(numbers[col]);
                }
                row++;
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {
        int worldRow = 0, worldCol = 0;
        int tileNum;
        while (worldRow < gp.maxWorldRow && worldCol < gp.maxWorldCol) {
            tileNum = mapTileNum[worldRow][worldCol];
            //Coordinate for the world game
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            //Coordinate for the screen

            double screenX = worldX - gp.player.worldX + gp.player.screenX;
            double screenY = worldY - gp.player.worldY + gp.player.screenY;
            /*
              worldX - gp.player.worldX: display how far the tile is form the player
                   When player moves closer to the tile, its coordinate will decrease (opposing)
                   Ex: world: tile(20,30) & player(50,60) -> screenX = -30, -30 (out of screen)
                       world: tile(20,30) & player(10,40) -> screenX = 10, -10 (enter a little on screen)
               ...+ gp.player.screen:
                   Ex: when world Coordinate of tile and player both are (0,0)
                   this means at the corner of the world
                   -> screenX = 0 --> Wrong because it should be at the same place as player (at the center of screen)
                   -> therefore, have to plus gp.player.screen
             */

            //STOP MOVING THE CAMERA AT EDGE (TILES CAN NOT MOVE IF AT EDGE)
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

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, (int) screenX, (int) screenY, null);
            }
            //IF PLAYER AT THE EDGE
            else if (gp.player.screenX > gp.player.worldX ||
                    gp.player.screenY > gp.player.worldY ||
                    rightOffSet > gp.worldWidth - gp.player.worldX ||
                    bottomOffSet > gp.worldHeight - gp.player.worldY) {
                g2.drawImage(tile[tileNum].image, (int) screenX, (int) screenY, null);
            }

            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
