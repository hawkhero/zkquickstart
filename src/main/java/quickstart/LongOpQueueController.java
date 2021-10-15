package quickstart;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class LongOpQueueController extends SelectorComposer {

    private static final String QUEUE_NAME = "longop";
    @Wire
    private Vlayout info;
    private String result;


    @Listen(Events.ON_CLICK + "=button")
    public void start() {
        if (EventQueues.exists(QUEUE_NAME)) {
            display("忙碌中，請等待");
            return; //busy
        }

        EventQueue queue = EventQueues.lookup(QUEUE_NAME); //新建 event queue
        //訂閱非同步傾聽器進行耗時運算
        queue.subscribe(new EventListener() {
            public void onEvent(Event evt) {
                if ("doLongOp".equals(evt.getName())) {
                    org.zkoss.lang.Threads.sleep(3000); //模擬耗時運算
                    result = "動作完成！"; //儲存結果
                    queue.publish(new Event("endLongOp")); //通知同步傾聽器
                }
            }
        }, true); //true 代表非同步

        //註冊一個同步傾聽器更新畫面，這裡可以呼叫元件 API
        queue.subscribe(new EventListener() {
            public void onEvent(Event evt) {
                if ("endLongOp".equals(evt.getName())) {
                    display(result); //show the result to the browser
                    EventQueues.remove(QUEUE_NAME);
                }
            }
        }); //同步傾聽器

        display("請等3秒"); //將訊息顯示到頁面訊息區上
        queue.publish(new Event("doLongOp")); //送出自訂evet 來呼叫上面註冊的非同步傾聽器
    }

    void display(String msg) {
        new Label(msg).setParent(info);
    }
}
