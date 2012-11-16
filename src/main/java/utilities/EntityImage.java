package utilities;

import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 12.03.12
 * Time: 23:55
 */
public class EntityImage {
    private Integer x;
    private Integer y;
    private BufferedImage image;

    public EntityImage(Integer x, Integer y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
