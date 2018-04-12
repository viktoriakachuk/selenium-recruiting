package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.element.LoginElements;

public class LoginPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вход на страницу авторизации")
    public void enterLoginPage(){
        driver.get(LoginElements.URL);
    }

    @Step("Ввод логина {0}")
    public void fillinLoginField(String login){
        LoginElements.LOGIN_FIELD.fillinText(login);
    }

    @Step("Ввод пароля {0}")
    public void fillinPasswordField(String password){
        LoginElements.PASSWORD_FIELD.fillinText(password);
    }

    @Step("Нажатие кнопки войти ")
    public void clickEnterButton(){
        LoginElements.ENTER_BUTTON.click();
    }
}
