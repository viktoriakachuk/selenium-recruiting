package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import web.element.ApplicationElements;

import static java.lang.Thread.sleep;

public class ApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вход на страницу создание заявки")
    public void enterApplicationPage(){
        driver.get(ApplicationElements.URL);
    }


    @Step("Ввод должности {0}")
    public void fillinPositionField(String position) throws InterruptedException {
        ApplicationElements.POSITION.fillinText(position);
        sleep(2000);
    }

    @Step("Ввод даты закрытия {0}")
    public void fillinClosingDate(String date){
        ApplicationElements.CLOSING_DATE.fillinText(date);
    }

    @Step("Выбор приоритета")
    public void clickPriorityRadio(){
        ApplicationElements.PRIORITY.click();
    }

    @Step("Ввод количества требуемых сотрудников {0}")
    public void fillinQuantityField(String quantity){
        ApplicationElements.QUANTITY.fillinText(quantity);
    }

    @Step("Ввод причины создания заявки {0}")
    public void fillinReasonField(String reason){
        ApplicationElements.REASON.fillinText(reason);
    }

    @Step("Выбор типа договора")
    public void clickContractTypeRadio(){
        ApplicationElements.CONTRACT_TYPE.click();
    }

    @Step("Ввод зарплаты {0}")
    public void fillinSalaryField(String salary){
        ApplicationElements.SALARY.fillinText(salary);
    }

    @Step("Ввод валюты {0}")
    public void selectCurrency(String currency){
        ApplicationElements.CURRENCY.selectByText(currency);
    }

    @Step("Выбор типа занятости {0}")
    public void selectJobType(String jobType){
        ApplicationElements.JOB_TYPE.selectByText(jobType);
    }

    @Step("Ввод наличия подчиненных {0}")
    public void fillinEmployeesField(String employees){
        ApplicationElements.EMPLOYEES.fillinText(employees);
    }

    @Step("Ввод командировок {0}")
    public void fillinBusinessTripField(String btrip){
        ApplicationElements.BUSINESS_TRIP.fillinText(btrip); ;
    }

    @Step("Ввод графика работы {0}")
    public void fillinTimetableField(String timetable){
        ApplicationElements.TIMETABLE.fillinText(timetable);
    }

    @Step("Ввод продолжительности испытательного срока {0}")
    public void fillinProbationField(String probation){
        ApplicationElements.PROBATION_PERIOD.fillinText(probation);
    }

    @Step("Ввод обязанностей {0}")
    public void fillinResponsibilitiesField(String responsibilities){
        ApplicationElements.RESPONSIBILITIES.fillinText(responsibilities);
    }

    @Step("Выбор типа кандидата")
    public void clickCandidateType(){
        ApplicationElements.CANDIDATE_TYPE.click();
    }

    @Step("Выбор образования {0}")
    public void selectEducation(String education){
        ApplicationElements.EDUCATION.selectByText(education);
    }

    @Step("Ввод специальности {0}")
    public void fillinSpecializationField(String specialization){
        ApplicationElements.SPECIALIZATION.fillinText(specialization);
    }

    @Step("Выбор опыта работы {0}")
    public void selectExperience(String experience){
        ApplicationElements.EXPERIENCE.selectByText(experience);
    }

    @Step("Ввод приоритетных организаций опыт {0}")
    public void fillinPriorityExperienceField(String priorityExperience){
        ApplicationElements.PRIORITY_EXPERIENCE.fillinText(priorityExperience);
    }

    @Step("Ввод нежелательных организаций опыт {0}")
    public void fillinUndesirableExperienceField(String undesirableExperience){
        ApplicationElements.UNDESIRABLE_EXPERIENCE.fillinText(undesirableExperience);
    }

    @Step("Ввод комментария {0}")
    public void fillinCommentField(String comment){
        ApplicationElements.COMMENT.fillinText(comment);
    }

    @Step("Заполнение компетенции")
    public void fillinCompetence(String layer, String category, String competence) throws InterruptedException {
        ApplicationElements.COMPETENCE_ADD_BUTTON.click();
        ApplicationElements.COMPETENCE_TREE.liOptionValue(layer,1);
        sleep(2000);
        ApplicationElements.COMPETENCE_TREE.liOptionValue(category,1);
        sleep(2000);
        ApplicationElements.COMPETENCE_TREE.liOptionValue(competence,2);
        sleep(2000);
        ApplicationElements.COMPETENCE_OK_BUTTON.click();

    }

    @Step("Сохранение")
    public void save(){
        ApplicationElements.SAVE_BUTTON.click();
    }

}
