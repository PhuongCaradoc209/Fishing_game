package object;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;
import entity.Player;
import Main.UtilityTool;

public class Fishing_Rod {
    GamePanel gp;
    Player player;
    KeyHandler key;
    private static final int duration = 120;
    private static final int originalFrame = 12;
    private static final double delay = duration / originalFrame;
    private int timer = 0;
    private int level = 1;

    private boolean isFishing = false;

    // animation
    public BufferedImage[][] cast = new BufferedImage[3][12];
    public BufferedImage[] rod = new BufferedImage[10];

    // animation management
    private int castFrame = 0;
    private int rodFrame = 0;

    public BufferedImage setup(String imagePath, int width, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO
                    .read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + ".png")));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public boolean getIsFishing() {
        return isFishing;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Fishing_Rod(GamePanel gp, Player player, KeyHandler key) {
        this.gp = gp;
        this.player = player;
        this.key = key;

        // load image
        humanGoFishing();
        
    }

    public void dinoGoFishing() {
        // LEVEL 1
        rod[0] = setup("GoFishing/dinoCatchFish2", gp.tileSize, gp.tileSize);
        rod[1] = setup("GoFishing/dinoCatchFish4", gp.tileSize, gp.tileSize);
        rod[2] = setup("GoFishing/dinoCatchFish6", gp.tileSize, gp.tileSize);
        rod[3] = setup("GoFishing/dinoCatchFish8", gp.tileSize, gp.tileSize);
        rod[4] = setup("GoFishing/dinoCatchFish10", gp.tileSize, gp.tileSize);
        rod[5] = setup("GoFishing/dinoCatchFish12", gp.tileSize, gp.tileSize);
        rod[6] = setup("GoFishing/dinoCatchFish14", gp.tileSize, gp.tileSize);
        rod[7] = setup("GoFishing/dinoCatchFish16", gp.tileSize, gp.tileSize);
        rod[8] = setup("GoFishing/dinoCatchFish18", gp.tileSize, gp.tileSize);
        rod[9] = setup("GoFishing/dinoCatchFish20", gp.tileSize, gp.tileSize);


        cast[0][0] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][1] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][2] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][3] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][4] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][5] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][6] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][7] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][8] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][9] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][10] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);
        cast[0][11] = setup("GoFishing/dinoCatchFish1", gp.tileSize, gp.tileSize);

    }

    public void humanGoFishing() {
        // LEVEL 1
        rod[0] = setup("GoFishing/catchfish2", gp.tileSize, gp.tileSize);
        
        cast[0][0] = setup("GoFishing/catchfish1", gp.tileSize, gp.tileSize);

        cast[0][1] = setup("GoFishing/catchfish3", gp.tileSize, gp.tileSize);
        cast[0][2] = setup("GoFishing/catchfish4", gp.tileSize, gp.tileSize);

        cast[0][3] = setup("GoFishing/catchfish5", gp.tileSize, gp.tileSize);
        cast[0][4] = setup("GoFishing/catchfish7", gp.tileSize, gp.tileSize);
        cast[0][5] = setup("GoFishing/catchfish9", gp.tileSize, gp.tileSize);
        cast[0][6] = setup("GoFishing/catchfish11", gp.tileSize, gp.tileSize);
        cast[0][7] = setup("GoFishing/catchfish13", gp.tileSize, gp.tileSize);
        cast[0][8] = setup("GoFishing/catchfish15", gp.tileSize, gp.tileSize);
        cast[0][9] = setup("GoFishing/catchfish17", gp.tileSize, gp.tileSize);
        cast[0][10] = setup("GoFishing/catchfish19", gp.tileSize, gp.tileSize);
        cast[0][11] = setup("GoFishing/catchfish21", gp.tileSize, gp.tileSize);

        // LEVEL 2
        cast[1][0] = setup("GoFishing/catchfishgreen1", gp.tileSize, gp.tileSize);

        cast[1][1] = setup("GoFishing/catchfishgreen3", gp.tileSize, gp.tileSize);
        cast[1][2] = setup("GoFishing/catchfishgreen4", gp.tileSize, gp.tileSize);

        cast[1][3] = setup("GoFishing/catchfishgreen5", gp.tileSize, gp.tileSize);
        cast[1][4] = setup("GoFishing/catchfishgreen7", gp.tileSize, gp.tileSize);
        cast[1][5] = setup("GoFishing/catchfishgreen9", gp.tileSize, gp.tileSize);
        cast[1][6] = setup("GoFishing/catchfishgreen11", gp.tileSize, gp.tileSize);
        cast[1][7] = setup("GoFishing/catchfishgreen13", gp.tileSize, gp.tileSize);
        cast[1][8] = setup("GoFishing/catchfishgreen15", gp.tileSize, gp.tileSize);
        cast[1][9] = setup("GoFishing/catchfishgreen17", gp.tileSize, gp.tileSize);
        cast[1][10] = setup("GoFishing/catchfishgreen19", gp.tileSize, gp.tileSize);
        cast[1][11] = setup("GoFishing/catchfishgreen21", gp.tileSize, gp.tileSize);

        // LEVEL 3
        cast[2][0] = setup("GoFishing/catchfishpink1", gp.tileSize, gp.tileSize);

        cast[2][1] = setup("GoFishing/catchfishpink3", gp.tileSize, gp.tileSize);
        cast[2][2] = setup("GoFishing/catchfishpink4", gp.tileSize, gp.tileSize);

        cast[2][3] = setup("GoFishing/catchfishpink5", gp.tileSize, gp.tileSize);
        cast[2][4] = setup("GoFishing/catchfishpink7", gp.tileSize, gp.tileSize);
        cast[2][5] = setup("GoFishing/catchfishpink9", gp.tileSize, gp.tileSize);
        cast[2][6] = setup("GoFishing/catchfishpink11", gp.tileSize, gp.tileSize);
        cast[2][7] = setup("GoFishing/catchfishpink13", gp.tileSize, gp.tileSize);
        cast[2][8] = setup("GoFishing/catchfishpink15", gp.tileSize, gp.tileSize);
        cast[2][9] = setup("GoFishing/catchfishpink17", gp.tileSize, gp.tileSize);
        cast[2][10] = setup("GoFishing/catchfishpink19", gp.tileSize, gp.tileSize);
        cast[2][11] = setup("GoFishing/catchfishpink21", gp.tileSize, gp.tileSize);

        rod[1] = setup("GoFishing/catchfish6", gp.tileSize, gp.tileSize);
        rod[2] = setup("GoFishing/catchfish8", gp.tileSize, gp.tileSize);
        rod[3] = setup("GoFishing/catchfish10", gp.tileSize, gp.tileSize);
        rod[4] = setup("GoFishing/catchfish12", gp.tileSize, gp.tileSize);
        rod[5] = setup("GoFishing/catchfish14", gp.tileSize, gp.tileSize);
        rod[6] = setup("GoFishing/catchfish16", gp.tileSize, gp.tileSize);
        rod[7] = setup("GoFishing/catchfish18", gp.tileSize, gp.tileSize);
        rod[8] = setup("GoFishing/catchfish20", gp.tileSize, gp.tileSize);
        rod[9] = setup("GoFishing/catchfish22", gp.tileSize, gp.tileSize);

    }

    public boolean isFacingWater() {
        double yMap = player.worldX / gp.tileSize;
        double xMap = player.worldY / gp.tileSize;
        int distance = 1;

        switch (player.direction) {
            case "standUp":
                xMap -= distance;
                break;
            case "standDown":
                xMap += distance;
                break;
            case "standLeft":
                yMap -= distance;
                break;
            case "standRight":
                yMap += distance;
                break;

            default:
                return false;
        }
        int x = (int) xMap;
        int y = (int) yMap;
        if (x == -1 || y == -1) return false;
        
        int currentTile = gp.tileMgr.mapTileNum[gp.currentMap][x][y];
        // System.out.println(player.direction + " " + currentTile + " " + x + " " + y);
        if ((currentTile >= 41 && currentTile <= 58) || (currentTile >= 74 && currentTile <= 82) || (currentTile >= 118 && currentTile <= 122)) {
            // System.out.println("trueeee");
            return true;
        } else{
            // System.out.println("falseee");
            System.out.println(currentTile);
            // System.out.println(player.direction);
            return false;
        }
    }

    public void reset() {
        isFishing = false;
        castFrame = 0; 
        rodFrame = 0;
        key.AnnouceCompleteAnimation = false;
    }

    public void update() {
        if (isFacingWater() == true && key.spacePressed == true) {
            isFishing = true;
        }

        if (isFishing) {
            if (castFrame >= 11) {
                // reset();
                key.AnnouceCompleteAnimation = true;
                return;
            }
            if (timer == 0) {
                if (castFrame == 1 || castFrame == 2) {
                    castFrame++;
                } else {
                    rodFrame++;
                    castFrame++;
                }
            }
            timer++;
            if (timer >= delay) {
                timer = 0;
            }
        }
    }

    public BufferedImage getFrame() {
        if (isFishing && castFrame <= 11) {
            int size = gp.tileSize + 10;
            int marginRight = -1;
            // combine cast and rod
            // make rod[rodFrame] next to cast[castFrame]
            BufferedImage combined = new BufferedImage(size * 2, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combined.createGraphics();
            if (castFrame == 1 || castFrame == 2) {
                g.drawImage(cast[level - 1][castFrame], size + marginRight, 0, size, size, null);
            } else {
                g.drawImage(cast[level - 1][castFrame], size + marginRight, 0, size, size, null);
                g.drawImage(rod[rodFrame], 0, -1, size, size, null);
            }

            if (player.direction == "standRight") {
                BufferedImage flip = new BufferedImage(size * 2, size, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = flip.createGraphics();
                g2.drawImage(combined, 0, 0, size * 2, size, size * 2, 0, 0, size, null);
                g2.dispose();
                return flip;
            }
            g.dispose();
            return combined;

        }
        return null;
    }
}
