package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{//constructor
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginregistrationform(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void openLoginRegistrationForm() {
        click(By.xpath("//*a[text()='LOGIN']"));
    }



    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }
    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));

    }
}
