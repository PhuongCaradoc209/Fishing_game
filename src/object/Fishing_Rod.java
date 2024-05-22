package object;

import java.awt.Graphics2D;
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

    private boolean isFishing = false;

    // animation
    public BufferedImage[] cast = new BufferedImage[12];
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

    public Fishing_Rod(GamePanel gp, Player player, KeyHandler key) {
        this.gp = gp;
        this.player = player;
        this.key = key;

        // load image
        cast[0] = setup("GoFishing/catchfish1", gp.tileSize, gp.tileSize);
        rod[0] = setup("GoFishing/catchfish2", gp.tileSize, gp.tileSize);

        cast[1] = setup("GoFishing/catchfish3", gp.tileSize, gp.tileSize);
        cast[2] = setup("GoFishing/catchfish4", gp.tileSize, gp.tileSize);

        cast[3] = setup("GoFishing/catchfish5", gp.tileSize, gp.tileSize);
        cast[4] = setup("GoFishing/catchfish7", gp.tileSize, gp.tileSize);
        cast[5] = setup("GoFishing/catchfish9", gp.tileSize, gp.tileSize);
        cast[6] = setup("GoFishing/catchfish11", gp.tileSize, gp.tileSize);
        cast[7] = setup("GoFishing/catchfish13", gp.tileSize, gp.tileSize);
        cast[8] = setup("GoFishing/catchfish15", gp.tileSize, gp.tileSize);
        cast[9] = setup("GoFishing/catchfish17", gp.tileSize, gp.tileSize);
        cast[10] = setup("GoFishing/catchfish19", gp.tileSize, gp.tileSize);
        cast[11] = setup("GoFishing/catchfish21", gp.tileSize, gp.tileSize);

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

        switch (player.direction) {
            case "standUp":
                yMap--;
                break;
            case "standDown":
                yMap++;
                break;
            case "standLeft":
                xMap--;
                break;
            case "standRight":
                xMap++;
                break;

            default:
                return false;
        }
        int x = (int) xMap;
        int y = (int) yMap;

        int currentTile = gp.tileMgr.mapTileNum[x][y];
        // System.out.println(player.direction + " " + currentTile + " " + x + " " + y);
        if (currentTile >= 41 && currentTile <= 58) {
            return true;
        } else
            return false;
    }

    public void reset() {
        isFishing = false;
        castFrame = 0;
        rodFrame = 0;
    }

    public void update() {
        if (key.fPressed == true) {
            System.out.println(isFacingWater());
        }
        if (isFacingWater() == true && key.fPressed == true) {
            isFishing = true;
        }

        if (isFishing) {
            if (castFrame >= 11) {
                reset();
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
            // combine cast and rod
            // make rod[rodFrame] next to cast[castFrame]
            BufferedImage combined = new BufferedImage(size * 2, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combined.createGraphics();
            if (castFrame == 1 || castFrame == 2) {
                g.drawImage(cast[castFrame], size, 0, size, size, null);
            } else {
                g.drawImage(cast[castFrame], size, 0, size, size, null);
                g.drawImage(rod[rodFrame], 0, 0, size, size, null);
            }
            g.dispose();
            return combined;

        }
        return null;
    }
}
