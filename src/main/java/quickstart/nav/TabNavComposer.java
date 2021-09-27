package quickstart.nav;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.*;

import java.util.Map;

/**
 * 以 tab 做頁面導航
 */
public class TabNavComposer extends SelectorComposer {
    @Wire("tabbox")
    private Tabbox tabbox;
    private ListModelList<TabState> tabModel = new ListModelList();
    private static Map<String, TabState> tabStates
            = Map.of("finance", new TabState("財務", "z-icon-book"),
                     "management", new TabState("管理", "z-icon-user"),
                     "research", new TabState("研究", "z-lightbulb-o"));

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        tabbox.setModel(tabModel);
    }

    @Listen(Events.ON_CLICK + "= navitem")
    public void navigate(MouseEvent event){
        //取得頁面名稱
        String pageName = ((Navitem)event.getTarget()).getAttribute("name").toString();
        addTab(pageName);
    }

    public void addTab(String pageName){
        tabModel.add(tabStates.get(pageName));
    }
}
