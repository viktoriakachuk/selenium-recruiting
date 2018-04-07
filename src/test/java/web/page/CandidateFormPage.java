package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.element.CandidateFormElements;

import static java.lang.Thread.sleep;

public class CandidateFormPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterCandidateFormPage(){
        driver.get(CandidateFormElements.URL);
    }
    public void fillinSurname(String surname){
        CandidateFormElements.SURNAME.fillinText(surname);
    }
    public void fillinName(String name){
        CandidateFormElements.NAME.fillinText(name);
    }
    public void fillinSecondname(String secondname){
        CandidateFormElements.SECOND_NAME.fillinText(secondname);
    }
    public void fillinTelephone(String telephone){
        CandidateFormElements.TELEPHONE.fillinText(telephone);
    }
    public void fillinEmail(String email){
        CandidateFormElements.EMAIL.fillinText(email);
    }
    public void fillinSkype(String skype){
        CandidateFormElements.SKYPE.fillinText(skype);
    }
    public void fillinCountry(String country){
        CandidateFormElements.COUNTRY.fillinText(country);
    }
    public void fillinCity(String city){
        CandidateFormElements.CITY.fillinText(city);
    }
    public void checkRelocation(){
        CandidateFormElements.RELOCATION.click();
    }
    public void fillinBDDateDay(String day){
        CandidateFormElements.BD_DATE_DAY.fillinText(day);
    }
    public void fillinBDDateMonth(String month){
        CandidateFormElements.BD_DATE_MONTH.fillinText(month);
    }
    public void fillinBDDateYear(String year){
        CandidateFormElements.BD_DATE_YEAR.fillinText(year);
    }
    public void selectEducation(String education){
        CandidateFormElements.EDUCATION.selectByText(education);
    }
    public void fillinPosition(String position){
        CandidateFormElements.POSITION.fillinText(position);
    }
    public void clickSave(){
        CandidateFormElements.SAVE.click();
    }
    public void clickCancel(){
        CandidateFormElements.CANCEL.click();
    }
    public void clickBackToList(){
        CandidateFormElements.BACK_TO_LIST.click();
    }
    public void fillinCompetence(String layer, String category, String competence, String level) throws InterruptedException {
        CandidateFormElements.COMPETENCE_ADD_BUTTON.click();
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(layer,1);
        sleep(2000);
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(category,1);
        sleep(2000);
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(competence,2);
        sleep(2000);
        CandidateFormElements.COMPETENCE_OK_BUTTON.click();
        sleep(4000);
        CandidateFormElements.COMPETENCE_LEVEL_BUTTON.click();
        CandidateFormElements.COMPETENCE_LEVEL.levelValue(level);

    }
    public void delete(){
        CandidateFormElements.DELETE_BUTTON.click();
        CandidateFormElements.DELETE_CONFIRM_BUTTON.click();
    }




}
