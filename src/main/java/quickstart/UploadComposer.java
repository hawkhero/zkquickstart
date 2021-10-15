package quickstart;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Fileupload;

public class UploadComposer extends SelectorComposer {

    @Listen(Events.ON_CLICK + "= a")
    public void handleUpload(MouseEvent e) {
        Fileupload.get(1, new EventListener<UploadEvent>() {
            public void onEvent(UploadEvent event) throws Exception {
                Media[] medias = event.getMedias();
                System.out.println("upload " +  medias[0].getName());
            }
        });
    }
}
