package entity;

import Main.GamePanel;
import Main.KeyHandler;
import object.OBJ_FishingRod1;
import object.OBJ_FishingRod2;
import tile.TileManager;
import object.Fishing_Rod;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Player extends Entity {
    KeyHandler key;
    TileManager tileM;

    public double screenX;
    public double screenY;
    public final double worldX_fishTank = 0;
    public final double worldY_fishTank = 0;
    public double temp_worldX;
    public double temp_worldY;
    private int objIndex;
    public int interactEntity_Index;
    public int rod = 3;
    public ArrayList<Entity> interactEntity;
    public Fishing_Rod fishingRod;
    //INDEX
    private int npcIndex, animalIndex, iTileIndex;
  

    public Player(GamePanel gp, KeyHandler key, TileManager tileM) {
        super(gp);
        this.key = key;
        this.tileM = tileM;
        size = gp.tileSize + 10;

        fishingRod = new Fishing_Rod(gp, this, key);
        fishingRod.setLevel(rod);

        screenX = (double) gp.screenWidth / 2 - ((double) gp.tileSize / 2); //set the player at then center of the screen
        screenY = (double) gp.screenHeight / 2 - ((double) gp.tileSize / 2);

        setDefaultValues();
        setItems();
        interactEntity = new ArrayList<>();

        //AREA COLLISION
        solidArea = new Rectangle();
        solidArea.x = (8 * gp.tileSize) / 48;
        solidArea.y = (16 * gp.tileSize) / 48;
        solidArea.width = (32 * gp.tileSize) / 48;
        solidArea.height = (32 * gp.tileSize) / 48;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        direction = "down";
    }

    public void setPlayerImage(String playerType) {
        if (playerType.equals("Human")) {
            getPlayerImage_HumanVer();
        } else
            getPlayerImage_DinoVer();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 10;
        worldY = gp.tileSize * 7;
        speed = (double) gp.worldWidth / 400;
        direction = "standDown";

        //PLAYER STATUS
        maxPhysical = 16;
        physical = maxPhysical;
        coin = 500;
        currentFishingRod = new OBJ_FishingRod1(gp);
    }

    public void setItems() {
        inventory.add(currentFishingRod);

    }

    public void getPlayerImage_DinoVer() {
        standUp = setup("player/dino_up_1", 16, 16);
        standDown = setup("player/dino_down_1", 16, 16);
        standRight = setup("player/dino_down_1", 16, 16);
        standLeft = setup("player/dino_up_1", 16, 16);
        up1 = setup("player/dino_up_1", 16, 16);
        up2 = setup("player/dino_up_2", 16, 16);
        down1 = setup("player/dino_down_1", 16, 16);
        down2 = setup("player/dino_down_2", 16, 16);
        left1 = setup("player/dino_left_1", 16, 16);
        left2 = setup("player/dino_left_2", 16, 16);
        right1 = setup("player/dino_right_1", 16, 16);
        right2 = setup("player/dino_right_2", 16, 16);
    }

    public void getPlayerImage_HumanVer() {
        standUp = setup("player/standUp", 32, 32);
        standDown = setup("player/standDown", 32, 32);
        standRight = setup("player/right", 32, 32);
        standLeft = setup("player/left", 32, 32); 
        up1 = setup("player/up_1", 32, 32);
        up2 = setup("player/up_2", 32, 32);
        down1 = setup("player/down_1", 32, 32);
        down2 = setup("player/down_2", 32, 32);
        left1 = setup("player/left_1", 32, 32);
        left2 = setup("player/left_2", 32, 32);
        right1 = setup("player/right_1", 32, 32);
        right2 = setup("player/right_2", 32, 32);
    }

    public void update() {
        if (key.downPressed || key.upPressed || key.leftPressed || key.rightPressed) {
            if (key.upPressed) {
                direction = "up";
            } else if (key.downPressed) {
                direction = "down";
            } else if (key.leftPressed) {
                direction = "left";
            } else {
                direction = "right";
            }
            // SET SOUND
            setTileSound(tileM);
        } else {
            if (Objects.equals(direction, "up")) {
                direction = "standUp";
            } else if (Objects.equals(direction, "down")) {
                direction = "standDown";
            } else if (Objects.equals(direction, "right")) {
                direction = "standRight";
            } else if (Objects.equals(direction, "left")) {
                direction = "standLeft";
            }
            // STOP SOUND
            gp.stopMusic("grass");
        }
        
        //UPDATE the solidArea due to zoom in and out
        solidArea.x = (10 * gp.tileSize) / 48;
        solidArea.y = (20 * gp.tileSize) / 48;
        solidArea.width = (30 * gp.tileSize) / 48;
        solidArea.height = (35 * gp.tileSize) / 48;

        //CHECK AUTO DISPLAY
        if (!interactEntity.contains(gp.npc[0].get(0))) {
            interactEntity.add(gp.npc[0].get(0));
        }
        if (!interactEntity.contains(gp.animal[0].get(4))) {
            interactEntity.add(gp.animal[0].get(4));
        }

        interactEntity_Index = checkNear(interactEntity);

        if (interactEntity_Index <= interactEntity.size()) {
            messageOn(interactEntity.get(interactEntity_Index));
        }

        //CHECK INTERACT TILE COLLISION
        iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
        hitInteractiveTile(iTileIndex);

        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this, false);

        //CHECK OBJ COLLISION
        objIndex = gp.cChecker.checkObj(this, true);
//        pickUpObject(objIndex);

        //CHECK NPC COLLISION
        npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //CHECK ANIMAL COLLISION
        animalIndex = gp.cChecker.checkEntity(this, gp.animal);


//        //CHECK TO OPEN DOOR
//        checkAtSpecifiedPst(0);
        
        // update fishing rod
        fishingRod.update();

        //CHECK EVENT
        gp.eHandler.checkEvent(rod);
        

        //CHECK IF AT EDGE
        gp.cChecker.checkAtEdge(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (!collisionOn) {
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
            }
        }

        spriteCounter++;
        if (spriteCounter > 15) {
            spriteNum = (spriteNum == 2) ? 1 : 2;
            spriteCounter = 0;
        }
    }

