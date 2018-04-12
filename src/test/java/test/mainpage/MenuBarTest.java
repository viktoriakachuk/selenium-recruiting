package test.mainpage;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Переход на главную страницу")
    @Description("Переход на главную страницу")
    @Feature("Меню")
    @Story("Сценарий 1 – Навигация по меню")
    @Severity(SeverityLevel.NORMAL)
    public void loadHomePageFromMenuBar(){
        mbp.clickHomeButton();
        Assert.assertEquals("Главная - Конструктор Талантов",driver.getTitle());
    }
    @Test
    @DisplayName("Переход на страницу подбор и адаптация")
    @Description("Переход на страницу подбор и адаптация")
    @Feature("Меню")
    @Story("Сценарий 1 – Навигация по меню")
    @Severity(SeverityLevel.NORMAL)
    public void loadRecruitingPageFromMenuBar(){
        mbp.clickRecruitingButton();
        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов",driver.getTitle());
    }
    @Test
    @DisplayName("Переход на страницу справочники")
    @Description("Переход на страницу справочники")
    @Feature("Меню")
    @Story("Сценарий 1 – Навигация по меню")
    @Severity(SeverityLevel.NORMAL)
    public void loadDirectoriesPageFromMenuBar(){
        mbp.clickDirectoriesButton();
        Assert.assertEquals("Справочники - Конструктор Талантов",driver.getTitle());
    }

    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }
}
