package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.element.LoginElements;

public class LoginPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterLoginPage(){
        driver.get(LoginElements.URL);
    }

    public void fillinLoginField(String login){
        WebElement element = driver.findElement(LoginElements.LOGIN_FIELD);
        element.clear();
        element.sendKeys(login);
    }
    public void fillinPasswordField(String password){
        WebElement element = driver.findElement(LoginElements.PASSWORD_FIELD);
        element.clear();
        element.sendKeys(password);
    }
    public void clickEnterButton(){
        WebElement element = driver.findElement(LoginElements.ENTER_BUTTON);
        element.click();
    }
}