//    public void pickUpObject(int i) {
//        if (i != 999) {
//            String objectName = gp.obj[i].name;
//            if (objectName.equals("Door close")) {
//                gp.aSetter.setDoorStatus(false);
//            }
//        } else
//            gp.aSetter.setDoorStatus(true);
//    }

    public void hitInteractiveTile(int i) {
        if (i != 999 && !gp.iTile[0].get(i).isOpen) {
            gp.playSoundEffect("Door open", 4);
            gp.iTile[0].add(gp.iTile[0].get(i).getInteractedForm());
            gp.iTile[0].remove(i);
        }
        if (i == 999) {
            if (!gp.iTile[0].contains(gp.iTile[0].get(0).getInteractedForm()) && gp.iTile[0].get(0).name.equals("Door Open")) {
                gp.playSoundEffect("Door close", 5);
                gp.iTile[0].add(gp.iTile[0].get(0).getInteractedForm());
                gp.iTile[0].remove(0);
            }
        }
    }

    public void interactNPC(int i) {
        if (i != 999) {
            if (gp.keyHandler.enterPressed) {
                gp.gameState = gp.dialogueState;
                gp.npc[gp.currentMap].get(i).speak();
            }
        }
        gp.keyHandler.enterPressed = false;
    }

    private void setTileSound(TileManager tileM) {
        //getPLayerCol and Row at the center point of player
        int playerCol = (int) ((worldX + gp.tileSize / 2) / gp.tileSize);
        int playerRow = (int) ((worldY + gp.tileSize / 2) / gp.tileSize);
        int tileIndex = tileM.mapTileNum[gp.currentMap][playerRow][playerCol];

        if (tileIndex > 0 && tileIndex < 27 && tileIndex != 16 && tileIndex != 17 && tileIndex != 18) {
            gp.playMusic("grass", 1);
        } else {
            gp.stopMusic("grass");
        }
    }

    public void messageOn(Entity target) {
        if (gp.gameState == gp.autoDisplayState) {
            switch (target.name) {
                case "old man":
                    if (gp.keyHandler.enterPressed) {
                        gp.gameState = gp.dialogueState;
                        target.speak();
                        gp.playSoundEffect("oldMan", 3);
                    } else {
                        gp.stopMusic("oldMan");
                    }
                    break;
                case "Cow":
                    if (gp.keyHandler.enterPressed) {
                        // gp.gameState = gp.dialogueState;
                        target.speak();
                    }
                    break;
            }
        }
        gp.keyHandler.enterPressed = false;
    }

    public int checkNear(ArrayList<Entity> target) {
        int playerCol = (int) ((worldX + gp.tileSize / 2) / gp.tileSize);
        int playerRow = (int) ((worldY + gp.tileSize / 2) / gp.tileSize);
        int targetCol;
        int targetRow;
        for (int i = 0; i < target.size(); i++) {
            targetCol = (int) (target.get(i).worldX / gp.tileSize);
            targetRow = (int) (target.get(i).worldY / gp.tileSize);

            if (playerCol == targetCol && playerRow - 1 == targetRow) {
                gp.gameState = gp.autoDisplayState;
                return i;
            } else if (playerCol == targetCol && playerRow + 1 == targetRow) {
                gp.gameState = gp.autoDisplayState;
                return i;
            } else if (playerCol + 1 == targetCol && playerRow == targetRow) {
                gp.gameState = gp.autoDisplayState;
                return i;
            } else if (playerCol - 1 == targetCol && playerRow == targetRow) {
                gp.gameState = gp.autoDisplayState;
                return i;
            } else {
                gp.gameState = gp.playState;
            }
        }
        return 999;
    }

    public boolean canObtainItem(Entity item) {
        boolean canContain = false;

        //Check if stackable
        if (item.stackable == true) {
            int index = searchItemInInventory(item.name);

            if (index != 999) {
                inventory.get(index).amount++;
                canContain = true;
            } else {
                //New item so need to track vacancy
                if (inventory.size() != maxInventorySize) {
                    inventory.add(item);
                    canContain = true;
                }
            }
        } else {
            //Not stackable so check vacancy
            if (inventory.size() != maxInventorySize) {
                inventory.add(item);
                canContain = true;
            }
        }
        return canContain;
    }

    public int searchItemInInventory(String itemName) {
        int itemIndex = 999;

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equals(itemName)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public void draw(Graphics2D g) {
//        g.setColor(Color.white);
//        g.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                fishingRod.reset();
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                fishingRod.reset();
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                fishingRod.reset();
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                fishingRod.reset();
                break;
            case "standUp":
                image = standUp;
                break;
            case "standDown":
                image = standDown;
                break;
            case "standRight":
                image = standRight;
                break;
            case "standLeft":
                image = standLeft;
                break;
        }

        //STOP MOVING THE CAMERA AT EDGE (PLAYER CAN NOT MOVE IF AT EDGE)
        double x = screenX;
        double y = screenY;
        //TOP
        if (gp.player.screenX >= worldX) {
            x = worldX;
        }
        //LEFT
        if (gp.player.screenY >= worldY) {
            y = worldY;
        }
        //RIGHT
        double rightOffSet = gp.screenWidth - screenX;
        if (rightOffSet >= gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        //BOTTOM
        double bottomOffSet = gp.screenHeight - screenY;
        if (bottomOffSet >= gp.worldHeight - worldY) {
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ////////////////////////
        if(fishingRod.getFrame() != null){
            image = fishingRod.getFrame();
            g.drawImage(image, (int) (x - ( this.direction=="standLeft" ? (size) : 0)), (int) y, null);
        }
        else 
        g.drawImage(image, (int) x, (int) y, size, size, null);

    }
}
