package quickstart;

import org.zkoss.zul.*;

/**
 * 透過 {@link Listbox#setItemRenderer(String)} 來指派
 */
public class MyRenderer implements ListitemRenderer {
    public void render(Listitem listitem, Object data, int index) {
        Listcell cell = new Listcell();
        listitem.appendChild(cell);
        if (data instanceof String[]){
            cell.appendChild(new Label(((String[])data)[0].toString()));
        } else if (data instanceof String){
            cell.appendChild(new Label(data.toString()));
        } else {
            cell.appendChild(new Label("UNKNOW:"+data.toString()));
        }
    }
}
