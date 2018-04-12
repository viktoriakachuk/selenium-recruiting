package test.recruiting.candidates;

import driver.WebDriverSingleton;
import helper.GeneratorMode;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Login;
import web.page.CandidatesListPage;

import java.io.IOException;

import static helper.Helper.closeBrowser;
import static helper.Helper.generateRandomString;
import static java.lang.Thread.sleep;

public class CandidatesListTest extends Login {

    final String EXPERIENCE_TEST_VALUE = "От 3 лет"; //от 3 лет
    final String STATUS_TEST_VALUE = "New"; //новый
    final String RELOCATION_TEST_VALUE = "true"; //возможен переезд
    final String VACANCY_TEST_VALUE = "2"; //дизайнер
    final String EDUCATION_TEST_VALUE = "4"; //высшее
    final String UNIVERSITY_TEST_VALUE = "БГУИР"; //БГУИР
    final String COMPETENCE_TEST_VALUE = "222"; //английский язык

    private WebDriver driver = WebDriverSingleton.getInstance();

    CandidatesListPage clp = new CandidatesListPage();

    @Before
    public void doLoginAsRecruiter(){
        super.login("recruiter");
    };
    @Test
    @DisplayName("поиск кандидата успех")
    @Description("поиск кандидата успех")
    @Feature("Подбор и адаптация: кандидаты")
    @Story("Сценарий 2 – список кандидатов")
    @Severity(SeverityLevel.NORMAL)
    public void searchPositive() throws InterruptedException {
        clp.enterCandidatesListPage();
        clp.fillinSearchField("морозова");
        sleep(2000);
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fio']"))).getText();
        Assert.assertEquals("Морозова Екатерина Алексеевна",message);
        //ASSERT correct candidate was found
        //db connection required
    }
    @Test
    @DisplayName("поиск кандидат не найден")
    @Description("поиск кандидат не найден")
    @Feature("Подбор и адаптация: кандидаты")
    @Story("Сценарий 2 – список кандидатов")
    @Severity(SeverityLevel.NORMAL)
    public void searchNegative() throws InterruptedException {
        clp.enterCandidatesListPage();
        clp.fillinSearchField(generateRandomString(12, GeneratorMode.ALPHA));
        sleep(2000);
        WebDriverWait element = new WebDriverWait(driver, 120);
        String message = element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tc-alert[@id='emptyListSearch']//div[@class='message']"))).getText();
        Assert.assertEquals("Список кандидатов пуст",message);
    }

    @Test
    @DisplayName("нажатие кнопки создать резюме")
    @Description("нажатие кнопки создать резюме")
    @Feature("Подбор и адаптация: кандидаты")
    @Story("Сценарий 2 – список кандидатов")
    @Severity(SeverityLevel.NORMAL)
    public void clickCreate() throws InterruptedException {
        clp.enterCandidatesListPage();
        sleep(7000);
        clp.clickCreateButton();
        Assert.assertEquals("Создание резюме - Конструктор Талантов",driver.getTitle());
    }

    @Test
    @DisplayName("фильтрация успех")
    @Description("фильтрация успех")
    @Feature("Подбор и адаптация: кандидаты")
    @Story("Сценарий 2 – список кандидатов")
    @Severity(SeverityLevel.NORMAL)
    public void filterPositive() throws InterruptedException {
        clp.enterCandidatesListPage();
        sleep(5000);
        clp.selectExperience(EXPERIENCE_TEST_VALUE);
        sleep(5000);
        clp.checkStatus(STATUS_TEST_VALUE);
        sleep(5000);
        clp.checkRelocation(RELOCATION_TEST_VALUE);
        sleep(7000);
        clp.checkVacancy(VACANCY_TEST_VALUE);
        sleep(7000);
        clp.checkEducation(EDUCATION_TEST_VALUE);
        sleep(7000);
        clp.checkUniversity(UNIVERSITY_TEST_VALUE);
        sleep(7000);
        clp.checkCompetence(COMPETENCE_TEST_VALUE);
        sleep(7000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='filterTagsPanel' and div]")).isEnabled());

        //ASSERT correct candidate was found
        //db connection required


    }

   /* @Test
    public void filterNegative(){
        //ASSERT no candidate matches filter
        //db connection required

    }*/

    @Test
    @DisplayName("сброс параметров фильтра")
    @Description("сброс параметров фильтра")
    @Feature("Подбор и адаптация: кандидаты")
    @Story("Сценарий 2 – список кандидатов")
    @Severity(SeverityLevel.NORMAL)
    public void filterClear() throws InterruptedException {
        clp.enterCandidatesListPage();
        sleep(2000);
        clp.selectExperience(EXPERIENCE_TEST_VALUE);
        sleep(2000);
        clp.clickClearSearchButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='filterTagsPanel' and not(div)]")).isEnabled());

    }

   /* @Test
    public void pagination(){

    }*/

   /* @Test
    public void checkCandidatesList(){
        //db connection required
    }*/


    @After
    public void shutDown() throws IOException {
        closeBrowser();
    }
}
