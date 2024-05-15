package tile_interactive;

import Main.GamePanel;

public class IT_Door_close extends InteractiveTile {
    GamePanel gp;
    public IT_Door_close(GamePanel gp, int row, int col){
        super(gp,row,col);
        this.gp = gp;
        name = "Door Close";

        worldX = gp.tileSize * row;
        worldY = gp.tileSize * col;

        down1 = setup("objects/door_close", gp.tileSize, gp.tileSize);

        isOpen = false;
    }
}