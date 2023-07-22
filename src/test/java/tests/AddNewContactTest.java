package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isNotLogged()) {
            app.getUser().login();
        }
    }
    @Test (invocationCount = 4)
    public void addNewContactTest()
    {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder().name("Kuritsa")
                .lastname("Mokraya").phone("01010101"+index)
                .email("Kakashki"+index+"gmail.com")
                .address("Zalupka"+index).description("Potselovala v popu")
                .build();

        app.getContact().openContactform();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        Assert.assertTrue(app.getContact().isContactAddded());

    }
}
