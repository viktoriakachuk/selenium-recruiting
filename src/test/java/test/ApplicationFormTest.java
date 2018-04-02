package test;

import driver.WebDriverSingleton;
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
import web.page.ApplicationPage;
import web.page.LoginPage;

import static java.lang.Thread.sleep;

public class ApplicationFormTest {
    private WebDriver driver = WebDriverSingleton.getInstance();

    ApplicationPage ap = new ApplicationPage();

    @Before
    public void login(){
        LoginPage lp = new LoginPage();
        lp.enterLoginPage();
        lp.fillinLoginField("kabanov@tc.by");
        lp.fillinPasswordField("welcome");
        lp.clickEnterButton();
    }

    @Test
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
        ap.fillinCompetence();
        sleep(2000);
        ap.fillinCommentField("полный соцпакет");
        ap.save();
        Assert.assertEquals("Заявка успешно сохранена", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
    }

    @Test
    public void fillinApplicationNegativeEmptyPosition(){
        ap.enterApplicationPage();
        Assert.assertEquals("Обязательное поле",driver.findElement(By.xpath("//div[@class='required']")).getText());
        ap.save();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);
    }

    @Test
    public void fillinApplicationNegativeEmptyCandidateType() throws InterruptedException {
        ap.enterApplicationPage();
        ap.fillinPositionField("Бухгалтер");
        Assert.assertEquals("Выберите тип кандидатов",driver.findElement(By.xpath("//div[@class='help-block help']")).getText());
        ap.save();

        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);
    }
    @Test
    public void fillinApplicationNegativeEmptyCompetence() throws InterruptedException {
        ap.enterApplicationPage();
        ap.fillinPositionField("Бухгалтер");
        ap.clickCandidateType();
        ap.save();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nВыберите хотя бы одну обязательную компетенцию",message);
    }

    @After
    public void shutDown() {

        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
