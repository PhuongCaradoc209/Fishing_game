package Main;

import entity.Entity;
import object.OBJ_PHYSICAL;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pixel;
    BufferedImage physical_0, physical_0_5, physical_1, physical_1_5, physical_2,fishImage;
    public String currentDialogue = "";
    public String currentNotification = "";
    public String currentTittle = "";
    public int commandNum = 0;
    int subState = 0;
    BufferedImage image;
    final BufferedImage tittle, humanImg, dinoImg, humanUnselect, dinoUnselect;
    public int inventorySlotCol = 0;
    public int inventorySlotRow = 0;
    public int completion;
    public String fishName="", fishPrice="", fishRarity="";

    public UI(GamePanel gp) {
        this.gp = gp;
        try {
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            pixel = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
        //GET TYPE OF CHARACTER
        humanImg = setup("player/human", 1251, 1641);
        dinoImg = setup("player/Dino", 1244, 1707);
        humanUnselect = setup("player/human_Unselect", 1231, 1652);
        dinoUnselect = setup("player/dino_Unselect", 1252, 1693);

        tittle = setup("background/tittle", gp.screenWidth, gp.screenHeight);
        //CREATE PHYSICAL OBJECT
        Entity physical = new OBJ_PHYSICAL(gp);
        physical_0 = physical.image;
        physical_0_5 = physical.image2;
        physical_1 = physical.image3;
        physical_1_5 = physical.image4;
        physical_2 = physical.image5;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(pixel);
        g2.setColor(Color.white);

        //TITTLE STATE
        if (gp.gameState == gp.tittleState) {
            drawTittleScreen();
        }
        //SELECT PLAYER STATE
        if (gp.gameState == gp.selectPlayerState) {
            drawSelectPlayerScreen();
        }
        //PLAY STATE
        else if (gp.gameState == gp.playState) {
            drawPlayerPhysical();
        }
        //DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            drawPlayerPhysical();
            drawDialogueScreen();
        }
        //AUTO DISPLAY STATE
        else if (gp.gameState == gp.autoDisplayState) {
            drawPlayerPhysical();
            drawDialogueInteract();
        }
        //NOTIFICATION STATE
        else if (gp.gameState == gp.notificationState) {
            drawPlayerPhysical();
            drawNotificationScreen();
        }
        //OPTION STATE
        if (gp.gameState == gp.optionState) {
            drawOptionScreen();
        }
        //AFTER FISHING STATE
        if (gp.gameState == gp.afterFishingState) {
            drawAfterFishingScreen();
            //INVENTORY STATE
        } else if (gp.gameState == gp.inventoryState) {
            drawInventoryScreen();
        }
        //FISHING STATE
        else if (gp.gameState == gp.fishingState) {
            drawFishingScreen();
        }

    }

    public void drawTittleScreen() {
        //DRAW BACKGROUND
        g2.drawImage(tittle, 0, 0, null);

        //TITTLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        g2.setColor(Color.white);
        String text = "Holly Fish";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 3;

        //SHADOW TEXT
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 5, y + 5);

        //MAIN COLOR TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize * 3;
        //TEXT OUTLINE
        g2.setColor(new Color(0x10439F));
        g2.drawString(text, x - 2, y - 2);
        g2.drawString(text, x - 2, y + 2);
        g2.drawString(text, x + 2, y - 2);
        g2.drawString(text, x + 2, y + 2);
        g2.drawString(text, x - 2, y);
        g2.drawString(text, x + 2, y);
        g2.drawString(text, x, y - 2);
        g2.drawString(text, x, y + 2);
        //DRAW TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.setColor(new Color(0xF9F07A));
            g2.drawString(text, x, y);
            g2.drawString(">", x - gp.tileSize, y);
            g2.setColor(Color.white);
        }

        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize * 2;
        //TEXT OUTLINE
        g2.setColor(new Color(0x10439F));
        g2.drawString(text, x - 2, y - 2);
        g2.drawString(text, x - 2, y + 2);
        g2.drawString(text, x + 2, y - 2);
        g2.drawString(text, x + 2, y + 2);
        g2.drawString(text, x - 2, y);
        g2.drawString(text, x + 2, y);
        g2.drawString(text, x, y - 2);
        g2.drawString(text, x, y + 2);
        //DRAW TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.setColor(new Color(0xF9F07A));
            g2.drawString(text, x, y);
            g2.drawString(">", x - gp.tileSize, y);
            g2.setColor(Color.white);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize * 2;
        //TEXT OUTLINE
        g2.setColor(new Color(0x10439F));
        g2.drawString(text, x - 2, y - 2);
        g2.drawString(text, x - 2, y + 2);
        g2.drawString(text, x + 2, y - 2);
        g2.drawString(text, x + 2, y + 2);
        g2.drawString(text, x - 2, y);
        g2.drawString(text, x + 2, y);
        g2.drawString(text, x, y - 2);
        g2.drawString(text, x, y + 2);
        //DRAW TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.setColor(new Color(0xF9F07A));
            g2.drawString(text, x, y);
            g2.drawString(">", x - gp.tileSize, y);
            g2.setColor(Color.white);
        }
    }

    public void drawSelectPlayerScreen() {
        //DRAW BACKGROUND
        g2.setColor(new Color(0x9c9c9c));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        //MENU
        int x;
        int y = gp.tileSize * 2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

        //HUMAN
        x = gp.tileSize * 3;
        y += gp.tileSize;
        image = humanUnselect;
        g2.drawImage(image, x - 50, y, 1244 / 4, 1707 / 4, null);

        x += gp.tileSize / 2 - 5;
        y += gp.tileSize * 7;
        String text = "HUMAN";
        g2.setColor(Color.black);
        g2.drawString(text, x, y - 7);

        if (commandNum == 1) {
            g2.setColor(new Color(0x7AB2B2));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            image = humanImg;
            g2.drawImage(image, gp.tileSize * 3 - 50, gp.tileSize * 3, 1244 / 4, 1707 / 4, null);
            g2.setColor(Color.black);
            g2.drawString(text, x, y - 7);
        }


        //DINO
        x += gp.tileSize * 10;
        y = gp.tileSize * 3;
        image = dinoUnselect;
        g2.drawImage(image, x - 50, y, 1244 / 4, 1707 / 4, null);
        //TEXT OUTLINE
        text = "DINO";
        x += gp.tileSize - 5;
        y += gp.tileSize * 7;
        //DRAW TEXT
        g2.setColor(Color.black);
        g2.drawString(text, x, y - 7);
        if (commandNum == 2) {
            g2.setColor(new Color(0xa2c26a));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //DRAW DINO
            image = dinoImg;
            g2.drawImage(image, x - gp.tileSize + 5 - 50, y - gp.tileSize * 7, 1244 / 4, 1707 / 4, null);

            g2.setColor(Color.black);
            g2.drawString(text, x, y - 7);

            //DRAW HUMAN
            image = humanUnselect;
            g2.drawImage(image, gp.tileSize * 3 - 50, gp.tileSize * 3, 1244 / 4, 1707 / 4, null);

            x = gp.tileSize * 3 + gp.tileSize / 2 - 5;
            y = gp.tileSize * 10;
            text = "HUMAN";
            g2.setColor(Color.black);
            g2.drawString(text, x, y - 7);
        }

        //TITTLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        g2.setColor(Color.white);
        text = "Character";
        x = getXforCenteredText(text);
        y = gp.tileSize * 2;

        //SHADOW TEXT
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 5, y + 5);

        //MAIN COLOR TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
    }

    public void drawPlayerPhysical() {
        int x = gp.tileSize;
        int y = gp.tileSize / 2;

        //DRAW PHYSICAL FRAME
        image = setup("background/PhysicalFrame", 423, 107);
        g2.drawImage(image, gp.tileSize/2, y - 5, gp.tileSize * 5, gp.tileSize + 10, null);

        int i = 0;

        //DRAW BLANK PHYSICAL
        while (i < gp.player.maxPhysical) {
            g2.drawImage(physical_0, x, y, null);
            i += 4;
            x += gp.tileSize;
        }
        //RESET
        x = gp.tileSize;
        y = gp.tileSize / 2;
        i = 0;
        while (i < gp.player.physical) {
            g2.drawImage(physical_0_5, x, y, null);
            i++;
            if (i < gp.player.physical) {
                g2.drawImage(physical_1, x, y, null);
                i++;
                if (i < gp.player.physical) {
                    g2.drawImage(physical_1_5, x, y, null);
                    i++;
                    if (i < gp.player.physical) {
                        g2.drawImage(physical_2, x, y, null);
                    }
                }
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawNotificationScreen() {
        int x = gp.tileSize * 5;
        int y = gp.tileSize * 3;
        int width = gp.screenWidth - (gp.tileSize * 10);
        int height = gp.tileSize * 3;

        drawSubWindow(x, y, width, height);
        //TITLE
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));

        //calculate the centerX for the text
        FontMetrics fontMetrics = g2.getFontMetrics(g2.getFont());
        int textWidth = fontMetrics.stringWidth(currentTittle);
        int centerX = x + (width - textWidth) / 2;

        y += gp.tileSize;

        g2.drawString(currentTittle, centerX, y);
        //TEXT
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));

        fontMetrics = g2.getFontMetrics(g2.getFont());
        textWidth = fontMetrics.stringWidth(currentNotification);
        centerX = x + (width - textWidth) / 2;

        y += gp.tileSize;

        g2.drawString(currentNotification, centerX, y);
    }

    public void drawOptionScreen() {
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        //SUB WINDOW
        int frameX = gp.tileSize * 6;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 8;
        int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch (subState) {
            case 0:
                option_top(frameX, frameY);
                break;
            case 1:
                options_fullScreenNotification(frameX, frameY);
                break;

            case 2:
                options_control(frameX, frameY);
                break;

            case 3:
                options_endGameConfirmation(frameX, frameY);
                break;

            case 4:
                break;
        }
        gp.keyHandler.enterPressed = false;
    }

    private void option_top(int frameX, int frameY) {
        int textX;
        int textY;

        //TITLE
        String text = "OPTIONS";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        //FULL SCREEN ON/OFF
        textX = frameX + gp.tileSize;
        textY += gp.tileSize * 2;
        g2.drawString("Full Screen", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                gp.fullScreenOn = !gp.fullScreenOn;
                subState = 1;
            }
        }
        //MUSIC
        textY += gp.tileSize;
        g2.drawString("Music", textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX - 25, textY);
        }

        //SE
        textY += gp.tileSize;
        g2.drawString("SE", textX, textY);
        if (commandNum == 2) {
            g2.drawString(">", textX - 25, textY);
        }

        //CONTROL
        textY += gp.tileSize;
        g2.drawString("Control", textX, textY);
        if (commandNum == 3) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 2;
                commandNum = 0;
            }
        }

        //END GAME
        textY += gp.tileSize;
        g2.drawString("End Game", textX, textY);
        if (commandNum == 4) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 3;
                commandNum = 0;
            }

        }

        //BACK
        textY += gp.tileSize * 2;
        g2.drawString("Back", textX, textY);
        if (commandNum == 5) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }

        //FULL SCREEN CHECK BOX
        textX = frameX + (int) (gp.tileSize * 4.5);
        textY = frameY + gp.tileSize * 2 + 35;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX, textY, 24, 24);
        if (gp.fullScreenOn) {
            g2.fillRect(textX, textY, 24, 24);
        }

        //MUSIC VOLUME
        textY += gp.tileSize;
        g2.drawRect(textX, textY, 120, 24);
        int volumeWidth = 24 * gp.music.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        //SE VOLUME
        textY += gp.tileSize;
        g2.drawRect(textX, textY, 120, 24);
        volumeWidth = 24 * gp.soundEffect.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);
    }

    private void options_fullScreenNotification(int frameX, int frameY) {
        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize * 3;

        currentDialogue = "The change will take \neffect after restarting the game.";
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += gp.tileSize;
        }

        //BACK
        textY = frameY + gp.tileSize * 9;
        g2.drawString("Back", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 0;
            }
        }
    }

    private void options_control(int frameX, int frameY) {
        int textX;
        int textY;

        //TITLE
        String text = "Control";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        textX = frameX + gp.tileSize;
        textY += gp.tileSize;
        g2.drawString("Move", textX, textY);

        textY += gp.tileSize;
        g2.drawString("Fishing", textX, textY);

        textY += gp.tileSize;
        g2.drawString("Bag", textX, textY);

        textY += gp.tileSize;
        g2.drawString("Menu", textX, textY);

        //DISPLAY KEY
        textX = frameX + gp.tileSize * 6;
        textY = frameY + gp.tileSize;
        textY += gp.tileSize;
        g2.drawString("W,A,S,D", textX, textY);

        textY += gp.tileSize;
        g2.drawString("F", textX, textY);

        textY += gp.tileSize;
        g2.drawString("B", textX, textY);

        textY += gp.tileSize;
        g2.drawString("ESC", textX, textY);

        //BACK
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize * 9;
        g2.drawString("Back", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 0;
                commandNum = 3;
            }
        }
    }

    private void options_endGameConfirmation(int frameX, int frameY) {
        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize * 3;

        currentDialogue = "Quit the game and /nreturn to the tittle screen?";

        for (String line : currentDialogue.split("/n")) {
            g2.drawString(line, textX, textY);
            textY += gp.tileSize;
        }

        //YES
        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.tileSize * 2;
        g2.drawString(text, textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 0;
                gp.gameState = gp.tittleState;
            }
        }

        //NO
        text = "No";
        textX = getXforCenteredText(text);
        textY += gp.tileSize;
        g2.drawString(text, textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyHandler.enterPressed) {
                subState = 0;
                commandNum = 4;
            }
        }
    }

    public void drawDialogueInteract() {
        double worldX = gp.tileSize * 19.5;
        double worldY = gp.tileSize * 8;
        //Coordinate for the screen
        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

        int width = 28;
        int height = 29;
        image = setup("Dialog/dialog", width, height);

        //STOP MOVING THE CAMERA AT EDGE (DIALOG CAN NOT MOVE IF AT EDGE)
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
            g2.drawImage(image, (int) screenX, (int) screenY, null);
        }
        //IF PLAYER AT THE EDGE
        else if (gp.player.screenX > gp.player.worldX ||
                gp.player.screenY > gp.player.worldY ||
                rightOffSet > gp.worldWidth - gp.player.worldX ||
                bottomOffSet > gp.worldHeight - gp.player.worldY) {
            g2.drawImage(image, (int) screenX, (int) screenY, null);
        }
    }

    public void drawDialogueScreen() {
        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 3;

        drawSubWindow(x, y, width, height);

        //TEXT
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        //BACKGROUND
        Color c = new Color(0, 0, 0, 210); //OPACITY
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

//        BORDER
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(7));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
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

    public void drawFishingScreen() {
        completion -= 1;
        drawSubWindow(gp.tileSize * 7, gp.tileSize * 3, 2 * gp.tileSize, 5 * gp.tileSize, Color.GRAY, new Color(0, 0, 0, 0), 15, 5);
        int n = completion / 10;
        int x = gp.tileSize * 29 / 4;
        int y = gp.tileSize * 15 / 2;
        for (int i = 1; i <= n; i++) {
            g2.setColor(new Color(0x4CC844));
            g2.fillRect(x, y, gp.tileSize * 3 / 2, gp.tileSize / 2);
            y -= gp.tileSize / 2;
        }
        drawSubWindow(gp.tileSize * 7, gp.tileSize * 3, 2 * gp.tileSize, 5 * gp.tileSize, new Color(255, 255, 255, 0), Color.BLACK, 15, 3);
    }

    public void drawAfterFishingScreen() {
        drawFishingBackGround();
        drawFishingCaughtAndInformation();
    }

    public void drawInventoryScreen() {
        drawInventoryBackground();
        drawString("INVENTORY", gp.tileSize * 13 / 4, gp.tileSize * 3, pixel, new Color(0x74342E));
        drawInventoryItemImage_Border_Number();
        drawCursor();
        displayItemIsChosen();
    }

    public void drawSubWindow(int x, int y, int width, int height, Color cbg, Color cs, int strokeSize, int arc) {
        g2.setColor(cbg);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setColor(cs);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, arc, arc);
    }

    public void drawInventoryBackground() {
        int x = gp.tileSize;
        int y = gp.tileSize * 2;
        int width = gp.tileSize * 19 / 2;
        int height = gp.tileSize * 8;
        Color cbg = new Color(0xF4CE98);
        Color cs = new Color(0x5e3622);
        drawSubWindow(x, y, width, height, cbg, cs, 10, 10);
        drawSubWindow(x * 5 / 4 + width, y, gp.tileSize * 9 / 2, gp.tileSize * 8, cbg, cs, 10, 10);
    }

    public void drawInventoryItemImage_Border_Number(){
        int count = 0;
        int imageAndBorderX = gp.tileSize * 3/2;
        int imageAndBorderY = gp.tileSize * 7/2;
        int amountX =gp.tileSize * 37/16;
        int amountY = gp.tileSize * 35/8;
        for(int i = 0;i < 4;i++){
            for(int j = 0; j < 6;j++){
                if (gp.iManage.inventory[count] != null){
                    //draw imageOfFish
                    gp.iManage.setImage(gp.iManage.inventory[count]);
                    g2.drawImage(gp.iManage.inventory[count].fishFinalImage, imageAndBorderX, imageAndBorderY,gp.tileSize,gp.tileSize, null);

                    //draw border
                    g2.setColor(new Color(0xA26D48));
                    g2.setStroke(new BasicStroke(5));
                    g2.drawRoundRect(imageAndBorderX,imageAndBorderY,gp.tileSize +1,gp.tileSize +1,15,15);

                    //display amount
                    g2.setFont(pixel);
                    g2.setColor(Color.BLACK);
                    g2.drawString(String.valueOf(gp.iManage.inventory[count].count),amountX,amountY);

                    imageAndBorderX+= gp.tileSize * 3/2;
                    amountX += gp.tileSize * 3/2;
                    count++;
                }
            }
            imageAndBorderX = gp.tileSize * 3/2;
            imageAndBorderY += gp.tileSize * 3/2;
            amountX = gp.tileSize * 37/16;
            amountY += gp.tileSize * 3/2;
        }
    }

    public void drawString(String s, int x, int y, Font f, Color c) {
        g2.setColor(c);
        g2.setFont(f);
        g2.drawString(s, x, y);
    }

    public void drawFishingBackGround() {
        int x = gp.tileSize * 3;
        int y = gp.tileSize * 2;
        int width = gp.tileSize * 10;
        int height = gp.tileSize * 8;
        Color cbg = new Color(190, 140, 99);
        Color cs = new Color(54, 21, 0);
        drawSubWindow(x, y, width, height, cbg, cs, 25, 45);
    }

    public void drawFishingCaughtAndInformation(){
        //draw imageOfFish of fish caught
        g2.drawImage(fishImage, 7 * gp.tileSize, gp.tileSize *3,gp.tileSize *2,gp.tileSize *2,null);

        //display fish information
        drawString("Name: "+fishName,gp.tileSize *4,gp.tileSize *6,pixel,new Color(54,21,0));
        drawString("Price: "+fishPrice,gp.tileSize *4,gp.tileSize *7,pixel,new Color(54,21,0));
        drawString("Rarity: ",gp.tileSize *4,gp.tileSize *8,pixel,new Color(54,21,0));
        switch (fishRarity){
            case "Common":
                drawString(fishRarity,gp.tileSize *6,gp.tileSize *8,pixel,new Color(0x54A61C));
                break;
            case "Uncommon":
                drawString(fishRarity,gp.tileSize *6,gp.tileSize *8,pixel,new Color(0x378CE7));
                break;
            case "Rare":
                drawString(fishRarity,gp.tileSize *6,gp.tileSize *8,pixel,new Color(200 ,50,145));
                break;
            case "Legendary":
                drawString(fishRarity,gp.tileSize *6,gp.tileSize *8,pixel,new Color(0xF98E04));
                break;
            default:
                break;
        }
    }

    public void drawCursor() {
        final int xStart = gp.tileSize * 3 / 2;
        final int yStart = gp.tileSize * 7 / 2;

        int cursorX = xStart + (gp.tileSize * 3 / 2 * inventorySlotCol);
        int cursorY = yStart + (gp.tileSize * 3 / 2 * inventorySlotRow);

        g2.setColor(new Color(0xD46352));
        g2.drawRoundRect(cursorX, cursorY, gp.tileSize + 1, gp.tileSize + 1, 15, 15);
    }

    public void displayItemIsChosen(){

        int choose = 6 * inventorySlotRow + inventorySlotCol;
        if(gp.iManage.inventory[choose] != null){
            g2.drawImage(gp.iManage.inventory[choose].fishFinalImage,gp.tileSize *12,gp.tileSize *3,gp.tileSize *2,gp.tileSize *2,null);
            g2.setFont(pixel);
            FontMetrics fm = g2.getFontMetrics(g2.getFont());
            g2.setColor(new Color(0x7B342E));

            String text;

            if(gp.iManage.inventory[choose].caught == false){
                text = "?";
            }
            else {
                text = gp.iManage.inventory[choose].name;
            }
            int textWidth = fm.stringWidth(text);
            int centerX = gp.tileSize *45/4 + (gp.tileSize *7/2 - textWidth)/2;
            g2.drawString(text,centerX,gp.tileSize *11/2);

            textWidth = fm.stringWidth("Count: "+gp.iManage.inventory[choose].count);
            centerX = gp.tileSize *45/4 + (gp.tileSize *7/2 - textWidth)/2;
            g2.drawString("Count: "+gp.iManage.inventory[choose].count, centerX,gp.tileSize *6);


            if(gp.iManage.inventory[choose].caught == false){
                text = "?";
            }
            else {
                text = gp.iManage.inventory[choose].fishRarity;
            }
            textWidth = fm.stringWidth(text);
            centerX = gp.tileSize *45/4 + (gp.tileSize *7/2 - textWidth)/2;
            int y = gp.tileSize *13/2;

            if(gp.iManage.inventory[choose].caught == false){
                g2.setColor(new Color(0x7B342E));
                g2.drawString(text,centerX,y);
            }
            else {
                switch (text) {
                    case "Common":
                        g2.setColor(new Color(0x54A61C));
                        g2.drawString(text, centerX, y);
                        break;
                    case "Uncommon":
                        g2.setColor(new Color(0x378CE7));
                        g2.drawString(text, centerX, y);
                        break;
                    case "Rare":
                        g2.setColor(new Color(200, 50, 145));
                        g2.drawString(text, centerX, y);
                        break;
                    case "Legendary":
                        g2.setColor(new Color(0xF98E04));
                        g2.drawString(text, centerX, y);
                        break;
                }
            }
            g2.setColor(new Color(0xA26D48));
            g2.drawRoundRect(gp.tileSize *12,gp.tileSize *3,gp.tileSize *2,gp.tileSize *2,15,15);

        }
    }
}