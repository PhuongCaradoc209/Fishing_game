package tile_interactive;

import Main.GamePanel;

public class IT_Door_close extends InteractiveTile {
    public IT_Door_close(GamePanel gp, int col, int row){
        super(gp, col, row);
        name = "Door Close";
        size = gp.tileSize;
        down1 = setup("objects/door_close", gp.tileSize, gp.tileSize);
        down2 = setup("objects/door_close", gp.tileSize, gp.tileSize);

        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        isOpen = false;
    }
    public InteractiveTile getInteractedForm(){
        InteractiveTile tile = new IT_Door_open(gp, 20, 12);
        return tile;
    }
}