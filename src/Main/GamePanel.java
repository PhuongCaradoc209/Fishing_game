package Main;

import Environment.EnvironmentManager;
import entity.Entity;
import entity.Player;
import tile.TileManager;
import tile_interactive.InteractiveTile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 3;
    public int tileSize = originalTileSize * scale + 10;
    private final int maxScreenCol = 20;
    private final int maxScreenRow = 12;
    public int screenWidth = maxScreenCol * tileSize;//1160 px
    public int screenHeight = maxScreenRow * tileSize;//696px

    //WORLD SETTINGS
    public final int maxMap = 2;
    public int currentMap = 0;
    public final int maxWorldCol = 25;
    public final int maxWorldRow = 25;
    public final int worldWidth = maxWorldCol * tileSize;//2400
    public final int worldHeight = maxWorldRow * tileSize;//2400

    //FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    boolean fullScreenOn = false;

    //SYSTEM
    public TileManager tileMgr = new TileManager(this);
    public CollectionManagement collectionM = new CollectionManagement(this);
    public KeyHandler keyHandler = new KeyHandler(this);
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    EnvironmentManager enviMgr = new EnvironmentManager(this);
    Thread gameThread;

    //CHECK COLLISION
    public CollisionChecker cChecker = new CollisionChecker(this);
    //PLAYER
    public Player player = new Player(this, keyHandler, tileMgr);
    //OBJECT
    public ArrayList<Entity>[] obj = new ArrayList[maxMap];
    //ENTITY
    public ArrayList<Entity>[] npc = new ArrayList[maxMap];
    //ANIMAL
    public ArrayList<Entity>[] animal = new ArrayList[maxMap];
    //INTERACT TILE
    public ArrayList<InteractiveTile>[] iTile = new ArrayList[maxMap];
    ArrayList<Entity> entityList = new ArrayList<>();


    //GAME STATE
    public int gameState;
    public final int tittleState = 0;
    //PLAYER STATE
    public final int playState = 1;
    public final int pauseState = 2;
    public final int autoDisplayState = 3;
    public final int dialogueState = 4;
    public final int notificationState = 5;
    public final int optionState = 6;
    public final int afterFishingState = 7;
    public final int collectionState = 8;
    public final int fishingState = 9;
    public final int selectPlayerState = 10;
    public final int tradeState = 11;
    public final int transitionState = 12;
    public final int fishTankState = 13;
    public final int inventoryState = 14;
    public final int feedCowState = 15;
    public final int gameOverState = 16;

    //FPS (Frame Per Second)
    int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
//        this.addMouseWheelListener(keyHandler);
        this.setVisible(true);
        this.setFocusable(true);
    }

    public void setUpGame() {
        for (int i = 0; i < maxMap; i++) {
            obj[i] = new ArrayList<>();
            npc[i] = new ArrayList<>();
            animal[i] = new ArrayList<>();
            iTile[i] = new ArrayList<>();
        }
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setAnimal(currentMap);
        aSetter.setInteractiveTile();
        enviMgr.setUp();
        gameState = tittleState;

        tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D) tempScreen.getGraphics();


//        setFullScreen();
    }

    public void restart(){
        player.setDefaultValues();
        player.setDefaultCharacterImage();
        player.setItems();
    }

