package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.element.CandidatesListElements;

public class CandidatesListPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вход на страницу кандидатов")
    public void enterCandidatesListPage(){
        driver.get(CandidatesListElements.URL);
    }

    @Step("Ввод поисковых данных {0}")
    public void fillinSearchField(String search){
        CandidatesListElements.SEARCH.fillinText(search);
    }

    @Step("Очистка фильтра")
    public void clickClearSearchButton(){
        CandidatesListElements.CLEAR_SEARCH.click();
    }

    @Step("Нажатие кнопки создания резюме")
    public void clickCreateButton(){
        CandidatesListElements.CREATE_BUTTON.click();
    }

    @Step("Выбор опыта работы {0}")
    public void selectExperience(String experience){
        CandidatesListElements.EXPERIENCE.selectByText(experience);
    }

    @Step("Выбор возможности переезда {0}")
    public void checkRelocation(String value){
        CandidatesListElements.RELOCATION.checkboxOptionClassAndValue(value);
    }

    @Step("Выбор статуса резюме {0}")
    public void checkStatus(String value){
        CandidatesListElements.STATUS.checkboxOptionClassAndValue(value);
    }

    @Step("Выбор университета {0}")
    public void checkUniversity(String value){
        CandidatesListElements.UNIVERSITY_BUTTON.click();
        CandidatesListElements.UNIVERSITY.checkboxOptionValue(value);
        CandidatesListElements.UNIVERSITY_BUTTON.click();
    }

    @Step("Выбор вакансии {0}")
    public void checkVacancy(String value){
        CandidatesListElements.VACANCY_BUTTON.click();
        CandidatesListElements.VACANCY.checkboxOptionValue(value);
        CandidatesListElements.VACANCY_BUTTON.click();
    }

    @Step("Выбор образования {0}")
    public void checkEducation(String value){
        CandidatesListElements.EDUCATION_BUTTON.click();
        CandidatesListElements.EDUCATION.checkboxOptionValue(value);
        CandidatesListElements.EDUCATION_BUTTON.click();
    }

    @Step("Выбор коспетенции {0}")
    public void checkCompetence(String value){
        CandidatesListElements.COMPETENCE_BUTTON.click();
        CandidatesListElements.COMPETENCE.checkboxOptionValue(value);
        CandidatesListElements.COMPETENCE_BUTTON.click();
    }

}
