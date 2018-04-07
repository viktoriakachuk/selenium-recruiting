package test.recruiting.candidates;

import driver.WebDriverSingleton;
import helper.GeneratorMode;
import helper.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Login;
import web.page.CandidateFormPage;

import java.io.IOException;

import static helper.GeneratorMode.ALPHA;
import static helper.GeneratorMode.NUMERIC;
import static helper.Helper.closeBrowser;
import static helper.Helper.generateRandomString;
import static java.lang.Thread.sleep;

public class CandidateFormTest extends Login {
    private WebDriver driver = WebDriverSingleton.getInstance();

    CandidateFormPage cfp = new CandidateFormPage();

    final String EMAIL_TEST_VALUE = "xxx@yyy.com";
    final String DAY_TEST_VALUE = "12";
    final String MONTH_TEST_VALUE = "10";
    final String YEAR_TEST_VALUE = "1984";
    final String LAYER_TEST_VALUE = "layer_2"; // уровень профессиональные компетенции
    final String CATHEGORY_TEST_VALUE = "category_2476"; //категория компьютерные программы для ведению бухучета
    final String COMPETENCE_TEST_VALUE = "competence_2477"; //компетенция 1С
    final String COMPETENCE_LEVEL_TEST_VALUE = "50"; //уровень владения компетенцией базовый

    @Before
    public void doLoginAsRecruiter(){
        super.login("recruiter");
    }
    @Test
    public void fillinCandidateFormPositive() throws InterruptedException {
        cfp.enterCandidateFormPage();
        sleep(2000);
        cfp.fillinSurname(generateRandomString(5,ALPHA));
        cfp.fillinName(generateRandomString(5,ALPHA));
        cfp.fillinSecondname(generateRandomString(5,ALPHA));
        cfp.fillinTelephone(generateRandomString(7,NUMERIC));
        cfp.fillinEmail(EMAIL_TEST_VALUE);
        cfp.fillinSkype(generateRandomString(5,ALPHA));
        cfp.fillinCountry(generateRandomString(5,ALPHA));
        cfp.fillinCity(generateRandomString(5,ALPHA));
        cfp.checkRelocation();
        cfp.fillinBDDateDay(DAY_TEST_VALUE);
        cfp.fillinBDDateMonth(MONTH_TEST_VALUE);
        cfp.fillinBDDateYear(YEAR_TEST_VALUE);
        cfp.selectEducation("Высшее");
        cfp.fillinPosition(generateRandomString(5,ALPHA));
        //load profile photo
        //add attachment
        cfp.fillinCompetence(LAYER_TEST_VALUE,CATHEGORY_TEST_VALUE,COMPETENCE_TEST_VALUE,COMPETENCE_LEVEL_TEST_VALUE);
        cfp.clickSave();
        Assert.assertEquals("Резюме было успешно сохранено", driver.findElement(By.xpath("//span[@id='successMessage']")).getText());
        //assert new entry
        //db connection required
    }

    @Test
    public void fillinCandidateFormNegativeEmptySurname(){
        cfp.enterCandidateFormPage();
        cfp.fillinName(generateRandomString(5,ALPHA));
        cfp.fillinTelephone(generateRandomString(7,NUMERIC));
        cfp.fillinEmail(EMAIL_TEST_VALUE);
        cfp.clickSave();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);

    }
    @Test
    public void fillinCandidateFormNegativeEmptyName(){
        cfp.enterCandidateFormPage();
        cfp.fillinSurname(generateRandomString(5,ALPHA));
        cfp.fillinTelephone(generateRandomString(7,NUMERIC));
        cfp.fillinEmail(EMAIL_TEST_VALUE);
        cfp.clickSave();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nПроверьте обязательные поля",message);

    }
    @Test
    public void fillinCandidateFormNegativeEmptyContactData(){
        cfp.enterCandidateFormPage();
        cfp.fillinSurname(generateRandomString(5,ALPHA));
        cfp.fillinName(generateRandomString(5,ALPHA));
        cfp.clickSave();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']"))).getText();
        Assert.assertEquals("Ошибка!\nНеверно введены контактные данные. Введите правильно адрес электронной почты или телефон",message);
    }
    @Test
    public void fillinCandidateFormNegativeIncorrectTelephone(){
        cfp.enterCandidateFormPage();
        cfp.fillinTelephone(generateRandomString(5,ALPHA));
        cfp.fillinEmail(EMAIL_TEST_VALUE);
        Assert.assertEquals("Неверный формат номера",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']")).getText());
    }
    @Test
    public void fillinCandidateFormNegativeIncorrectEmail(){
        cfp.enterCandidateFormPage();
        cfp.fillinEmail(generateRandomString(5,ALPHA));
        cfp.fillinTelephone(generateRandomString(7,NUMERIC));
        Assert.assertEquals("Неверный ввод",driver.findElement(By.xpath("//div[@class='form-validator-stack help-inline']")).getText());
    }

    @Test
    public void fillinCandidateFormNegativeIncorrectBirthDate(){
        cfp.enterCandidateFormPage();
        cfp.fillinBDDateDay(generateRandomString(3,NUMERIC));
        cfp.fillinBDDateMonth(generateRandomString(3,NUMERIC));
        cfp.fillinBDDateYear(generateRandomString(5,NUMERIC));
        cfp.fillinPosition(generateRandomString(8,ALPHA));
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validateDate']"))).getText();
        Assert.assertEquals("Неверный ввод",message);
    }

    @Test
    public void clickCancel(){
        cfp.enterCandidateFormPage();
        cfp.clickCancel();
        Assert.assertEquals("Кандидаты - Конструктор Талантов", driver.getTitle());
    }
    @Test
    public void clickBackToList() throws InterruptedException {
        cfp.enterCandidateFormPage();
        sleep(3000);
        cfp.clickBackToList();
        Assert.assertEquals("Кандидаты - Конструктор Талантов", driver.getTitle());
    }
    @Test
    public void loadCV(){
        //ASSERT
    }

    @Test
    public void deleteCandidate() throws InterruptedException {
        cfp.enterCandidateFormPage();
        cfp.fillinName(generateRandomString(5,ALPHA));
        cfp.fillinSurname(generateRandomString(5, ALPHA));
        cfp.fillinTelephone(generateRandomString(7,NUMERIC));
        cfp.clickSave();
        sleep(2000);
        cfp.delete();
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='successMessage']"))).getText();
        Assert.assertEquals("Профиль кандидата был успешно удален из системы",message);

        //assert entry does not exist anymore
        //db connection required
    }
    @Test
    public void editCandidate(){

    }
    @Test
    public void exportCandidate(){

    }

    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }
}
