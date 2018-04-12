package test.login;

import driver.WebDriverSingleton;
import helper.GeneratorMode;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.page.LoginPage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static helper.Helper.closeBrowser;
import static helper.Helper.generateRandomString;

public class LoginPageTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    LoginPage lp = new LoginPage();
    final String LOGIN_TEST_VALUE = "kabanov@tc.by";
    final String PASSWORD_TEST_VALUE = "welcome";

    @Test
    @DisplayName("авторизация успех")
    @Description("Авторизация успех")
    @Feature("Авторизация")
    @Story("Сценарий 1 – Авторизация главный рекрутер Кабанов")
    @Severity(SeverityLevel.CRITICAL)
    public void loginAsRecruiterPositive(){
        lp.enterLoginPage();
        lp.fillinLoginField(LOGIN_TEST_VALUE);
        lp.fillinPasswordField(PASSWORD_TEST_VALUE);
        lp.clickEnterButton();
        WebElement logname = driver.findElement(By.xpath("//a[@class='signed-in']"));
        Assert.assertEquals("Александр Евгеньевич Кабанов", logname.getText());
    }

    @Test
    @DisplayName("неверный пароль")
    @Description("Авторизация неверный пароль")
    @Feature("Авторизация")
    @Story("Сценарий 1 – Авторизация главный рекрутер Кабанов")
    @Severity(SeverityLevel.NORMAL)
    public void loginAsRecruiterNegativeIncorrectData(){
        lp.enterLoginPage();
        lp.fillinLoginField(LOGIN_TEST_VALUE);
        lp.fillinPasswordField(generateRandomString(5, GeneratorMode.ALPHA));
        lp.clickEnterButton();
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", driver.findElement(By.xpath("//*[@id=\"_58_fm\"]/fieldset/div[1]")).getText());
    }

    @Test
    @DisplayName("пустой логин")
    @Description("Авторизация пустой логин")
    @Feature("Авторизация")
    @Story("Сценарий 1 – Авторизация главный рекрутер Кабанов")
    @Severity(SeverityLevel.MINOR)
    public void loginAsRecruiterNegativeEmptyLoin(){
        lp.enterLoginPage();
        lp.fillinPasswordField(PASSWORD_TEST_VALUE);
        lp.clickEnterButton();
        Assert.assertEquals("Это обязательное поле.",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']//div")).getText());
    }

    @Test
    @DisplayName("пустой пароль")
    @Description("Авторизация пустой пароль")
    @Feature("Авторизация")
    @Story("Сценарий 1 – Авторизация главный рекрутер Кабанов")
    @Severity(SeverityLevel.MINOR)
    public void loginAsRecruiterNegativeEmptyPassword(){
        lp.enterLoginPage();
        lp.fillinLoginField(LOGIN_TEST_VALUE);
        lp.clickEnterButton();
        Assert.assertEquals("Это обязательное поле.",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']//div")).getText());
    }


    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }
}