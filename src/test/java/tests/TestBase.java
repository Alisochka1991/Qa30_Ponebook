package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase  {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));//Po defolty CHROME
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite (alwaysRun = true) //shtobi on vsegda ispolnyalsa
    public void setUp() {
      app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown()
    {
    app.stop();
    }

    @BeforeMethod (alwaysRun = true)
    public void startLogger(Method method)
    {
        logger.info("Strat test----->"+ method.getName());

    }
    @AfterMethod (alwaysRun = true)
    public void end(Method method)
    {
        logger.info("***************************************************8");
    }

}
