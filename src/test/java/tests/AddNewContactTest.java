package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{
    @BeforeMethod (alwaysRun = true)
    public void precondition() {
        if (app.getUser().isNotLogged())
        {
            app.getUser().login(new User()
                    .setEmail("alisiaagranov@mail.com")
                    .setPassword("212229Alisa$"));

        }
    }
    @Test (invocationCount = 4, groups = {"web","smoke" }) //skolko raz zapustitsa test
    public void addNewContactTest()
    {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder().name("Kuritsa")
                .lastname("Mokraya").phone("01010101"+index)
                .email("kakashki"+index+"@gmail.com")
                .address("Zalupka"+index).description("Potselovala v popu")
                .build();

        app.getContact().openContactform();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        Assert.assertTrue(app.getContact().isContactAddded(contact.getEmail()));//proverka chto sozdalsa contact s takim imenem

    }
}
