package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{

    public boolean isContactAddded(String email)
    {
        System.out.println(email);
        List<WebElement> contactEmail = wd.findElements(By.cssSelector("h3"));// hh3=glavany roditel gde zapisany emaily
        for(WebElement el: contactEmail)
        {

            if(el.getText().contains(email));
            return true;
        }
        return false; //proverka po emeily cto contact sozdalsa
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactForm() {
        pause(2000);
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

    public void openListContacts() {
        click(By.xpath("//a[normalize-space()='CONTACTS']"));
    }

    public int removeOneCotact() {
        int countBefore = countOfContacts(); //poschitat skolko kontaktov do
        logger.info("Count of contact before "+countBefore);

        if(!isContactListEmpty()) // esli ne pusto to udalyaem contact
        {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The element that was deleted had pone number---->"+phone); //uznat kakoi telefon bil udalen
            click(By.cssSelector(".contact-item_card__2SOIM")); //po classy
            click(By.xpath("//button[normalize-space()='Remove']"));
            pause(1500);
        }

        int countAfter = countOfContacts();//poscitat skolko posle
        logger.info("Count of contact after "+countAfter);

        return countAfter-countBefore;

    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();//esli tut PUSTO
    }
    public int countOfContacts()
    {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size(); //metod poschitat skolko vsego kontaktov

    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0) //do tex por poka razmer budet >0 udalyai kontakti
        {
            removeOneCotact();
        }
    }

    public boolean isContactNoHere() {
        return shouldHave(By.cssSelector(".contact-page_message__2qafk h1"), "No Contacts here!",10);

    }
}
