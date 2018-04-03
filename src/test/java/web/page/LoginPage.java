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
        LoginElements.LOGIN_FIELD.fillinText(login);
    }
    public void fillinPasswordField(String password){
        LoginElements.PASSWORD_FIELD.fillinText(password);
    }
    public void clickEnterButton(){
        LoginElements.ENTER_BUTTON.click();
    }
}
