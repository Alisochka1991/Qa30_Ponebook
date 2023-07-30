package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void precondition()
    {
        if(app.getUser().isLogged())
        {
            app.getUser().logout();
        }
    }

    @Test (groups = {"web"})
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

    @Test(groups = {"web"}) //zapuskaem gryppi testob
    public void loginTest2()
    {
        String email ="alisiaaranov@gmail.com";
        String password = "212229Alisa$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginregistrationform(email,password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        //Assert.assertTrue(isElementPresent(By.xpath("(//'qwqew')")));
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginTestModel()
    {
        String email ="alisiaaranov@gmail.com";
        String password = "212229Alisa$";
        User user = new User().setEmail(email).setPassword(password);
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginregistrationform(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);

    }


}

