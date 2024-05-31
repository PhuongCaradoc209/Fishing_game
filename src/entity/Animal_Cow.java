package entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Animal_Cow extends Entity {
    private BufferedImage stand1, stand2, stand3, stand4, eat1, eat2, eat3, eat4, eat5;

    public Animal_Cow(GamePanel gp) {
        super(gp);
        name = "Cow";
        speed = 2;
        getImage();
        direction = "stand";
        size = gp.tileSize * 2;
        solidArea.x = -5;
        solidArea.y = 14 * size / 32;
        solidArea.width = 28 * size / 32;
        solidArea.height = 3 * size / 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        dialogues[0] = "Do you want to feed the cow?";
        // dialogues[1] = "Cow gives you a bottle of pure cow's milk!";
    }

    public void getImage() {
        // down1 = setup("Animal/cow_down1", gp.tileSize, gp.tileSize);
        // down2 = setup("Animal/cow_down2", gp.tileSize, gp.tileSize);
        // left1 = setup("Animal/cow_left1", gp.tileSize, gp.tileSize);
        // left2 = setup("Animal/cow_left2", gp.tileSize, gp.tileSize);
        // right1 = setup("Animal/cow_right1", gp.tileSize, gp.tileSize);
        // right2 = setup("Animal/cow_right2", gp.tileSize, gp.tileSize);
        // up1 = setup("Animal/cow_up1", gp.tileSize, gp.tileSize);
        // up2 = setup("Animal/cow_up2", gp.tileSize, gp.tileSize);
        stand1 = setup("Animal/cowStand_1", gp.tileSize, gp.tileSize);
        stand2 = setup("Animal/cowStand_2", gp.tileSize, gp.tileSize);
        stand3 = setup("Animal/cowStand_3", gp.tileSize, gp.tileSize);
        stand4 = setup("Animal/cowStand_4", gp.tileSize, gp.tileSize);
        eat1 = setup("Animal/CowEat_1", gp.tileSize, gp.tileSize);
        eat2 = setup("Animal/CowEat_2", gp.tileSize, gp.tileSize);
        eat3 = setup("Animal/CowEat_3", gp.tileSize, gp.tileSize);
        eat4 = setup("Animal/CowEat_4", gp.tileSize, gp.tileSize);
        eat5 = setup("Animal/CowEat_5", gp.tileSize, gp.tileSize);
    }

    public void update(boolean isDuck) {
        if (spriteNum == 1) {
            setAction();
        }

        if (!isDuck) {
            spriteCounter++;
            if (direction.equals("stand")) {
                if (spriteCounter > 14) {
                    if (spriteNum == 1)
                        spriteNum = 2;
                    else if (spriteNum == 2)
                        spriteNum = 3;
                    else if (spriteNum == 3)
                        spriteNum = 4;
                    else if (spriteNum == 4)
                        spriteNum = 1;

                    spriteCounter = 0;
                }
            } else if (direction.equals("eat")) {
                if (spriteCounter > 12) {
                    if (spriteNum == 1)
                        spriteNum = 2;
                    else if (spriteNum == 2)
                        spriteNum = 3;
                    else if (spriteNum == 3)
                        spriteNum = 4;
                    else if (spriteNum == 4) // START EATING
                        spriteNum = 5;
                    else if (spriteNum == 5)
                        spriteNum = 6;
                    else if (spriteNum == 6)
                        spriteNum = 7;
                    else if (spriteNum == 7)
                        spriteNum = 8;
                    else if (spriteNum == 8)
                        spriteNum = 9;
                    else if (spriteNum == 9)
                        spriteNum = 10;
                    else if (spriteNum == 10)
                        spriteNum = 11;
                    else if (spriteNum == 11)
                        spriteNum = 12;
                    else
                        spriteNum = 1;

                    spriteCounter = 0;
                }
            }
        }

    }   
    @Override
    public void speak(){
        super.speak();
        gp.gameState = gp.feedCowState;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

        // STOP MOVING THE CAMERA AT EDGE (ENTITY CAN NOT MOVE IF AT EDGE)
        // TOP
        if (gp.player.screenX >= gp.player.worldX) {
            screenX = worldX;
        }
        // LEFT
        if (gp.player.screenY >= gp.player.worldY) {
            screenY = worldY;
        }
        // RIGHT
        double rightOffSet = gp.screenWidth - gp.player.screenX;
        if (rightOffSet >= gp.worldWidth - gp.player.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        // BOTTOM
        double bottomOffSet = gp.screenHeight - gp.player.screenY;
        if (bottomOffSet >= gp.worldHeight - gp.player.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ////////////////////////
        if (direction.equals("stand")) {
            if (spriteNum == 1) {
                image = stand1;
            } else if (spriteNum == 2) {
                image = stand2;
            } else if (spriteNum == 3) {
                image = stand3;
            } else if (spriteNum == 4) {
                image = stand4;
            }
        }
        if (direction.equals("eat")) {
            image = switch (spriteNum) {
                case 1 -> eat1;
                case 2, 12 -> eat2;
                case 3, 11 -> eat3;
                case 4, 6, 8, 10 -> eat4;
                case 5, 7, 9 -> eat5;
                default -> null;
            };
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

    public void setAction() {
        actionLookCounter++;
        if (actionLookCounter == 50) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 45) {
                direction = "stand";
                actionLookCounter = 10;
            } else if (i <= 50) {
                direction = "eat";
                actionLookCounter = 0;
            } else if (i <= 85) {
                direction = "stand";
                actionLookCounter = 10;
            } else {
                direction = "eat";
                actionLookCounter = 0;
            }
        }
    }
}
