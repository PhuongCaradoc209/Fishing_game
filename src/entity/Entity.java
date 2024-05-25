package entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Entity {
    GamePanel gp;
    protected int size;
    public double worldX, worldY;
    public double speed;
    public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2,
            diagonal_up_left1, diagonal_up_left2, diagonal_up_right1, diagonal_up_right2,
            diagonal_down_left1, diagonal_down_left2, diagonal_down_right1, diagonal_down_right2,
            standUp, standDown, standRight, standLeft;
    public String direction = "down";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public Rectangle solidArea;//by this, you can manage which part of tile can be collision
    public boolean collisionOn = false;
    public int actionLookCounter = 0;

    //DIALOG
    public String dialogues[] = new String[20];
    public int dialogueIndex = 0;

    //CHARACTER PHYSICAL
    public int maxPhysical;
    public int physical;
    public int coin;

    //OBJ
    public BufferedImage image, image2, image3, image4, image5;
    public String name;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    public int price;
    public String description = "";
    public boolean collision = false;
    public int amount = 1;
    public boolean stackable = false;

    //Fish
    public BufferedImage collection_image, tradeState_image;
    public int fishStar;
    public String fishRarity;
 //   public String fishName;
    public BufferedImage fishFrame;
    public int count;
    public boolean caught = false;
    //    public BufferedImage fishImage;
    public BufferedImage fishFinalImage;

//    public BufferedImage starFill = setup("/Item/Starfill");
//    public BufferedImage starZero = setup("/Item/Starzero");


    public Entity(GamePanel gp) {
        this.gp = gp;
        solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
    }

    public void setAction() {
    }

    public void speak() {
        if (dialogues[dialogueIndex] == null) {
            gp.gameState = gp.playState;
            dialogueIndex = 0;
        } else {
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;
            switch (gp.player.direction) {
                case "up":
                    direction = "down";
                    break;
                case "down":
                    direction = "up";
                    break;
                case "left":
                    direction = "right";
                    break;
                case "right":
                    direction = "left";
                    break;
            }
        }
    }

    public void update(boolean isDuck) {
        setAction();
        collisionOn = isDuck;

        if (gp.currentMap == 0){
            gp.cChecker.checkObj(this, false);
            gp.cChecker.checkEntity(this, gp.npc);
            gp.cChecker.checkEntity(this, gp.animal);
            gp.cChecker.checkPlayer(this);
        }
        gp.cChecker.checkTile(this, isDuck);
        gp.cChecker.checkAtEdge(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (!collisionOn) {
//            System.out.println(direction);
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "diagonalUpLeft":
                    worldX -= speed;
                    worldY -= speed;
                    break;
                case "diagonalUpRight":
                    worldX += speed;
                    worldY -= speed;
                    break;
                case "diagonalDownLeft":
                    worldX -= speed;
                    worldY += speed;
                    break;
                case "diagonalDownRight":
                    worldX += speed;
                    worldY += speed;
                    break;
            }
        }

        spriteCounter++;
        if (spriteCounter > 20) {
            spriteNum = (spriteNum == 2) ? 1 : 2;
            spriteCounter = 0;
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
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "diagonalUpLeft":
                if (spriteNum == 1) {
                    image = diagonal_up_left1;
                }
                if (spriteNum == 2) {
                    image = diagonal_up_left2;
                }
                break;
            case "diagonalUpRight":
                if (spriteNum == 1) {
                    image = diagonal_up_right1;
                }
                if (spriteNum == 2) {
                    image = diagonal_up_right2;
                }
                break;
            case "diagonalDownLeft":
                if (spriteNum == 1) {
                    image = diagonal_down_left1;
                }
                if (spriteNum == 2) {
                    image = diagonal_down_left2;
                }
                break;
            case "diagonalDownRight":
                if (spriteNum == 1) {
                    image = diagonal_down_right1;
                }
                if (spriteNum == 2) {
                    image = diagonal_down_right2;
                }
                break;
        }
        //IF PLAYER AT THE EDGE
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

    public BufferedImage setup(String imagePath, int width, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + ".png")));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}