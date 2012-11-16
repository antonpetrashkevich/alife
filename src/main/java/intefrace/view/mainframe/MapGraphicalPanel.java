package intefrace.view.mainframe;

import map.Map;
import resources.Resources;
import utilities.EntityImage;
import utilities.MapGraphicalConverter;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User:
 * Date: 07.03.12
 * Time: 0:19
 */
public class MapGraphicalPanel extends Component {
    private ArrayList<EntityImage> fieldsImages;
    private ArrayList<EntityImage> agentsImages;
    MapGraphicalConverter converter = new MapGraphicalConverter();
    private Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public MapGraphicalPanel() {
        super();
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawEntities(graphics2D);
    }

    private void drawEntities(Graphics2D graphics2D) {
            if (fieldsImages != null && !fieldsImages.isEmpty())
            for (EntityImage entityImage : fieldsImages) {
                graphics2D.drawImage(entityImage.getImage(), entityImage.getX(), entityImage.getY(), null);
            }
        if (agentsImages != null && !agentsImages.isEmpty())
            for (EntityImage agentImage : agentsImages) {
                graphics2D.drawImage(agentImage.getImage(), agentImage.getX(), agentImage.getY(), null);
            }
    }

    public void redraw() {
        fieldsImages = converter.convertMapFields(map);
        agentsImages = converter.convertMapAgents(map);
        setPreferredSize(new Dimension(map.getWidth() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.width")), map.getHeight() * Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("field.height"))));
        repaint();
    }
}
