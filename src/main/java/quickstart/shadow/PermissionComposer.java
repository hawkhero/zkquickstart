package quickstart.shadow;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zuti.zul.*;


public class PermissionComposer extends SelectorComposer {
    @Wire("::shadow#permission")
    private Apply permissionArea;
    private boolean permitted = false;

    @Listen(Events.ON_CHECK + "= checkbox")
    public void togglePermission(CheckEvent event){
        permitted = !permitted;
        permissionArea.setDynamicProperty("permitted", permitted);
        permissionArea.recreate();
    }
}
