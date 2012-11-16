package map.objects;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 15.04.12
 * Time: 14:56
 */
public abstract class MapObject {
    protected String imgKey;
    protected Integer x;
    protected Integer y;

    public String getImgKey() {
        return imgKey;
    }

    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
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
}
