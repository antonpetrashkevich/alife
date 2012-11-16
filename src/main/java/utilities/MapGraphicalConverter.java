package utilities;

import agent.Agent;
import agent.IAgent;
import entities.Field;
import map.Map;
import resources.Resources;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 12.03.12
 * Time: 22:17
 */
public class MapGraphicalConverter {
    public ArrayList<EntityImage> convertMapFields(Map map) {
        ArrayList<EntityImage> result = new ArrayList<EntityImage>();
        for (Field field : map.getCells()) {
            result.add(new EntityImage(field.getX() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.width")), field.getY() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.height")), Resources.getInstance().getImage(field.getImgKey())));
        }
        return result;
    }

    public ArrayList<EntityImage> convertMapAgents(Map map) {
        ArrayList<EntityImage> result = new ArrayList<EntityImage>();
        for (IAgent field : map.getAgents()) {
            result.add(new EntityImage(field.getX() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.width")), field.getY() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.height")), Resources.getInstance().getImage(field.getImgKey())));
        }
        return result;
    }
}
