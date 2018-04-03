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
        ApplicationElements.POSITION.fillinText(position);
        sleep(2000);
    }
    public void fillinClosingDate(String date){
        ApplicationElements.CLOSING_DATE.fillinText(date);
    }
    public void clickPriorityRadio(){
        ApplicationElements.PRIORITY.click();
    }
    public void fillinQuantityField(String quantity){
        ApplicationElements.QUANTITY.fillinText(quantity);
    }
    public void fillinReasonField(String reason){
        ApplicationElements.REASON.fillinText(reason);
    }
    public void clickContractTypeRadio(){
        ApplicationElements.CONTRACT_TYPE.click();
    }
    public void fillinSalaryField(String salary){
        ApplicationElements.SALARY.fillinText(salary);
    }
    public void selectCurrency(String currency){
        ApplicationElements.CURRENCY.selectByText(currency);
    }
    public void selectJobType(String jobType){
        ApplicationElements.JOB_TYPE.selectByText(jobType);
    }
    public void fillinEmployeesField(String employees){
        ApplicationElements.EMPLOYEES.fillinText(employees);
    }
    public void fillinBusinessTripField(String btrip){
        ApplicationElements.BUSINESS_TRIP.fillinText(btrip); ;
    }
    public void fillinTimetableField(String timetable){
        ApplicationElements.TIMETABLE.fillinText(timetable);
    }

    public void fillinProbationField(String probation){
        ApplicationElements.PROBATION_PERIOD.fillinText(probation);
    }
    public void fillinResponsibilitiesField(String responsibilities){
        ApplicationElements.RESPONSIBILITIES.fillinText(responsibilities);
    }
    public void clickCandidateType(){
        ApplicationElements.CANDIDATE_TYPE.click();
    }
    public void selectEducation(String education){
        ApplicationElements.EDUCATION.selectByText(education);
    }
    public void fillinSpecializationField(String specialization){
        ApplicationElements.SPECIALIZATION.fillinText(specialization);
    }
    public void selectExperience(String experience){
        ApplicationElements.EXPERIENCE.selectByText(experience);
    }
    public void fillinPriorityExperienceField(String priorityExperience){
        ApplicationElements.PRIORITY_EXPERIENCE.fillinText(priorityExperience);
    }
    public void fillinUndesirableExperienceField(String undesirableExperience){
        ApplicationElements.UNDESIRABLE_EXPERIENCE.fillinText(undesirableExperience);
    }

    public void fillinCommentField(String comment){
        ApplicationElements.COMMENT.fillinText(comment);
    }

    public void fillinCompetence() throws InterruptedException {
        ApplicationElements.COMPETENCE_ADD_BUTTON.click();
        ApplicationElements.COMPETENCE_LAYER.click();
        ApplicationElements.COMPETENCE_GROUP.click();
        WebElement element1 = driver.findElement(ApplicationElements.COMPETENCE.getBy());
        Actions action = new Actions(driver); action.doubleClick(element1); action.perform();
        sleep(2000);
        WebElement okButton = driver.findElement(ApplicationElements.COMPETENCE_OK_BUTTON.getBy());
        sleep(2000);
        okButton.click();
    }

    public void save(){
        ApplicationElements.SAVE_BUTTON.click();
    }

}
