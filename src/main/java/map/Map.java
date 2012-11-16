package map;

import agent.IAgent;
import entities.Field;
import map.randomizer.AgentsRandomizer;
import map.randomizer.MapRandomizer;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 03.03.12
 * Time: 17:54
 */
//todo Remove getter-setter methods. Add more logic to this class
public class Map {
    private ArrayList<Field> cells = new ArrayList<Field>();
    private ArrayList<IAgent> agents = new ArrayList<IAgent>();

    private static final Logger log = Logger.getLogger(Map.class);

    private Integer height;
    private Integer width;

    public Map(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }


    public ArrayList<Field> getCells() {
        return cells;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setCells(ArrayList<Field> cells) {
        this.cells = cells;
    }

    public ArrayList<IAgent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<IAgent> agents) {
        this.agents = agents;
    }

    //todo do not handle exceptions. throw them
    public void randomMap() {
        cells.clear();
        MapRandomizer randomizer = new MapRandomizer();
        try {
            randomizer.fillCellsWithRandomFields(this);
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        }
    }


    public void randomAgents() {
        agents.clear();
        AgentsRandomizer randomizer = new AgentsRandomizer();
        try {
            randomizer.fillCellsWithRandomAgents(this);
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        }
    }

    public boolean cellIsEligibleForAgent(int x, int y) {
        if (cells.get(x+y*width).isPassable()) {
            return true;
        }
        return false;
    }
}
