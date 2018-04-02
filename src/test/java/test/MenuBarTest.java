package test;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.page.LoginPage;
import web.page.MenuBarPage;

import java.awt.*;

public class MenuBarTest {
    private WebDriver driver = WebDriverSingleton.getInstance();

    MenuBarPage mbp = new MenuBarPage();

    @Before
    public void login(){
        LoginPage lp = new LoginPage();
        lp.enterLoginPage();
        lp.fillinLoginField("kabanov@tc.by");
        lp.fillinPasswordField("welcome");
        lp.clickEnterButton();
    }


    @Test
    public void loadHomePageFromMenuBar(){
        mbp.clickHomeButton();
        Assert.assertEquals("Главная - Конструктор Талантов",driver.getTitle());
    }
    @Test
    public void loadRecruitingPageFromMenuBar(){
        mbp.clickRecruitingButton();
        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов",driver.getTitle());
    }
    @Test
    public void loadDirectoriesPageFromMenuBar(){
        mbp.clickDirectoriesButton();
        Assert.assertEquals("Справочники - Конструктор Талантов",driver.getTitle());
    }

    @After
    public void shutDown() {

        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
