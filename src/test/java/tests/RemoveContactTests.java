package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isNotLogged())
        {
            app.getUser().login(new User()
                    .setEmail("alisiaagranov@mail.com")
                    .setPassword("212229Alisa$"));

        }
    }

    @Test
    public void removeOneContact()
    {
       int result =  app.getContact().removeOneCotact();
        Assert.assertEquals(result, -1);

    }

    @Test
     public void removeAllContacts()
    {
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isContactNoHere());
    }



}
