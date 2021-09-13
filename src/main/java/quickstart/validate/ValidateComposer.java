package quickstart.validate;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.*;

public class ValidateComposer implements Composer {
    @Override
    public void doAfterCompose(Component component) throws Exception {
        if (component instanceof Textbox) {
            Textbox box = (Textbox) component;
            component.addEventListener(Events.ON_CHANGE, event -> {
                if (box.getValue().length() <= 1) {
                    throw new WrongValueException("至少要超過一個字");
                }
            });
        }
    }
}
