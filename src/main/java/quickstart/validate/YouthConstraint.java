package quickstart.validate;

import org.zkoss.zk.ui.*;
import org.zkoss.zul.SimpleConstraint;

/**
 * 繼承 {@link SimpleConstraint} 來擁有內建驗證規則，並加上自訂的驗證規則
 */
public class YouthConstraint extends SimpleConstraint {

    /* 初始化念間規則 */
    public YouthConstraint(int flags) {
        super(flags);
    }

    /* 自訂驗證規則 */
    @Override
    public void validate(Component comp, Object value) throws WrongValueException {
        if (value != null && Integer.valueOf(value.toString()).intValue() >=18)
            throw new WrongValueException(comp, "必須小於 18");
    }
}