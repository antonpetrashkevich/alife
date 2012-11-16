package intefrace.presenter.mainframe;

import intefrace.view.mainframe.MainFrameView;
import map.Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 04.03.12
 * Time: 15:19
 */
public class MainFramePresenter {
    private MainFrameView display;
    private Map map;

    public interface Display{
        void addExitMenuItemListener(ActionListener listener);
        void addRandomizeMapListener(ActionListener listener);
        void addRandomizeAgentsListener(ActionListener listener);
        void redraw();
        void setMap(Map map);
        void showFrame();
    }

    public MainFramePresenter(MainFrameView display,Map map) {
        this.display = display;
        this.map=map;
        display.setMap(map);
        setListeners();
    }

    private void setListeners() {
        display.addExitMenuItemListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        display.addRandomizeMapListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomizeMap();
            }
        });

        display.addRandomizeAgentsListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //todo show dialog with randomize agents options
                //todo check whether map exists
                randomizeAgents();
            }
        });
    }

    private void randomizeAgents() {
        map.randomAgents();
        display.redraw();
    }

    private void randomizeMap() {
        map.randomMap();
        display.redraw();
    }
    public void show() {
        display.showFrame();
    }
}
