package intefrace.view.mainframe;


import intefrace.presenter.mainframe.MainFramePresenter;
import map.Map;
import org.apache.log4j.Logger;
import resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 03.03.12
 * Time: 17:54
 */
public class MainFrameView extends JFrame implements MainFramePresenter.Display {
    private Integer width;
    private Integer height;
    private static final Logger log = Logger.getLogger(MainFrameView.class);
    private MapGraphicalPanel mapGraphicalPanel;

    private JScrollPane scrollPane;

    private JMenuItem exitMenuItem;
    private JMenuItem randomizeMenuItem;
    private JMenuItem randomizeAgentsItem;

    public int getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void addExitMenuItemListener(ActionListener exitMenuItemListener) {
        exitMenuItem.addActionListener(exitMenuItemListener);
    }

    public void addRandomizeMapListener(ActionListener listener) {
        randomizeMenuItem.addActionListener(listener);
    }

    public void addRandomizeAgentsListener(ActionListener listener) {
        randomizeAgentsItem.addActionListener(listener);
    }

    public MainFrameView() throws HeadlessException {
        super(Resources.getInstance().getInterfaceProperties().getProperty("mainFrame.title"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSizes();
        addMenu();
        configureLayout();
        addMap();
    }

    private void setSizes() {
        setWidth(Integer.valueOf(Resources.getInstance().getInterfaceProperties().getProperty("mainFrame.maxWidth")));
        setHeight(Integer.valueOf(Resources.getInstance().getInterfaceProperties().getProperty("mainFrame.maxHeight")));
        setPreferredSize(new Dimension(Integer.valueOf(Resources.getInstance().getInterfaceProperties().getProperty("mainFrame.minWidth")), Integer.valueOf(Resources.getInstance().getInterfaceProperties().getProperty("mainFrame.minHeight"))));
//        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    }

    private void addMap() {
        mapGraphicalPanel = new MapGraphicalPanel();
        scrollPane = new JScrollPane(mapGraphicalPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void configureLayout() {
        setLayout(new BorderLayout());
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            log.error(e);
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        } catch (UnsupportedLookAndFeelException e) {
            log.error(e);
        }
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        addMenus(menuBar);
    }

    private void addMenus(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        addFileMenuItems(fileMenu);

        JMenu mapMenu = new JMenu("Map");
        menuBar.add(mapMenu);
        addMapMenuItems(mapMenu);

        JMenu agentsMenu = new JMenu("Agents");
        menuBar.add(agentsMenu);
        addAgentsMenuItems(agentsMenu);
    }

    private void addAgentsMenuItems(JMenu agentsMenu) {
        randomizeAgentsItem = new JMenuItem("Add Random Agents");
        agentsMenu.add(randomizeAgentsItem);
    }

    private void addMapMenuItems(JMenu mapMenu) {
        randomizeMenuItem = new JMenuItem("Randomize");
        mapMenu.add(randomizeMenuItem);
    }

    private void addFileMenuItems(JMenu fileMenu) {
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
    }

    public void redraw() {
        mapGraphicalPanel.redraw();
    }

    public void setMap(Map map) {
        mapGraphicalPanel.setMap(map);
    }

    public void showFrame() {
        setVisible(true);
        pack();
    }

}
