package quickstart.hero;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class HeroController extends SelectorComposer {
    @Wire
    private Listbox heroBox;
    @Wire
    private Textbox newNameBox;

    private ListModelList<Hero> heroList = new ListModelList();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        //在此初始化資料或元件
        heroList.addAll(HeroService.getInitHero());
        heroBox.setModel(heroList);
    }

    @Listen("onClick = #add")
    public void add(){
        heroList.add(HeroService.create(newNameBox.getValue()));
        newNameBox.setRawValue("");
    }

    @Listen("onDelete = #heroBox")
    public void delete(){
        heroList.remove(heroList.getSelection().iterator().next());
    }

    @Listen("onChange= #heroBox")
    public void change(ForwardEvent event){
        String newName = ((Textbox) event.getOrigin().getTarget()).getValue();
        Hero selectedHero = heroList.getSelection().iterator().next();
        selectedHero.setName(newName);
    }
}
