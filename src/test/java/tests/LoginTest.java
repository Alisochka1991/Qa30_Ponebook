package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {
//        WebElement loginBtn = wd.findElement(By.xpath("//*[text() ='LOGIN']"));
//        loginBtn.click();
//        WebElement emailInput = wd.findElement(By.xpath("//input[@placeholder='Email']"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("alisiaagranov@gmail.com");
//
//        WebElement passwordInput = wd.findElement(By.xpath("(//input[@placeholder='Password'])[1]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("212229Alisa$");
//
//        wd.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
//
//        Assert.assertTrue(wd.findElements(By.xpath("(//'qwqew')")).size()>0);

    }

    @Test
    public void loginTest2()
    {
        String email ="Alisa@gmail.com";
        String password = "2234324324";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginregistrationform(email,password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        //Assert.assertTrue(isElementPresent(By.xpath("(//'qwqew')")));
        Assert.assertTrue(app.getUser().isLogged());
    }


}

