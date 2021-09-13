package quickstart.validate;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.*;

public class YouthValidationComposer implements Composer {
    @Override
    public void doAfterCompose(Component component) throws Exception {
        if (component instanceof Intbox){
            Intbox box = (Intbox) component;
            box.setConstraint(new YouthConstraint(SimpleConstraint.NO_NEGATIVE +
                    SimpleConstraint.END_AFTER));
        }
    }
}
