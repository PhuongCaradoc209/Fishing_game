package tile_interactive;

import Main.GamePanel;

public class IT_Door_open extends InteractiveTile {
    public IT_Door_open(GamePanel gp, int col, int row){
        super(gp, col, row);
        name = "Door Open";
        size = gp.tileSize;
        down1 = setup("objects/door_open", gp.tileSize, gp.tileSize);
        down2 = down1;

        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        isOpen = true;
    }
    public InteractiveTile getInteractedForm(){
        InteractiveTile tile = new IT_Door_close(gp, 20, 12);
        return tile;
    }
}