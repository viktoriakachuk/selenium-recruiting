package test.recruiting;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.Login;
import web.page.ApplicationPage;
import web.page.CandidateToApplicationPage;

import java.awt.*;
import java.io.IOException;

import static helper.GeneratorMode.ALPHA;
import static helper.GeneratorMode.NUMERIC;
import static helper.Helper.closeBrowser;
import static helper.Helper.generateRandomString;

import static java.lang.Thread.sleep;

public class CandidateToApplicationTest extends Login {
    private WebDriver driver = WebDriverSingleton.getInstance();
    ApplicationPage ap = new ApplicationPage();
    CandidateToApplicationPage cap = new CandidateToApplicationPage();
    final String LAYER_TEST_VALUE = "layer_2"; // уровень профессиональные компетенции
    final String CATHEGORY_TEST_VALUE = "category_2476"; //категория компьютерные программы для ведению бухучета
    final String COMPETENCE_TEST_VALUE = "competence_2477"; //компетенция 1С

    @Test
    @DisplayName("рассмотрение и согласование заявки, публикация вакансии")
    @Description("рассмотрение и согласование заявки, публикация вакансии")
    @Feature("Подбор и адаптация: взаимодействие заявок, вакансий и кандидатов")
    @Story("Сценарий 1 – создание вакансии из заявки")
    @Severity(SeverityLevel.NORMAL)
    public void approveApplication() throws InterruptedException, AWTException {
        super.login("recruiter");
        ap.enterApplicationPage();
        sleep(2000);
        ap.fillinPositionField("Бухгалтер");
        sleep(1000);
        ap.fillinClosingDate("20.04.2018");
        ap.fillinQuantityField("1");
        ap.fillinSalaryField("600");
        ap.selectCurrency("USD");
        ap.clickCandidateType();
        ap.selectEducation("Высшее");
        ap.fillinCompetence(LAYER_TEST_VALUE,CATHEGORY_TEST_VALUE,COMPETENCE_TEST_VALUE);
        sleep(2000);
        ap.save();
        sleep(3000);
        Assert.assertEquals("Заявка успешно сохранена", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());

        cap.clickSendToApprove();
        cap.addReviewApprovePeople();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()=' На согласовании ']")).isEnabled());
        sleep(2000);
        cap.logout();


        super.login("krmadmin");
        cap.openNotifications();
        sleep(2000);
        cap.review(generateRandomString(5,ALPHA));
        sleep(2000);
        Assert.assertEquals("Заявка была рассмотрена", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        sleep(5000);

        cap.approve();
        sleep(2000);
        Assert.assertEquals("Заявка была согласована",driver.findElement(By.xpath("//span[@id='successMessage']")).getText());

        cap.createVacancy();
        sleep(2000);
        Assert.assertEquals("Вакансия успешно создана", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        sleep(2000);
        cap.openVacancy();
        sleep(2000);
        Assert.assertEquals("Вакансия была успешно открыта",driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        sleep(2000);
        cap.publishVacancy();
        sleep(2000);
        Assert.assertEquals("Опубликована",driver.findElement(By.xpath("//span[@id='adStatusLabel']")).getText());
    }
    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }

}
