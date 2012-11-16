import intefrace.presenter.mainframe.MainFramePresenter;
import intefrace.view.mainframe.MainFrameView;
import map.Map;
import resources.Resources;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.02.12
 * Time: 21:41
 */
public class Main {
    public static void main(String[] args) {
        MainFrameView mainFrameView = new MainFrameView();
        MainFramePresenter mainFramePresenter = new MainFramePresenter(mainFrameView, new Map(Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("map.width")), Integer.valueOf(Resources.getInstance().getApplicationProperties().getProperty("map.height"))));
        mainFramePresenter.show();
    }
}
