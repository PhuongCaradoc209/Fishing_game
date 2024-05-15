package tile_interactive;

import Main.GamePanel;
import entity.Entity;

public class InteractiveTile extends Entity {
    GamePanel gp;
    public boolean isOpen = false;
    public InteractiveTile(GamePanel gp, int row, int col){
        super(gp);
        this.gp = gp;
    }
    public void update(){
    }
}