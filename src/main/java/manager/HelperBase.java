package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {
    WebDriver wd;

    Logger logger = LoggerFactory.getLogger(HelperBase.class);
    public HelperBase(WebDriver wd) { //конструктор
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }
    public void type(By locator, String text)
    {
        if(text !=null )
        {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator)
    {
        wd.findElement(locator).click();
    }
    public void pause(int mills)
    {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean shouldHave(By locator, String text, int time) //metod proveryaet chto po etomy locatory est tekst i on viden kakoe to vremya
    {
       return new WebDriverWait(wd, time).until(ExpectedConditions.textToBePresentInElement(wd.findElement(locator), text));

    }

}
