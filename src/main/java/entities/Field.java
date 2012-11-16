package entities;

import map.objects.MapObject;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.02.12
 * Time: 21:44
 */
public abstract class Field extends MapObject {

    protected boolean isPassable;




    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean passable) {
        isPassable = passable;
    }

}
