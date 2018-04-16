package test.recruiting;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.Login;
import web.page.QuestionsPage;

import java.awt.*;
import java.io.IOException;

import static helper.Helper.closeBrowser;
import static java.lang.Thread.sleep;

public class QuestionsTest extends Login {
    private WebDriver driver = WebDriverSingleton.getInstance();

    QuestionsPage qp = new QuestionsPage();


    @Before
    public void doLoginAsKRMAdmin(){
        super.login("krmadmin");
    };

    @Test
    @DisplayName("создание нового вопроса и добавление в базу вопросов")
    @Description("создание нового вопроса и добавление в базу вопросов")
    @Feature("Подбор и адаптация: вопросы")
    @Story("Сценарий 1 – добавление нового вопроса")
    @Severity(SeverityLevel.NORMAL)
    public void addNewQuestionPositive() throws AWTException, InterruptedException {
        qp.enterQuestionsPage();
        qp.switchToQuestionsDBPage();
        sleep(2000);
        qp.clickAddQuestionButton();
        sleep(2000);
        qp.fillinQuestion("Как Вы видите себя через 3 года");
        qp.fillinAnswer("Работником компании");
        qp.fillinCompetence("mysql");
        qp.clickSaveButton();
        sleep(2000);
        Assert.assertEquals("Вопрос успешно сохранен",driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        //assert db connection required
    }

  /*  @Test
    @DisplayName("добавление в базу вопросов персонального вопроса")
    @Description("добавление в базу вопросов персонального вопроса")
    @Feature("Подбор и адаптация: вопросы")
    @Story("Сценарий 2 – добавление вопроса из персональных")
    @Severity(SeverityLevel.NORMAL)
    public void addPersonalQuestion() throws AWTException, InterruptedException {
        qp.enterQuestionsPage();

       // qp.searchForQuestion("");
        qp.clickAddPersonalQuestion();

        Assert.assertEquals("Вопрос успешно сохранен",driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        //assert db connection required
    }*/

    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }

}
