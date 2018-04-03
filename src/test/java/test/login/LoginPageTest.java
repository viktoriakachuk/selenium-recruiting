package test.login;

import driver.WebDriverSingleton;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    LoginPage lp = new LoginPage();

    @Test
    public void loginAsRecruiterPositive(){
        lp.enterLoginPage();
        lp.fillinLoginField("kabanov@tc.by");
        lp.fillinPasswordField("welcome");
        lp.clickEnterButton();
        WebElement logname = driver.findElement(By.xpath("//a[@class='signed-in']"));
        Assert.assertEquals("Александр Евгеньевич Кабанов", logname.getText());
    }

    @Test
    public void loginAsRecruiterNegativeIncorrectData(){
        lp.enterLoginPage();
        lp.fillinLoginField("kabanov@tc.by");
        lp.fillinPasswordField("hello");
        lp.clickEnterButton();
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", driver.findElement(By.xpath("//*[@id=\"_58_fm\"]/fieldset/div[1]")).getText());
    }

    @Test
    public void loginAsRecruiterNegativeEmptyLoin(){
        lp.enterLoginPage();
        lp.fillinPasswordField("welcome");
        lp.clickEnterButton();
        Assert.assertEquals("Это обязательное поле.",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']//div")).getText());
    }

    @Test
    public void loginAsRecruiterNegativeEmptyPassword(){
        lp.enterLoginPage();
        lp.fillinLoginField("kabanov@tc.by");
        lp.clickEnterButton();
        Assert.assertEquals("Это обязательное поле.",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']//div")).getText());
    }


    @After
    public void shutDown() {

        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}