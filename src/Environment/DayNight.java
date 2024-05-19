package Environment;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DayNight {
    GamePanel gp;
    BufferedImage darknessFilter;
    int circleSize = 350;
    int dayCounter;
    float filterAlpha = 0f;
    final int day = 0;
    final int dusk = 1;
    final int night = 2;
    final int dawn = 3;
    int dayState = day;
    float levelOfBlue = 0.6f;
    public BufferedImage iDay, iDusk, iDawn, iNight;
    Area screenArea;
    public DayNight(GamePanel gp) {
        //ICON
        getImage(gp);

        //Create a buffered image
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) darknessFilter.getGraphics();

        screenArea = new Area(new Rectangle2D.Double(0, 0, gp.screenWidth, gp.screenHeight));

        //LIGHT CIRCLE
        int centerX = (int) (gp.player.screenX + (gp.tileSize) / 2);
        int centerY = (int) (gp.player.screenY + (gp.tileSize) / 2);

        double x = centerX - ((double) circleSize / 2);
        double y = centerY - ((double) circleSize / 2);

        Shape circleShape = new Ellipse2D.Double(x, y, circleSize, circleSize);
        Area lightArea = new Area(circleShape);

        //Subtract the light circle from the screen rectangle
        screenArea.subtract(lightArea);

        //GRADATION EFFECT FOR LIGHT CIRCLE
        Color[] color = new Color[12];
        float[] fraction = new float[12];
        color[0] = new Color(0,0,0.6f,0.1f);
        color[1] = new Color(0,0,0.6f,0.42f);
        color[2] = new Color(0,0,0.6f,0.52f);
        color[3] = new Color(0,0,0.6f,0.61f);
        color[4] = new Color(0,0,0.6f,0.69f);
        color[5] = new Color(0,0,0.6f,0.76f);
        color[6] = new Color(0,0,0.6f,0.82f);
        color[7] = new Color(0,0,0.6f,0.87f);
        color[8] = new Color(0,0,0.6f,0.91f);
        color[9] = new Color(0,0,0.6f,0.94f);
        color[10] = new Color(0,0,0.6f,0.96f);
        color[11] = new Color(0,0,0.6f,0.98f);

        fraction[0] = 0.1f;
        fraction[1] = 0.42f;
        fraction[2] = 0.52f;
        fraction[3] = 0.61f;
        fraction[4] = 0.69f;
        fraction[5] = 0.76f;
        fraction[6] = 0.82f;
        fraction[7] = 0.87f;
        fraction[8] = 0.91f;
        fraction[9] = 0.94f;
        fraction[10] = 0.96f;
        fraction[11] = 0.98f;

        RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, (float) circleSize /2, fraction, color);
        g2.setPaint(gPaint);
        g2.fill(lightArea);

//        g2.setColor(new Color(0, 0, levelOfBlue, 1f));
        g2.fill(screenArea);
        g2.dispose();
    }

    public void getImage(GamePanel gp) {
        iDay = setup("Environment/day", gp);
        iDusk = setup("Environment/night", gp);
        iDawn = setup("Environment/day", gp);
        iNight = setup("Environment/night", gp);
    }

    public void update() {
        //Check the state of the day
        if (dayState == day) {
            dayCounter++;
            if (dayCounter > 800) {
                dayState = dusk;
                dayCounter = 0;
            }
        }
        if (dayState == dusk) {
            filterAlpha += 0.001f;
            levelOfBlue -= 0.001f;
            if (filterAlpha > 0.55f) {
                filterAlpha = 0.55f;
                dayState = night;
            }
        }
        if (dayState == night) {
            dayCounter++;
            if (dayCounter > 800) {
                dayState = dawn;
                dayCounter = 0;
            }
        }

        if (dayState == dawn) {
            filterAlpha -= 0.001f;
            levelOfBlue += 0.001f;
            if (filterAlpha < 0f) {
                filterAlpha = 0;
                dayState = day;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlpha));
        g2.drawImage(darknessFilter, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        //DEBUG
        String situation = "";
        switch (dayState) {
            case day:
                g2.setColor(new Color(0x7b342e));
                situation = "Day";
                image = iDay;
                break;
            case dusk:
                g2.setColor(new Color(0x4c339a));
                situation = "Dusk";
                image = iDusk;
                break;
            case night:
                g2.setColor(new Color(0x4c339a));
                situation = "Night";
                image = iNight;
                break;
            case dawn:
                g2.setColor(new Color(0x7b342e));
                situation = "Dawn";
                image = iDawn;
                break;
        }
        g2.drawImage(image, 900, -20, 240,135,null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40f));
        g2.drawString(situation, 1015, 63);
    }

    public BufferedImage setup(String imagePath, GamePanel gp) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + ".png")));
            image = uTool.scaleImage(image, 320, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}