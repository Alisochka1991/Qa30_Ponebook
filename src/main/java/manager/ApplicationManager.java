package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    HelperUser user;


    public void init()
    {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //неявное ожидание
        user = new HelperUser(wd);
    }

    public void stop()
    {
    wd.quit();
    }

    public HelperUser getUser() { //ggetter ctobi videt HelperUser
        return user;
    }
}
