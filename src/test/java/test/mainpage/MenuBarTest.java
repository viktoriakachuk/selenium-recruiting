package test.mainpage;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Login;
import web.page.LoginPage;
import web.page.MenuBarPage;

import java.awt.*;
import java.io.IOException;

import static helper.Helper.closeBrowser;

public class MenuBarTest extends Login {
    private WebDriver driver = WebDriverSingleton.getInstance();

    MenuBarPage mbp = new MenuBarPage();

    @Before
    public void doLoginAsRecruiter(){
        super.login("recruiter");
    };


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
    public void shutDown() throws IOException {
        closeBrowser();
    }
}
