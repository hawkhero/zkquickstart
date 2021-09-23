package quickstart.shadow;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import org.zkoss.zuti.zul.*;
import quickstart.hero.*;

public class ProfileEditorComposer extends SelectorComposer {
    @Wire("::shadow#profile")
    private Apply apply;
    @Wire("button")
    private Button modeButton;
    private boolean isEdit = false;
    private Hero hero;

    @Override
    public void doBeforeComposeChildren(Component comp) throws Exception {
        super.doBeforeComposeChildren(comp);
        hero = HeroService.create("奇異博士");
        Sessions.getCurrent().setAttribute("hero", hero);
    }

    @Listen("onClick = button")
    public void switchMode(){
        if (isEdit){
            hero.setName(((Textbox)modeButton.getFellow("nameBox")).getValue());
            hero.setAge(((Intbox)modeButton.getFellow("ageBox")).getValue());
        }
        isEdit = !isEdit;
        modeButton.setLabel(isEdit ? "Save": "Edit");
        apply.setTemplate(isEdit ? "edit" : "normal");
        apply.recreate();
    }
}
