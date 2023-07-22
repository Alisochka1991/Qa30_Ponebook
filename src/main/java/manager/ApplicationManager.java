package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;

    HelperUser user;


    public void init()
    {
        wd = new ChromeDriver();
        logger.info("Testts starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://telranedu.web.app");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //neyavnoe ozidanie
        user = new HelperUser(wd);
    }

    public void stop()
    {
        logger.info("Tests Passed");
        wd.quit();
    }

    public HelperUser getUser() { //ggetter ctobi videt HelperUser
        return user;
    }
}
