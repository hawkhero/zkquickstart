package quickstart.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zuti.zul.Apply;

/**
 * 以範本插入做頁面導航
 */
public class TemplateNavComposer extends SelectorComposer<Component> {

    @Wire("::shadow#content")
    private Apply contentTemplate;

    @Listen(Events.ON_SELECT + "= navbar")
    public void navigate(SelectEvent event){
        //取得頁面名稱
        String pageName = ((Navitem)event.getSelectedItems().iterator().next()).getAttribute("name").toString();
        // 換頁面
        contentTemplate.setTemplateURI(pageName + ".zul");
        contentTemplate.recreate();
    }
}
