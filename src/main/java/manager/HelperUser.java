package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{//constructor
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginregistrationform(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }
    public void fillLoginregistrationform(User user) {
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    public void openLoginRegistrationForm() {
        click(By.xpath("//a[normalize-space()='LOGIN']"));
    }



    public void submitLogin() {
        click(By.xpath("//button[normalize-space()='Login']"));
    }
    public void logout() {
        click(By.xpath("//button[normalize-space()='Sign Out']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[normalize-space()='Sign Out']"));

    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());//работа с алертами
        if(alert==null)
        {
            return false;
        }
        else {
            wd.switchTo().alert();
            alert.accept();//нажимает на алерте OK
            alert.dismiss();//нажиммает CANCEL
            alert.sendKeys("Text");//печатает текст
            alert.getText();
            return true;
        }
    }
}
