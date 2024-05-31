package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, spacePressed, fPressed;
    public boolean AnnouceCompleteAnimation;
    // DEBUG
    boolean checkDrawTime = false;
    GamePanel gp;
    public boolean isMove = false;
    int temp_map;
    double temp_woldX, temp_woldY;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        isMove = true;
        int key = e.getKeyCode();

        // TITTLE STATE

        if (gp.gameState == gp.tittleState) {
            tittleState(key);
        }

        if (gp.gameState == gp.selectPlayerState) {
            selectPlayerState(key);
        }
        if (gp.currentMap == 0) {
            // PLAY STATE
            if (gp.gameState == gp.playState || gp.gameState == gp.autoDisplayState) {
                gamePlayerState(key);
            }

            // DIALOG STATE
            else if (gp.gameState == gp.dialogueState) {
                dialogState(key);
            }

            // NOTIFICATION STATE
            else if (gp.gameState == gp.notificationState) {
                notificationState(key);
            }

            // OPTIONS STATE
            else if (gp.gameState == gp.optionState) {
                optionState(key);
            }

            // FISHING STATE
            else if (gp.gameState == gp.fishingState) {
                fishingState(key);
            }

            // AFTER FISHING STATE
            else if (gp.gameState == gp.afterFishingState) {
                afterFishingState(key);
            }

            // COLLECTION STATE
            else if (gp.gameState == gp.collectionState) {
                collectionState(key);
            } else if (gp.gameState == gp.inventoryState) {
                inventoryState(key);
            }
            // TRADE STATE
            else if (gp.gameState == gp.tradeState) {
                tradeState(key);
            }
            // Feed Cow State
            else if (gp.gameState == gp.feedCowState) {
                feedCowState(key);
            }

            // Feed Cow Yes State
            else if (gp.gameState == gp.feedCowYesState) {
                feedCowYesState(key);
              
            // Game Over State
            else if (gp.gameState == gp.gameOverState) {
                gameOverState(key);

            }
        } else if (gp.currentMap == 1) {
            gameFishTankState(key);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isMove = false;
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (key == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (key == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (key == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
        if (key == KeyEvent.VK_F) {
            fPressed = false;
        }
    }

    public void tittleState(int key) {
        if (key == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            gp.playSoundEffect("select_sound", 6);
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 2;
            }
        }
        if (key == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            gp.playSoundEffect("select_sound", 6);
            if (gp.ui.commandNum > 2) {
                gp.ui.commandNum = 0;
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 0) {
                gp.playSoundEffect("click_sound", 7);
                gp.gameState = gp.selectPlayerState;
            }
            if (gp.ui.commandNum == 1) {
                // add later
            }
            if (gp.ui.commandNum == 2) {
                System.exit(0);
            }
        }
    }

    public void selectPlayerState(int key) {
        if (key == KeyEvent.VK_A) {
            gp.ui.commandNum--;
            gp.playSoundEffect("select_sound", 6);
            if (gp.ui.commandNum < 1) {
                gp.ui.commandNum = 2;
            }
        }
        if (key == KeyEvent.VK_D) {
            gp.ui.commandNum++;
            gp.playSoundEffect("select_sound", 6);
            if (gp.ui.commandNum > 2) {
                gp.ui.commandNum = 1;
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 1) {
                gp.playSoundEffect("click_sound", 7);
                gp.player.setPlayerImage("Human");
                gp.gameState = gp.playState;
            } else if (gp.ui.commandNum == 2) {
                gp.playSoundEffect("click_sound", 7);
                gp.player.setPlayerImage("Dino");
                gp.gameState = gp.playState;
            }
            gp.ui.commandNum = 0;

        }
    }

    public void gamePlayerState(int key) {
        if (key == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (key == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (key == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (key == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (key == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }
        if (key == KeyEvent.VK_F) {
            fPressed = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.optionState;
            gp.music.stop("Bird");
            gp.music.stop("Background");
        }

        if (key == KeyEvent.VK_H) {
            gp.player.physical = gp.player.maxPhysical;
        }
        if (key == KeyEvent.VK_C) {
            gp.gameState = gp.collectionState;
        }
        if (key == KeyEvent.VK_B) {
            gp.gameState = gp.inventoryState;
        }
        if (key == KeyEvent.VK_L) {
            gp.gameState = gp.transitionState;
            temp_map = 1;
            temp_woldX = 0;
            temp_woldY = 0;

            gp.player.temp_worldX = gp.player.worldX;
            gp.player.temp_worldY = gp.player.worldY;
        }

        // DEBUG
        if (key == KeyEvent.VK_T) {
            checkDrawTime = (checkDrawTime == true) ? false : true;
        }
    }

    public void gameFishTankState(int key) {
        if (key == KeyEvent.VK_ESCAPE) {
            gp.animal[1].clear();

            temp_woldX = gp.player.temp_worldX;
            temp_woldY = gp.player.temp_worldY;

            gp.gameState = gp.transitionState;
            temp_map = 0;
        }
    }

    public void dialogState(int key) {
        if (key == KeyEvent.VK_ENTER) {
            if (gp.npc[gp.currentMap].get(0).dialogueIndex < gp.npc[gp.currentMap].get(0).dialogues.length) {
                gp.npc[gp.currentMap].get(0).speak();
            }
        }
    }

    public void notificationState(int key) {
        if (key == KeyEvent.VK_SPACE) {
            gp.player.fishingRod.reset();
            gp.gameState = gp.playState;
        }
    }

    public void optionState(int key) {
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.playState;
            gp.ui.subState = 0;
        }
        if (key == KeyEvent.VK_ENTER) {
            enterPressed = true;
            gp.playSoundEffect("click_sound", 7);
        }
        int maxCommandNum;
        switch (gp.ui.subState) {
            case 0:
                maxCommandNum = 5;
                if (key == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    gp.playSoundEffect("select_sound", 6);
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = maxCommandNum;
                    }
                }
                if (key == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    gp.playSoundEffect("select_sound", 6);
                    if (gp.ui.commandNum > maxCommandNum) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (key == KeyEvent.VK_A) {
                    if (gp.ui.subState == 0) {
                        if (gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
                            gp.music.volumeScale--;
                            gp.music.checkVolume();
                            gp.playSoundEffect("select_sound", 6);
                        }
                        if (gp.ui.commandNum == 2 && gp.soundEffect.volumeScale > 0) {
                            gp.soundEffect.volumeScale--;
                            gp.playSoundEffect("select_sound", 6);
                        }
                    }
                }
                if (key == KeyEvent.VK_D) {
                    if (gp.ui.subState == 0) {
                        if (gp.ui.commandNum == 1 && gp.music.volumeScale >= 0) {
                            if (gp.music.volumeScale < 5) {
                                gp.music.volumeScale++;
                            }
                            gp.music.checkVolume();
                            gp.playSoundEffect("select_sound", 6);
                        }
                        if (gp.ui.commandNum == 2 && gp.soundEffect.volumeScale >= 0) {
                            if (gp.soundEffect.volumeScale < 5) {
                                gp.soundEffect.volumeScale++;
                            }
                            gp.playSoundEffect("select_sound", 6);
                        }
                    }
                }
                break;
            case 3:
                maxCommandNum = 1;
                if (key == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    gp.playSoundEffect("select_sound", 6);
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = maxCommandNum;
                    }
                }
                if (key == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    gp.playSoundEffect("select_sound", 6);
                    if (gp.ui.commandNum > maxCommandNum) {
                        gp.ui.commandNum = 0;
                    }
                }
        }
    }

    public void fishingState(int key) {
        if (key == KeyEvent.VK_SPACE) {

//            gp.ui.completion += 10;
//            if (gp.ui.completion >= 100) {
//                gp.ui.completion = 0;
//                gp.inventoryMng.Fishing(gp.player.rod);
//                gp.gameState = gp.afterFishingState;
//            }w
            if ((gp.ui.target_Y + gp.tileSize / 2) >= gp.ui.range_Y && (gp.ui.target_Y + gp.tileSize / 2) <= (gp.ui.range_Y + gp.ui.heightOfRange)) {
                gp.collectionM.Fishing(gp.player.currentFishingRod.rod);

                gp.gameState = gp.afterFishingState;
            } else {
                gp.gameState = gp.notificationState;
                gp.ui.currentTittle = "OOPS!";
                gp.ui.currentNotification = "The fish got away! :((";
            }
        }
    }

    public void afterFishingState(int key) {
        if (key == KeyEvent.VK_ENTER) {
            gp.player.fishingRod.reset();
            gp.gameState = gp.playState;
        }
    }

    public void collectionState(int key) {
        if (key == KeyEvent.VK_D) {
            if (gp.ui.collectionSlotCol != 3) {
                gp.ui.collectionSlotCol++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gp.ui.collectionSlotCol != 0) {
                gp.ui.collectionSlotCol--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_W) {
            if (gp.ui.collectionSlotRow != 0) {
                gp.ui.collectionSlotRow--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_S) {
            if (gp.ui.collectionSlotRow != 3) {
                gp.ui.collectionSlotRow++;
                gp.playSoundEffect("select_sound", 6);
            }

        } else if (key == KeyEvent.VK_C || key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.playState;
        }
    }

    public void inventoryState(int key) {
        if (key == KeyEvent.VK_D) {
            if (gp.ui.inventorySlotCol != 4) {
                gp.ui.inventorySlotCol++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gp.ui.inventorySlotCol != 0) {
                gp.ui.inventorySlotCol--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_W) {
            if (gp.ui.inventorySlotRow != 0) {
                gp.ui.inventorySlotRow--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_S) {
            if (gp.ui.inventorySlotRow != 3) {
                gp.ui.inventorySlotRow++;
                gp.playSoundEffect("select_sound", 6);
            }

        } else if (key == KeyEvent.VK_B || key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.playState;
        }
    }

    public void tradeState(int key) {
        if (key == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        if (gp.ui.subState == 0) {
            if (key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
                gp.playSoundEffect("select_sound", 6);
            }
            if (key == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (gp.ui.subState == 1) {
            tradeNpcInventory(key);
            if (key == KeyEvent.VK_ESCAPE) {
                gp.ui.subState = 0;
            }
        }
        if (gp.ui.subState == 2) {
            tradePlayerInventory(key);
            if (key == KeyEvent.VK_ESCAPE) {
                gp.ui.subState = 0;
            }
        }
    }

    public void feedCowState(int key) {
        if (key == KeyEvent.VK_ESCAPE)
            gp.gameState = gp.playState;
        if (key == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if (key == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 1;
            }
            gp.playSoundEffect("select_sound", 6);
        }
        if (key == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 1) {
                gp.ui.commandNum = 0;
            }
            gp.playSoundEffect("select_sound", 6);
        }
    }

    public void feedCowYesState(int key) {
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.playState;
        }

        if (key == KeyEvent.VK_ENTER) {
            gp.gameState = gp.feedCowYesState;
        }
    }

    public void tradePlayerInventory(int key) {
        if (key == KeyEvent.VK_W) {
            if (gp.ui.playerSlotRow != 0) {
                gp.ui.playerSlotRow--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_S) {
            if (gp.ui.playerSlotRow != 3) {
                gp.ui.playerSlotRow++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gp.ui.playerSlotCol != 0) {
                gp.ui.playerSlotCol--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_D) {
            if (gp.ui.playerSlotCol != 4) {
                gp.ui.playerSlotCol++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
    }

    public void tradeNpcInventory(int key) {
        if (key == KeyEvent.VK_W) {
            if (gp.ui.npcSlotRow != 0) {
                gp.ui.npcSlotRow--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_S) {
            if (gp.ui.npcSlotRow != 3) {
                gp.ui.npcSlotRow++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gp.ui.npcSlotCol != 0) {
                gp.ui.npcSlotCol--;
                gp.playSoundEffect("select_sound", 6);
            }
        }
        if (key == KeyEvent.VK_D) {
            if (gp.ui.npcSlotCol != 4) {
                gp.ui.npcSlotCol++;
                gp.playSoundEffect("select_sound", 6);
            }
        }
    }

    public void gameOverState(int key){

        if (key == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 1;
            }
            gp.playSoundEffect("select_sound", 6);
        }
        if (key == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 1) {
                gp.ui.commandNum = 0;
            }
            gp.playSoundEffect("select_sound", 6);
        }
        if(key == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
                gp.restart();
            }
            else if(gp.ui.commandNum == 1){
                gp.gameState = gp.tittleState;
            }
        }

    }

    // @Override
    // public void mouseWheelMoved(MouseWheelEvent e) {
    // int scroll = e.getWheelRotation();
    // if (scroll < 0) {
    // gp.zoomInOut(2);
    // } else {
    // gp.zoomInOut(-2);
    // }
    // }
}
