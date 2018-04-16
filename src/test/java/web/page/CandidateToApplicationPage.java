package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.element.CandidateToApplicationElements;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class CandidateToApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Отправить на согласование")
    public void clickSendToApprove(){
        CandidateToApplicationElements.APPROVAL_BUTTON.click();
    }
    @Step("Добавить ответственных за рассмотрение и согласование")
    public void addReviewApprovePeople(){
        CandidateToApplicationElements.REVIEW_BUTTON.click();
        CandidateToApplicationElements.REVIEW_RECRUITER_SELECT.click();
        CandidateToApplicationElements.REVIEW_RECRUITER.click();
        CandidateToApplicationElements.REVIEW_RECRUITER_OK.click();
        CandidateToApplicationElements.APPROVE_BUTTON.click();
        CandidateToApplicationElements.APPROVE_RECRUITER_SELECT.click();
        CandidateToApplicationElements.APPROVE_RECRUITER.click();
        CandidateToApplicationElements.APPROVE_RECRUITER_OK.click();
        CandidateToApplicationElements.SEND_APPROVE_BUTTON.click();
    }
    @Step("выход из аккаунта")
    public void logout(){
        CandidateToApplicationElements.LOGOUT.click();

    }
    @Step("открыть уведомления")
    public void openNotifications(){
        CandidateToApplicationElements.NOTIFICATIONS.click();
        CandidateToApplicationElements.NOTIFICATION_TO_APPROVE.click();
    }
    @Step("рассмотрение заявки")
    public void review(String comment) throws InterruptedException {
        CandidateToApplicationElements.REVIEW_NOW_BUTTON.click();
        sleep(2000);
        CandidateToApplicationElements.COMMENT.fillinText(comment);
        CandidateToApplicationElements.FINAL_REVIEW_BUTTON.click();
    }
    @Step("согласование заявки")
    public void approve(){
        CandidateToApplicationElements.APPROVE_NOW_BUTTON.click();
    }
    public void createVacancy() throws InterruptedException, AWTException {
        sleep(2000);
        CandidateToApplicationElements.CREATE_VACANCY_BUTTON.click();
        sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        CandidateToApplicationElements.SAVE_VACANCY_BUTTON.click();
    }
    @Step("открытие вакансии")
    public void openVacancy(){
        CandidateToApplicationElements.OPEN_VACANCY_BUTTON.click();
    }
    @Step("публикация вакансии")
    public void publishVacancy(){
        CandidateToApplicationElements.SAVE_AD_BUTTON.click();
        CandidateToApplicationElements.PUBLISH_BUTTON.click();
    }
}
