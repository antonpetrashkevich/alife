package agent.receptors;

import entities.Field;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.03.12
 * Time: 22:30
 */
public class VisualReceptor implements IReceptor {
    private int difX;
    private int difY;
    private Field field;

    public VisualReceptor(int difX, int difY) {
        this.difX = difX;
        this.difY = difY;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
