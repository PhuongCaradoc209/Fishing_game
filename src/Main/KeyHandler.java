package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, spacePressed;
    //DEBUG
    boolean checkDrawTime = false;
    GamePanel gp;
    public boolean isMove = false;

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
        //TITTLE STATE
        if (gp.gameState == gp.tittleState) {
            tittleState(key);
        }

        if (gp.gameState == gp.selectPlayerState) {
            selectPlayerState(key);
        }

        //PLAY STATE
        else if (gp.gameState == gp.playState || gp.gameState == gp.autoDisplayState) {
            gameState(key);
        }

        //DIALOG STATE
        else if (gp.gameState == gp.dialogueState) {
            dialogState(key);
        }

        //NOTIFICATION STATE
        else if (gp.gameState == gp.notificationState) {
            notificationState(key);
        }

        //OPTIONS STATE
        else if (gp.gameState == gp.optionState) {
            optionState(key);
        }

        //FISHING STATE
        else if (gp.gameState == gp.fishingState) {
            fishingState(key);
        }

        //AFTER FISHING STATE
        else if (gp.gameState == gp.afterFishingState) {
            afterFishingState(key);
        }

        //INVENTORY STATE
        else if (gp.gameState == gp.inventoryState) {
            inventoryState(key);
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
                //add later
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

    public void gameState(int key) {
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
            if (gp.cChecker.checkNearWater(gp.player)) {
                spacePressed = true;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.optionState;
            gp.music.stop("Bird");
            gp.music.stop("Background");
        }
        //DEBUG
        if (key == KeyEvent.VK_T) {
            checkDrawTime = (checkDrawTime == true) ? false : true;
        }

        if (key == KeyEvent.VK_H) {
            gp.player.physical = gp.player.maxPhysical;
        }
        if (key == KeyEvent.VK_B) {
            gp.gameState = gp.inventoryState;
        }
    }

    public void dialogState(int key) {
        if (key == KeyEvent.VK_ENTER) {
            if (gp.npc[0].dialogueIndex < gp.npc[0].dialogues.length) {
                gp.npc[0].speak(0);
            }
        }
    }

    public void notificationState(int key) {
        if (key == KeyEvent.VK_SPACE) {
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
            gp.ui.completion += 10;
            if (gp.ui.completion >= 100) {
                gp.ui.completion = 0;
                gp.iManage.Fishing(gp.player.rod);
                gp.gameState = gp.afterFishingState;
            }
        }
    }

    public void afterFishingState(int key) {
        if (key == KeyEvent.VK_ENTER) {
            gp.gameState = gp.playState;
        }
    }

    public void inventoryState(int key) {
        if (key == KeyEvent.VK_D) {
            if (gp.ui.inventorySlotCol != 5) {
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
            if (gp.ui.inventorySlotRow != 2) {
                gp.ui.inventorySlotRow++;
                gp.playSoundEffect("select_sound", 6);
            }

        } else if (key == KeyEvent.VK_B) {
            gp.gameState = gp.playState;
        }
    }

//    @Override
//    public void mouseWheelMoved(MouseWheelEvent e) {
//        int scroll = e.getWheelRotation();
//        if (scroll < 0) {
//            gp.zoomInOut(2);
//        } else {
//            gp.zoomInOut(-2);
//        }
//    }
}
