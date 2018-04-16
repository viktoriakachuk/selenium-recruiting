package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.element.QuestionsElements;

import java.awt.*;
import java.awt.event.KeyEvent;

public class QuestionsPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вход на страницу вопросов")
    public void enterQuestionsPage(){
        driver.get(QuestionsElements.URL);
    }
    @Step("Переключение на вкладку база вопросов")
    public void switchToQuestionsDBPage(){
       QuestionsElements.DB.click();
    }
    @Step("нажатие кнопки добавить вопрос")
    public void clickAddQuestionButton(){
        QuestionsElements.ADD_BUTTON.click();
    }
    @Step("ввод вопроса {0}")
    public void fillinQuestion(String question){
        QuestionsElements.QUESTION.fillinText(question);
    }
    @Step("ввод ответа {0}")
    public void fillinAnswer(String answer){
        QuestionsElements.ANSWER.fillinText(answer);
    }
    @Step("ввод компетенции {0}")
    public void fillinCompetence(String competence) throws AWTException {
        QuestionsElements.COMPETENCE.fillinText(competence);
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    @Step("нажатие кнопки сохранить")
    public void clickSaveButton(){
        QuestionsElements.SAVE.click();
    }

    @Step("нажатие кнопки добавить в базу вопросов")
    public void clickAddPersonalQuestion() {
        QuestionsElements.ADD_PERSONAL_BUTTON.click();
    }
}
