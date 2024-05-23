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
    Font font, font1, font2, font3,font3a,font4, font4a, font5, font6,font7;
    BufferedImage physical_0, physical_0_5, physical_1, physical_1_5, physical_2, fishImage;
    public String currentDialogue = "";
    public String currentNotification = "";
    public String currentTittle = "";
    public int commandNum = 0;
    int subState = 0;
    public int playerSlotCol = 0;
    public int playerSlotRow = 0;
    public int npcSlotCol = 0;
    public int npcSlotRow = 0;
    BufferedImage image, fishFrame;
    final BufferedImage tittle, humanImg, dinoImg, humanUnselect, dinoUnselect, coin;
    public int inventorySlotCol = 0;
    public int inventorySlotRow = 0;
    public double completion;
    public String fishName = "", fishPrice = "", fishRarity = " ",desFishing  = " ",desCollections= " ";
    public Entity npc;

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
        coin = setup("objects/coin_bronze", gp.tileSize, gp.tileSize);

        tittle = setup("background/tittle", gp.screenWidth, gp.screenHeight);
        //CREATE PHYSICAL OBJECT
        Entity physical = new OBJ_PHYSICAL(gp);
        physical_0 = physical.image;
        physical_0_5 = physical.image2;
        physical_1 = physical.image3;
        physical_1_5 = physical.image4;
        physical_2 = physical.image5;
        font = pixel.deriveFont(Font.BOLD, 60f);
        font1 = pixel.deriveFont(Font.BOLD, 30f);
        font2 = pixel.deriveFont(Font.BOLD, 10f);
        font3 = pixel.deriveFont(Font.BOLD, 20f);
        font3a = pixel.deriveFont(Font.PLAIN, 20f);
        font4 = pixel.deriveFont(Font.BOLD, 25f);
        font4a = pixel.deriveFont(Font.PLAIN, 22f);
        font5 = pixel.deriveFont(Font.BOLD, 38f);
        font6 = pixel.deriveFont(Font.PLAIN, 18f);
        font7 = pixel.deriveFont(Font.BOLD,15f);

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
            drawPlayerPhysical();
            drawOptionScreen();
        }
        //AFTER FISHING STATE
        if (gp.gameState == gp.afterFishingState) {
            drawAfterFishingScreen();
            drawPlayerPhysical();
        }
        //INVENTORY STATE
        else if (gp.gameState == gp.inventoryState) {
            drawPlayerPhysical();
            drawInventoryScreen();
        }
        //FISHING STATE
        else if (gp.gameState == gp.fishingState) {
            drawPlayerPhysical();
            drawFishingScreen();
        }

        //TRADE STATE
        if(gp.gameState == gp.tradeState){
            drawTradeScreen();
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
        g2.drawImage(image, gp.tileSize / 2, y - 5, gp.tileSize * 5, gp.tileSize + 10, null);

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
        double worldX, worldY;
        double screenX, screenY;
        if (gp.player.interactEntity.get(gp.player.interactEntity_Index).name.equals("old man")) {
            worldX = gp.tileSize * 19.5;
            worldY = gp.tileSize * 8;
            //Coordinate for the screen
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;

            image = setup("Dialog/dialog", 28, 29);
        } else {
            worldX = gp.tileSize * 16.5;
            worldY = gp.tileSize * 2.5;
            //Coordinate for the screen
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;

            image = setup("Dialog/dialog", 28, 29);
        }

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

    public void drawFishingScreen() {
        completion -= 0.5;
        drawSubWindow1(gp.tileSize * 7, gp.tileSize * 3, 2 * gp.tileSize, 5 * gp.tileSize, Color.GRAY, new Color(0, 0, 0, 0), 15, 5);
        double n = completion / 10;

        int x = gp.tileSize * 29 / 4;
        int y = gp.tileSize * 15 / 2;
        for (int i = 1; i <= n; i++) {
            g2.setColor(new Color(0x4CC844));
            g2.fillRect(x, y, gp.tileSize * 3 / 2, gp.tileSize / 2);
            y -= gp.tileSize / 2;
        }
        drawSubWindow1(gp.tileSize * 7, gp.tileSize * 3, 2 * gp.tileSize, 5 * gp.tileSize, new Color(255, 255, 255, 0), Color.BLACK, 15, 3);
    }

    public void drawInventoryScreen() {
        drawInventoryBackground();
        setFontAndColor(font, new Color(0x74342E));
        g2.drawString("COLLECTIONS", center("COLLECTIONS",gp.tileSize * 3,gp.tileSize * 19 / 2), gp.tileSize * 4);
        drawInventoryItemImage_Border_Number();
        drawCursor();
        displayItemIsChosen1();
    }

    public void drawInventoryBackground() {
        int x = gp.tileSize * 3;
        int y = gp.tileSize * 5 / 2;
        int width = gp.tileSize * 19 / 2;
        int height = gp.tileSize * 15 / 2;
        Color cbg = new Color(0xF4CE98);
        Color cs = new Color(0x5e3622);
        drawSubWindow1(x, y, width, height, cbg, cs, 10, 10);
        drawSubWindow1(x * 5 / 4 + width, y, gp.tileSize * 9 / 2, height, cbg, cs, 10, 10);
    }

    public void drawInventoryItemImage_Border_Number() {
        int count = 0;
        int imageAndBorderX = gp.tileSize * 17/4;
        int imageAndBorderY = gp.tileSize * 9 / 2;
        int amountX = gp.tileSize * 81 / 16;
        int amountY = gp.tileSize * 43 / 8;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (count <= 14 ) {
                    //draw imageOfFish
                    gp.iManage.setImage(gp.iManage.inventory[count]);
                    g2.drawImage(gp.iManage.inventory[count].fishFinalImage, imageAndBorderX, imageAndBorderY, gp.tileSize, gp.tileSize, null);

                    //draw border
                    g2.setColor(new Color(0xA26D48));
                    g2.setStroke(new BasicStroke(5));
                    g2.drawRoundRect(imageAndBorderX, imageAndBorderY, gp.tileSize + 1, gp.tileSize + 1, 15, 15);

                    //display amount
                    g2.setFont(font2);
                    g2.setColor(Color.BLACK);
                    g2.drawString(String.valueOf(gp.iManage.inventory[count].count), amountX, amountY);

                    imageAndBorderX += gp.tileSize * 3/2;
                    amountX += gp.tileSize * 3 / 2;
                    count++;
                }
            }
            imageAndBorderX = gp.tileSize * 17/4;
            imageAndBorderY += gp.tileSize * 3 / 2;
            amountX = gp.tileSize * 81 / 16;
            amountY += gp.tileSize * 3 / 2;
        }
    }

    public void drawCursor() {
        final int xStart = gp.tileSize * 17/4;
        final int yStart = gp.tileSize * 9/2;

        int cursorX = xStart + (gp.tileSize * 3 / 2 * inventorySlotCol);
        int cursorY = yStart + (gp.tileSize * 3 / 2 * inventorySlotRow);

        g2.setColor(new Color(0xD46352));
        g2.drawRoundRect(cursorX, cursorY, gp.tileSize + 1, gp.tileSize + 1, 15, 15);
    }

    public void displayItemIsChosen() {
        int choose = 5 * inventorySlotRow + inventorySlotCol;
        if (gp.iManage.inventory[choose] != null) {
            // display fish chosen image
            g2.drawImage(gp.iManage.inventory[choose].fishFinalImage, gp.tileSize * 29 / 2, gp.tileSize * 3, gp.tileSize * 2, gp.tileSize * 2, null);
            g2.setFont(font4);
            FontMetrics fm = g2.getFontMetrics(g2.getFont());
            g2.setColor(new Color(0x7B342E));

            String text;

            if (gp.iManage.inventory[choose].caught == false) {
                text = "?";
            } else {
                text = gp.iManage.inventory[choose].name;
            }

            int textWidth = fm.stringWidth(text);
            int centerX = gp.tileSize * 55 / 4 + (gp.tileSize * 7 / 2 - textWidth) / 2;
            g2.drawString(text, centerX, gp.tileSize * 23 / 4); // draw name

            textWidth = fm.stringWidth("Count: " + gp.iManage.inventory[choose].count);
            centerX = gp.tileSize * 55 / 4 + (gp.tileSize * 7 / 2 - textWidth) / 2;
            g2.drawString("Count: " + gp.iManage.inventory[choose].count, centerX, gp.tileSize * 25 / 4); // draw amount


            if (gp.iManage.inventory[choose].caught == false) {
                text = "?";
            } else {
                text = gp.iManage.inventory[choose].fishRarity;
            }
            textWidth = fm.stringWidth(text);
            centerX = gp.tileSize * 55 / 4 + (gp.tileSize * 7 / 2 - textWidth) / 2;
            int y = gp.tileSize * 27 / 4;
            // draw rarity
            if (gp.iManage.inventory[choose].caught == false) {
                g2.setColor(new Color(0x7B342E));
                g2.drawString(text, centerX, y);
            } else {
                switch (text) {
                    case "COMMON":
                        g2.setColor(new Color(0x448713));
                        g2.drawString(text, centerX, y);
                        break;
                    case "UNCOMMON":
                        g2.setColor(new Color(0x0239BD));
                        g2.drawString(text, centerX, y);
                        break;
                    case "RARE":
                        g2.setColor(new Color(0x810081));
                        g2.drawString(text, centerX, y);
                        break;
                    case "LEGENDARY":
                        g2.setColor(new Color(0xFF7F3E));
                        g2.drawString(text, centerX, y);
                        break;
                }
            }
            g2.setColor(new Color(0xA26D48));
            g2.drawRoundRect(gp.tileSize * 29 / 2, gp.tileSize * 3, gp.tileSize * 2, gp.tileSize * 2, 15, 15);
                //Description
             y = gp.tileSize*29/4;
             desCollections = gp.iManage.inventory[choose].desCollections;
             setFontAndColor(font7,new Color(0x7B342E));
            for(String line: desCollections.split("\n")){
                g2.drawString(line, gp.tileSize*547/40, y);
                y += 20;
            }
        }
    }

    public void displayItemIsChosen1(){
        int choose = 5*inventorySlotRow + inventorySlotCol;
        //display fish chosen image
        g2.drawImage(gp.iManage.inventory[choose].fishFinalImage, gp.tileSize * 29/2, gp.tileSize * 3, gp.tileSize * 2, gp.tileSize * 2, null);
        int y = gp.tileSize*23/4;
        String name = gp.iManage.inventory[choose].name;
        String rarity = gp.iManage.inventory[choose].fishRarity;
        setFontAndColor(font4,new Color(0x7B322E));
        if(gp.iManage.inventory[choose].caught == false){
            int x = center("?",gp.tileSize * 29/2,gp.tileSize * 2);
            g2.drawString("?",x,y); y+= gp.tileSize*1/2;
            g2.drawString("Count: "+gp.iManage.inventory[choose].count,center("Count: "+gp.iManage.inventory[choose].count,gp.tileSize * 29/2,gp.tileSize * 2),y); y+= gp.tileSize*1/2;
            g2.drawString("?",x,y); y+= gp.tileSize*1/2;
            g2.drawString("?",x,y);
        }
        else{
            g2.drawString(name,center(name,gp.tileSize * 29/2,gp.tileSize * 2),y); y+= gp.tileSize*1/2;
            g2.drawString("Count: "+gp.iManage.inventory[choose].count,center("Count: "+gp.iManage.inventory[choose].count,gp.tileSize * 29/2,gp.tileSize * 2),y); y+= gp.tileSize*1/2;
            switch (rarity){
                case "COMMON":
                    g2.setColor(new Color(0x448713));
                    break;
                case "UNCOMMON":
                    g2.setColor(new Color(0x0239BD));
                    break;
                case "RARE":
                    g2.setColor(new Color(0x810081));
                    break;
                case "LEGENDARY":
                    g2.setColor(new Color(0xFF7F3E));
                    break;
            }
            g2.drawString(rarity,center(rarity,gp.tileSize * 29/2,gp.tileSize * 2),y); y+= gp.tileSize*1/2;
            desCollections = gp.iManage.inventory[choose].desCollections;
            setFontAndColor(font7,new Color(0x7B342E));
            for(String line: desCollections.split("\n")){
                g2.drawString(line, gp.tileSize*547/40, y);
                y += 20;
            }
        }
    }

    public void drawAfterFishingScreen() {
        drawFishingBackGround();
        drawFishingCaughtAndInformation();
    }

    public void drawFishingBackGround() {
        g2.drawImage(fishFrame, gp.tileSize, -2 * gp.tileSize, gp.tileSize * 18, gp.tileSize * 15, null);//0xFFBB5B FFAD7A
    //    drawSubWindow1(-5+gp.tileSize*19/2,-5+gp.tileSize*21/4,10+gp.tileSize*11/2,10+gp.tileSize*5/2,new Color(0,0,0,0),new Color(0xFFFFFF),2,10); ed9b68
    //    drawSubWindow1(-10+gp.tileSize*9/2,-10+gp.tileSize*5/2,20+gp.tileSize*11,gp.tileSize*15/2,new Color(0xe078ff),new Color(0x9D57A6),5,70);
    //    drawSubWindow1(-10+gp.tileSize*9/2,-10+gp.tileSize*5/2,20+gp.tileSize*11,gp.tileSize*285/40,new Color(0xffd59b),new Color(0x9D57A6),5,70);
        drawSubWindow1(gp.tileSize*19/2,gp.tileSize*21/4,gp.tileSize*11/2,gp.tileSize*3,new Color(0xFFBB5B),new Color(0xFFBB5B),0,0);
    }

    public void drawFishingCaughtAndInformation() {
        //draw image of fish caught
        g2.drawImage(fishImage, 6 * gp.tileSize, gp.tileSize * 9 / 2, gp.tileSize * 5 / 2, gp.tileSize * 5 / 2, null);
        drawSubWindow1 (-10 + 6 * gp.tileSize, -10 + gp.tileSize * 9 / 2, 15 + gp.tileSize * 5 / 2, 15 + gp.tileSize * 5 / 2, new Color(0, 0, 0, 0), new Color(0xD69489), 7, 20);
        //display fish information
        //Rarity
        switch (fishRarity) {
            case "LEGENDARY":
                setFontAndColor(font, Color.BLACK);
                g2.drawString(fishRarity, getXforCenteredText(fishRarity), gp.tileSize * 5 / 2);
                setFontAndColor(font, new Color(0xFF7F3E));
                g2.drawString(fishRarity, -2 + getXforCenteredText(fishRarity), -2 + gp.tileSize * 5 / 2);
                break;
            case "RARE":
                setFontAndColor(font, Color.WHITE);
                g2.drawString(fishRarity, getXforCenteredText(fishRarity), gp.tileSize * 5 / 2);
                setFontAndColor(font, new Color(0x810081));
                g2.drawString(fishRarity, -2 + getXforCenteredText(fishRarity), -2 + gp.tileSize * 5 / 2);
                break;
            case "UNCOMMON":
                setFontAndColor(font, new Color(0xFFFFFF));
                g2.drawString(fishRarity, getXforCenteredText(fishRarity), gp.tileSize * 5 / 2);
                setFontAndColor(font, new Color(0x0239BD));
                g2.drawString(fishRarity, -2 + getXforCenteredText(fishRarity), -2 + gp.tileSize * 5 / 2);
                break;
            case "COMMON":
                setFontAndColor(font, new Color(0xFFFFFF));
                g2.drawString(fishRarity, getXforCenteredText(fishRarity), gp.tileSize * 5 / 2);
                setFontAndColor(font, new Color(0x448713));
                g2.drawString(fishRarity, -2 + getXforCenteredText(fishRarity), -2 + gp.tileSize * 5 / 2);
                break;
            case "TRASH":
                setFontAndColor(font, new Color(0xFFFFFF));
                g2.drawString(fishRarity, getXforCenteredText(fishRarity), gp.tileSize * 5 / 2);
                setFontAndColor(font, new Color(0x434343));
                g2.drawString(fishRarity, -2 + getXforCenteredText(fishRarity), -2 + gp.tileSize * 5 / 2);
                break;


        }
        //Name
        setFontAndColor(font5, new Color(0x7B342E));
        g2.drawString(fishName, center(fishName, gp.tileSize * 6, gp.tileSize * 5 / 2), gp.tileSize * 8);
        //Price
        int x = gp.tileSize * 23/2;
        int y = -10 + gp.tileSize * 5;
        setFontAndColor(font1, new Color(0x7B342E));
        g2.drawString("Price: " + fishPrice, x, y);
        //Description
        y = gp.tileSize * 6;
        x =  gp.tileSize * 10;

        setFontAndColor(font4a,new Color(0x7B342E));
        for(String line: desFishing.split("\n")){
            g2.drawString(line, x, y);
            y += 32;
        }
    }


    public int center(String s, int imageX, int imageWidth) {
        int textWidth = (int) g2.getFontMetrics().getStringBounds(s, g2).getWidth();
        return imageX + (imageWidth - textWidth) / 2;
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        //BACKGROUND
        Color c = new Color(0, 0, 0, 210); //OPACITY
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        //BORDER
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(7));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }

    public void setFontAndColor(Font f, Color c) {
        g2.setColor(c);
        g2.setFont(f);
    }

    public void drawSubWindow1(int x, int y, int width, int height, Color cbg, Color cs, int strokeSize, int arc) {
        g2.setColor(cbg);
        g2.fillRoundRect(x, y, width, height, arc,arc );
        g2.setColor(cs);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.drawRoundRect(x , y , width , height, arc, arc);
    }

    //Trade UI
    public void drawTradeInventory(Entity entity, boolean cursor){

        int frameX = 0;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;

        if(entity == gp.player){
            frameX = gp.tileSize*12;
            frameY = gp.tileSize;
            frameWidth = gp.tileSize*6;
            frameHeight = gp.tileSize*5;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;
        }else {
            frameX = gp.tileSize*2;
            frameY = gp.tileSize;
            frameWidth = gp.tileSize*6;
            frameHeight = gp.tileSize*5;
            slotCol = npcSlotCol;
            slotRow = npcSlotRow;
        }

        //Frame
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //Slot
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY= slotYstart;
        int slotSize = gp.tileSize+3;

        //Draw Player's Items
        for(int i = 0; i < entity.inventory.size(); i++){

            g2.drawImage(entity.inventory.get(i).down2, slotX, slotY, null);

            //Display amount
            if(entity == gp.player && entity.inventory.get(i).amount > 1){

                g2.setFont(g2.getFont().deriveFont(32f));
                int amountX;
                int amountY;

                String s = "" + entity.inventory.get(i).amount;
                amountX = getXforAlignToRightText(s, slotX + 44);
                amountY = slotY + gp.tileSize;

                //Shadow
                g2.setColor(new Color(60,60,60));
                g2.drawString(s, amountX+10, amountY);
                //Number
                g2.setColor(Color.WHITE);
                g2.drawString(s, amountX+7, amountY-3);
            }

            slotX += slotSize;

            if(i == 4 || i == 9 || i == 14){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //Cursor
        if(cursor == true){
            int cursorX = slotXstart + (slotSize * slotCol);
            int cursorY = slotYstart + (slotSize * slotRow);
            int cursorWidth = gp.tileSize;
            int cursorHeight = gp.tileSize;

            //Draw Cursor
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

            //Description Frame
            int dFrameX = frameX;
            int dFrameY = frameY + frameHeight;
            int dFrameWidth  = frameWidth;
            int dFrameHeight  = gp.tileSize*3;


            //Description Text
            int textX = dFrameX + 20;
            int textY = dFrameY + gp.tileSize * 3/4;
            g2.setFont(g2.getFont().deriveFont(28F));

            int itemIndex = getItemIndexOnSlot(slotCol,slotRow);

            if(itemIndex < entity.inventory.size()){
                drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
                setFontAndColor(font4,Color.WHITE);
                g2.drawString(fishName,textX,textY);
                textY += 30;
                setFontAndColor(font3a,Color.WHITE);
                for(String line: entity.inventory.get(itemIndex).desTrading.split("\n")){
                    g2.drawString(line, textX, textY);
                    textY += 20;
                }
                g2.setFont(g2.getFont().deriveFont(28F));
            }
        }
    }

    public void drawTradeScreen(){

        switch (subState){
            case 0: trade_select(); break;
            case 1: trade_buy(); break;
            case 2: trade_sell(); break;
        }
        gp.keyHandler.enterPressed = false;
    }
    public void trade_select(){
        drawDialogueScreen();

        //Draw
        int x = gp.tileSize*15;
        int y = gp.tileSize*4;
        int width = gp.tileSize * 3;
        int height = (int) (gp.tileSize * 3.5);
        drawSubWindow(x,y,width,height);

        //DrawText
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString("Buy",x,y);
        if(commandNum == 0){
            g2.drawString(">", x-24,y);
            if(gp.keyHandler.enterPressed == true){
                subState = 1;
            }
        }


        y += gp.tileSize;
        g2.drawString("Sell",x,y);
        if(commandNum == 1){
            g2.drawString(">", x-24,y);
            if(gp.keyHandler.enterPressed == true){
                subState = 2;
            }
        }


        y += gp.tileSize;
        g2.drawString("Leave",x,y);
        if(commandNum == 2){
            g2.drawString(">", x-24,y);
            if(gp.keyHandler.enterPressed == true){
                commandNum = 0;
                gp.gameState = gp.playState;
            }
        }

    }
    public void trade_buy(){
        //Player Inventory
        drawTradeInventory(gp.player, false);
        //NPC Inventory
        drawTradeInventory(npc, true);
        //Hint Window
        int x = gp.tileSize*2;
        int y = gp.tileSize*9;
        int width = gp.tileSize*6;
        int height = gp.tileSize*2;
        drawSubWindow(x,y,width,height);
        g2.drawString("[ESC] Back", x+24, y+60);
        //Player Coin Window
        x = gp.tileSize*12;
        y = gp.tileSize*9;
        width = gp.tileSize*6;
        height = gp.tileSize*2;
        drawSubWindow(x,y,width,height);
        g2.drawString("Your coin: " + gp.player.coin, x+24, y+60);
        //Price Window
        int itemIndex = getItemIndexOnSlot(npcSlotCol,npcSlotRow);
        if(itemIndex < npc.inventory.size()){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,38F));

            x = (int) (gp.tileSize*5.5);
            y = (int) (gp.tileSize*5.5);
            width = (int) (gp.tileSize*2.5);
            height = gp.tileSize;
            drawSubWindow(x,y,width,height);
            g2.drawImage(coin, x+10, y+10, 40, 40, null);

            int price = npc.inventory.get(itemIndex).price;
            String text = "" + price;
            x = getXforAlignToRightText(text, gp.tileSize*8);
            g2.drawString(text, x-28, y+45);

            //Buy an item
            if(gp.keyHandler.enterPressed == true){
                if(npc.inventory.get(itemIndex).price > gp.player.coin){
                    subState = 0;
                    gp.gameState = gp.dialogueState;
                    currentDialogue = "You need more coin to buy that!";
                    drawDialogueScreen();
                }else{
                    if(gp.player.canObtainItem(npc.inventory.get(itemIndex)) == true){
                        gp.player.coin -= npc.inventory.get(itemIndex).price;
                    }
                    else{
                        subState = 0;
                        gp.gameState = gp.dialogueState;
                        currentDialogue = "You cannot carry any more!";

                    }
                }
            }

        }
    }
    public void trade_sell(){
        //Player Inventory
        drawTradeInventory(gp.player, true);

        //Hint Window
        int x = gp.tileSize*2;
        int y = gp.tileSize*9;
        int width = gp.tileSize*6;
        int height = gp.tileSize*2;
        drawSubWindow(x,y,width,height);
        g2.drawString("[ESC] Back", x+24, y+60);
        //Player Coin Window
        x = gp.tileSize*12;
        y = gp.tileSize*9;
        width = gp.tileSize*6;
        height = gp.tileSize*2;
        drawSubWindow(x,y,width,height);
        g2.drawString("Your coin: " + gp.player.coin, x+24, y+60);
        //Price Window
        int itemIndex = getItemIndexOnSlot(playerSlotCol,playerSlotRow);
        if(itemIndex < gp.player.inventory.size()){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,38F));

            x = (int) (gp.tileSize*15.5);
            y = (int) (gp.tileSize*5.5);
            width = (int) (gp.tileSize*2.5);
            height = gp.tileSize;
            drawSubWindow(x,y,width,height);
            g2.drawImage(coin, x+10, y+10, 40, 40, null);

            int price = gp.player.inventory.get(itemIndex).price;
            String text = "" + price;
            x = getXforAlignToRightText(text, gp.tileSize*18);
            g2.drawString(text, x-28, y+45);

            //Sell an item
            if(gp.keyHandler.enterPressed == true){

//                if(gp.player.inventory.get(itemIndex) == gp.player.currentWeapon || gp.player.inventory.get(itemIndex) == gp.player.currentShield){
//                    commandNum = 0;
//                    subState = 0;
//                    gp.gameState = gp.dialogueState;
//                    currentDialogue = "You cannot sell an equipped item!";
//                }else {
                if(gp.player.inventory.get(itemIndex).amount > 1){
                    gp.player.inventory.get(itemIndex).amount--;
                }else{
                    gp.player.inventory.remove(itemIndex);
                }
                gp.player.coin += price;
//                }

            }

        }
    }
    public int getItemIndexOnSlot(int slotCol, int slotRow){
        int itemIndex = slotCol + (slotRow*5);
        return itemIndex;
    }
    public int getXforAlignToRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = tailX - length;
        return x;
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