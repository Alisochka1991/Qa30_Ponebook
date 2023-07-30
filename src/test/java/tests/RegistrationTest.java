package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @BeforeMethod (alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


    @Test
    public void registrationTestPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600; //генеация уеникальных значений для регистрации
        String email = "alisa" + i + "@gmail.com";
        String password = "212229Alisa$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginregistrationform(email, password);
        app.getUser().submitRegistration();
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("(//'qwqew')")));
        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void registrationTestSWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600; //генеация уеникальных значений для регистрации
        String email = "alisa" + i + "gmail.com";
        String password = "212229Alisa&";
        System.out.println("Email: " + email);
        logger.info("Test  registration Positive starts with >>" +email + "&&&" +password );



        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginregistrationform(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2000);
        //Assert.assertFalse(isElementPresent(By.xpath("(//'qwqew')")));
        //Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


}
