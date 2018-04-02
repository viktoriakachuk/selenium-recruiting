package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import web.element.ApplicationElements;

import static java.lang.Thread.sleep;

public class ApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterApplicationPage(){
        driver.get(ApplicationElements.URL);
    }


    public void fillinPositionField(String position) throws InterruptedException {
        WebElement element = driver.findElement(ApplicationElements.POSITION);
        element.clear();
        element.sendKeys(position);
        sleep(2000);
    }
    public void fillinClosingDate(String date){
        WebElement element = driver.findElement(ApplicationElements.CLOSING_DATE);
        element.clear();
        element.sendKeys(date);
    }
    public void clickPriorityRadio(){
        WebElement element = driver.findElement(ApplicationElements.PRIORITY);
        element.click();
    }
    public void fillinQuantityField(String quantity){
        WebElement element = driver.findElement(ApplicationElements.QUANTITY);
        element.clear();
        element.sendKeys(quantity);
    }
    public void fillinReasonField(String reason){
        WebElement element = driver.findElement(ApplicationElements.REASON);
        element.clear();
        element.sendKeys(reason);
    }
    public void clickContractTypeRadio(){
        WebElement element = driver.findElement(ApplicationElements.CONTRACT_TYPE);
        element.click();
    }
    public void fillinSalaryField(String salary){
        WebElement element = driver.findElement(ApplicationElements.SALARY);
        element.clear();
        element.sendKeys(salary);
    }
    public void selectCurrency(String currency){
        WebElement element = driver.findElement(ApplicationElements.CURRENCY);
        Select select = new Select(element);
        select.selectByVisibleText(currency);
    }
    public void selectJobType(String jobType){
        WebElement element = driver.findElement(ApplicationElements.JOB_TYPE);
        Select select = new Select(element);
        select.selectByVisibleText(jobType);
    }
    public void fillinEmployeesField(String employees){
        WebElement element = driver.findElement(ApplicationElements.EMPLOYEES);
        element.clear();
        element.sendKeys(employees);
    }
    public void fillinBusinessTripField(String btrip){
        WebElement element = driver.findElement(ApplicationElements.BUSINESS_TRIP);
        element.clear();
        element.sendKeys(btrip);
    }
    public void fillinTimetableField(String timetable){
        WebElement element = driver.findElement(ApplicationElements.TIMETABLE);
        element.clear();
        element.sendKeys(timetable);
    }

    public void fillinProbationField(String probation){
        WebElement element = driver.findElement(ApplicationElements.PROBATION_PERIOD);
        element.clear();
        element.sendKeys(probation);
    }
    public void fillinResponsibilitiesField(String responsibilities){
        WebElement element = driver.findElement(ApplicationElements.RESPONSIBILITIES);
        element.clear();
        element.sendKeys(responsibilities);
    }
    public void clickCandidateType(){
        WebElement element = driver.findElement(ApplicationElements.CANDIDATE_TYPE);
        element.click();
    }
    public void selectEducation(String education){
        WebElement element = driver.findElement(ApplicationElements.EDUCATION);
        Select select = new Select(element);
        select.selectByVisibleText(education);
    }
    public void fillinSpecializationField(String specialization){
        WebElement element = driver.findElement(ApplicationElements.SPECIALIZATION);
        element.clear();
        element.sendKeys(specialization);
    }
    public void selectExperience(String experience){
        WebElement element = driver.findElement(ApplicationElements.EXPERIENCE);
        Select select = new Select(element);
        select.selectByVisibleText(experience);
    }
    public void fillinPriorityExperienceField(String priorityExperience){
        WebElement element = driver.findElement(ApplicationElements.PRIORITY_EXPERIENCE);
        element.clear();
        element.sendKeys(priorityExperience);
    }
    public void fillinUndesirableExperienceField(String undesirableExperience){
        WebElement element = driver.findElement(ApplicationElements.UNDESIRABLE_EXPERIENCE);
        element.clear();
        element.sendKeys(undesirableExperience);
    }

    public void fillinCommentField(String comment){
        WebElement element = driver.findElement(ApplicationElements.COMMENT);
        element.clear();
        element.sendKeys(comment);
    }

    public void fillinCompetence() throws InterruptedException {
        WebElement el = driver.findElement(ApplicationElements.COMPETENCE_ADD_BUTTON);
        el.click();
        WebElement element = driver.findElement(ApplicationElements.COMPETENCE_LAYER);
        element.click();
        WebElement element0 = driver.findElement(ApplicationElements.COMPETENCE_GROUP);
        element0.click();
        WebElement element1 = driver.findElement(ApplicationElements.COMPETENCE);
       /* element1.click();
        element1.click();*/
       /* WebElement element2 = driver.findElement(ApplicationElements.COMPETENCE_OK_BUTTON);
        element2.click();*/
        Actions action = new Actions(driver); action.doubleClick(element1); action.perform();
        sleep(2000);
        WebElement okButton = driver.findElement(ApplicationElements.COMPETENCE_OK_BUTTON);
        sleep(2000);
        okButton.click();
    }

    public void save(){
        WebElement element = driver.findElement(ApplicationElements.SAVE_BUTTON);
        element.click();
    }





}
