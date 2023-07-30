package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver wd;
    EventFiringWebDriver wd;

    HelperUser user;
    ContactHelper contact;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    String browser; //peremennaya dlya otkrytia neskolkih brauzerov


    public void init()
    {
        if(browser.equals(BrowserType.CHROME))//esli brouser Chrome, otkrivai Chrome
        {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX))
        {
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }

        logger.info("Testts starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://telranedu.web.app");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //neyavnoe ozidanie
        user = new HelperUser(wd);
        contact = new ContactHelper(wd);
        wd.register(new MyListener());


    }
    public void stop()
    {
        logger.info("Tests Passed");
        wd.quit();
    }

    public HelperUser getUser() { //ggetter ctobi videt HelperUser
        return user;
    }
    public ContactHelper getContact() {
        return contact;
    }
}
