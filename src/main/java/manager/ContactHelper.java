package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

    public boolean isContactAddded()
    {
        return isElementPresent(By.xpath("//a[normalize-space()='CONTACTS']"));
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactForm() {
        click(By.xpath("//b[normalize-space()='Save']"));
    }

    public void openContactform() {
        click(By.xpath("//a[normalize-space()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastname());
        type(By.xpath("//input[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contact.getDescription());


    }
}
