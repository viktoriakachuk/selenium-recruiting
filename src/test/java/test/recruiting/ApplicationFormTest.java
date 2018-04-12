package test.recruiting;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Login;
import web.page.ApplicationPage;
import web.page.LoginPage;

import java.io.IOException;

import static helper.Helper.closeBrowser;
import static java.lang.Thread.sleep;

public class ApplicationFormTest extends Login {
    private WebDriver driver = WebDriverSingleton.getInstance();

    ApplicationPage ap = new ApplicationPage();
    final String LAYER_TEST_VALUE = "layer_2"; // уровень профессиональные компетенции
    final String CATHEGORY_TEST_VALUE = "category_2476"; //категория компьютерные программы для ведению бухучета
    final String COMPETENCE_TEST_VALUE = "competence_2477"; //компетенция 1С

    @Before
    public void doLoginAsRecruiter(){
        super.login("recruiter");
    };

    @Test
    @DisplayName("создание заявки успех")
    @Description("Создание заявки")
    @Feature("Подбор и адаптация: заявки")
    @Story("Сценарий 1 – создание заявки")
    @Severity(SeverityLevel.NORMAL)
    public void fillinApplicationPositive() throws InterruptedException {
        ap.enterApplicationPage();
        sleep(2000);
        ap.fillinPositionField("Бухгалтер");
        sleep(1000);
        ap.fillinClosingDate("02.04.2018");
        ap.clickPriorityRadio();
        ap.fillinQuantityField("2");
        ap.fillinReasonField("Расширение отдела");
        ap.clickContractTypeRadio();
        ap.fillinSalaryField("500");
        ap.selectCurrency("USD");
        ap.selectJobType("Полная занятость");
        ap.fillinEmployeesField("-");
        ap.fillinBusinessTripField("Да, раз в полгода");
        ap.fillinTimetableField("9:00-18:00");
        ap.fillinProbationField("1 месяц");
        ap.fillinResponsibilitiesField("Ведение бухгалтерской отчетности");
        ap.clickCandidateType();
        ap.selectEducation("Высшее");
        ap.fillinSpecializationField("Бухгалтерский учет анализ аудит");
        ap.selectExperience("От 3 лет");
        ap.fillinPriorityExperienceField("госучреждения");
        ap.fillinUndesirableExperienceField("-");
        ap.fillinCompetence(LAYER_TEST_VALUE,CATHEGORY_TEST_VALUE,COMPETENCE_TEST_VALUE);
        sleep(2000);
        ap.fillinCommentField("полный соцпакет");
        ap.save();
        sleep(3000);
        Assert.assertEquals("Заявка успешно сохранена", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
    }

    @Test
    @DisplayName("пустая должность")
    @Description("пустая должность")
    @Feature("Подбор и адаптация: заявки")
    @Story("Сценарий 1 – создание заявки")
    @Severity(SeverityLevel.MINOR)
    public void fillinApplicationNegativeEmptyPosition(){
        ap.enterApplicationPage();
        Assert.assertEquals("Обязательное поле",driver.findElement(By.xpath("//div[@class='required']")).getText());
        ap.save();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);
    }

  /*  @Test
    @DisplayName("пустой тип кандидата")
    @Description("пустой тип кандидата")
    @Feature("Подбор и адаптация: заявки")
    @Story("Сценарий 1 – создание заявки")
    @Severity(SeverityLevel.MINOR)
    public void fillinApplicationNegativeEmptyCandidateType() throws InterruptedException {
        ap.enterApplicationPage();
        ap.fillinPositionField("Бухгалтер");
        Assert.assertEquals("Выберите тип кандидатов",driver.findElement(By.xpath("//div[@class='help-block help']")).getText());
        ap.save();

        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);
    }*/
    @Test
    @DisplayName("пустые компетенции")
    @Description("пустые компетенции")
    @Feature("Подбор и адаптация: заявки")
    @Story("Сценарий 1 – создание заявки")
    @Severity(SeverityLevel.MINOR)
    public void fillinApplicationNegativeEmptyCompetence() throws InterruptedException {
        ap.enterApplicationPage();
        ap.fillinPositionField("Бухгалтер");
        ap.clickCandidateType();
        sleep(2000);
        ap.save();
        sleep(3000);
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nВыберите хотя бы одну обязательную компетенцию",message);
    }

    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }
}
