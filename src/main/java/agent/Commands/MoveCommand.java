package agent.Commands;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.03.12
 * Time: 22:30
 */
public class MoveCommand implements ICommand{
    int dX;
    int dY;

    public MoveCommand(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }
}
