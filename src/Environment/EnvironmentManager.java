package Environment;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class EnvironmentManager {
    GamePanel gp;
    DayNight dayNight;
    public EnvironmentManager(GamePanel gp){
        this.gp = gp;
    }

    public void setUp(){
        dayNight = new DayNight(gp);
    }
    public void update(){
        dayNight.update();
    }
    public void draw(Graphics2D g2){
        dayNight.draw(g2);
    }

}
