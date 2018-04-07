package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import web.element.CandidatesListElements;

public class CandidatesListPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterCandidatesListPage(){
        driver.get(CandidatesListElements.URL);
    }
    public void fillinSearchField(String search){
        CandidatesListElements.SEARCH.fillinText(search);
    }
    public void clickClearSearchButton(){
        CandidatesListElements.CLEAR_SEARCH.click();
    }
    public void clickCreateButton(){
        CandidatesListElements.CREATE_BUTTON.click();
    }
    public void selectExperience(String experience){
        CandidatesListElements.EXPERIENCE.selectByText(experience);
    }
    public void checkRelocation(String value){
        CandidatesListElements.RELOCATION.checkboxOptionClassAndValue(value);
    }
    public void checkStatus(String value){
        CandidatesListElements.STATUS.checkboxOptionClassAndValue(value);
    }
    public void checkUniversity(String value){
        CandidatesListElements.UNIVERSITY_BUTTON.click();
        CandidatesListElements.UNIVERSITY.checkboxOptionValue(value);
        CandidatesListElements.UNIVERSITY_BUTTON.click();
    }
    public void checkVacancy(String value){
        CandidatesListElements.VACANCY_BUTTON.click();
        CandidatesListElements.VACANCY.checkboxOptionValue(value);
        CandidatesListElements.VACANCY_BUTTON.click();
    }
    public void checkEducation(String value){
        CandidatesListElements.EDUCATION_BUTTON.click();
        CandidatesListElements.EDUCATION.checkboxOptionValue(value);
        CandidatesListElements.EDUCATION_BUTTON.click();
    }
    public void checkCompetence(String value){
        CandidatesListElements.COMPETENCE_BUTTON.click();
        CandidatesListElements.COMPETENCE.checkboxOptionValue(value);
        CandidatesListElements.COMPETENCE_BUTTON.click();
    }

}
