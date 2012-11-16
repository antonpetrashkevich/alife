package agent;

import agent.Commands.ICommand;
import agent.Commands.MoveCommand;
import agent.DNA.DNA;
import agent.NeuroNet.NeuroNet;
import agent.receptors.IReceptor;
import agent.receptors.VisualReceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 25.03.12
 * Time: 23:12
 */
public class Agent extends IAgent {
    private DNA dna;
    NeuroNet neuroNet;
    List<IReceptor> receptors;
    List<ICommand> commands;

    //todo remove hardcode
    public Agent() {
        receptors = new ArrayList<IReceptor>();
        commands = new ArrayList<ICommand>();

        receptors.add(new VisualReceptor(0, 0));
        receptors.add(new VisualReceptor(0, 1));
        receptors.add(new VisualReceptor(0, -1));
        receptors.add(new VisualReceptor(1, 0));
        receptors.add(new VisualReceptor(1, 1));
        receptors.add(new VisualReceptor(1, -1));
        receptors.add(new VisualReceptor(-1, 0));
        receptors.add(new VisualReceptor(-1, 1));
        receptors.add(new VisualReceptor(-1, -1));

        commands.add(new MoveCommand(0,0));
        commands.add(new MoveCommand(0,1));
        commands.add(new MoveCommand(0,-1));
        commands.add(new MoveCommand(1,0));
        commands.add(new MoveCommand(1,1));
        commands.add(new MoveCommand(1,-1));
        commands.add(new MoveCommand(-1,0));
        commands.add(new MoveCommand(-1,1));
        commands.add(new MoveCommand(-1,-1));

        setImgKey("agent");
    }

    public ICommand getExecutiveCommand(){
        ICommand result = null;
        return result;
    }

}
