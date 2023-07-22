package manager;

import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }
}