//    public void zoomInOut(int i) {
//        int oldWorldWidth = tileSize * maxWorldCol;
//        tileSize += i;
//        int newWorldWidth = tileSize * maxWorldCol;
//
//        double multiplier = (double) newWorldWidth / oldWorldWidth;
//
//        System.out.println("tileSize: " + tileSize);
//        System.out.println("worldWidth: " + newWorldWidth);
//        System.out.println("PlayerWordX: " + player.worldX);
//        System.out.println("PlayerScreenX: " + player.screenX);
//
//        player.speed = (double) newWorldWidth / 700;
//        double newPlayerWorldX = player.worldX * multiplier;
//        double newPlayerWorldY = player.worldY * multiplier;
//
//        player.screenX = (double) screenWidth / 2 - ((double) tileSize / 2); //set the player at the center of the screen
//        player.screenY = (double) screenHeight / 2 - ((double) tileSize / 2);
//
//        player.worldX = newPlayerWorldX;
//        player.worldY = newPlayerWorldY;
//    }

    public void setFullScreen() {
        //GET LOCAL SCREEN DEVICE
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        //GET FULL SCREEN WIDTH AND HEIGHT
        screenHeight2 = Main.window.getHeight();
        screenWidth2 = Main.window.getWidth();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;

        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        //display FPS
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) //as long as gameThread is existed
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                drawToTempScreen(); //draw to the buffered image
                drawToScreen(); //draw the buffered image to the screen
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (gameState == playState || gameState == autoDisplayState) {
            if (!music.isPlaying("Bird") && !music.isPlaying("Background")) {
                playMusic("Bird", 0);
                playMusic("Background", 2);
            }
            player.update();
            for (int i = 0; i < npc[0].size(); i++) {
                if (npc[0].get(i) != null) {
                    npc[0].get(i).update(false);
                }
            }
            for (int i = 0; i < animal[0].size(); i++) {
                if (animal[0].get(i) != null) {
                    if (i < 4) {
                        animal[0].get(i).update(true);
                    } else animal[0].get(i).update(false);
                }
            }
            for (int i = 0; i < iTile[0].size(); i++) {
                if (iTile[0].get(i) != null) {
                    iTile[0].get(i).update(false);
                }
            }
            //ENVIRONMENT
            enviMgr.update();
        }
        if (gameState == fishTankState) {
            stopMusic("Bird");
            playMusic("Background", 2);

            //FISH
            for (int i = 0; i < animal[1].size(); i++) {
                if (animal[1].get(i) != null) {
                    animal[1].get(i).update(true);
                }
            }

            //OBJECT
            for (int i = 0; i < obj[1].size(); i++) {
                if (obj[1].get(i) != null) {
                    obj[1].get(i).update(false);
                }
            }
        }
    }

    public void drawToTempScreen() {
        //DEBUG
        long drawStart = 0;
        if (keyHandler.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }
        //TITTLE SCREEN
        if (gameState != tittleState && currentMap == 0) {
            //TILE
            tileMgr.draw(g2);

            //ADD ENTITIES TO THE LIST
            entityList.add(player);

            //INTERACTIVE TILE
            for (InteractiveTile interactiveTile : iTile[currentMap]) {
                if (interactiveTile != null) {
                    entityList.add(interactiveTile);
                }
            }

            for (Entity entity : npc[currentMap]) {
                if (entity != null) {
                    entityList.add(entity);
                }
            }

            for (Entity value : obj[currentMap]) {
                if (value != null) {
                    entityList.add(value);
                }
            }

            for (Entity value : animal[currentMap]) {
                if (value != null) {
                    entityList.add(value);
                }
            }

            //SORT
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    return Integer.compare((int) e1.worldY, (int) e2.worldY);
                }
            });

            //DRAW ENTITIES
            for (Entity entity : entityList) {
                entity.draw(g2);
            }

            //REMOVE ENTITIES TO THE LIST (otherwise, the list become larger after every loop)
            entityList.clear();

            //ENVIRONMENT
            enviMgr.draw(g2);
        } else if (gameState == fishTankState) {
            //TILE
            tileMgr.draw(g2);

            //DRAW FISH
           for (int i =0; i < animal[1].size(); i++){
               animal[1].get(i).draw(g2);
           }

           //DRAW OBJ
            for (int i =0; i < obj[1].size(); i++){
                obj[1].get(i).draw(g2);
            }
        }

        //UI
        ui.draw(g2);

        if (keyHandler.checkDrawTime == true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.WHITE);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }

    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }

    public void playMusic(String soundName, int i) {
        if (!music.isPlaying(soundName)) {
            music.setField(i);
            music.loop(soundName);
        }
    }

    public void stopMusic(String soundName) {
        music.stop(soundName);
    }

    public void playSoundEffect(String soundName, int i) {
        soundEffect.setField(i);
        soundEffect.playSE(soundName);
    }
}
