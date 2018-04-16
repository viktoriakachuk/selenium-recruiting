package web.element;

import element.Element;
import org.openqa.selenium.By;

public class CandidateToApplicationElements {
    //kabanov
    public static Element APPROVAL_BUTTON = new Element ("send to approval button", By.xpath("//a[@id='sendToApprovalButton']"));
    public static Element REVIEW_BUTTON = new Element ("add perdon to review", By.xpath("//a[@id='review']"));
    public static Element APPROVE_BUTTON = new Element ("add perdon to approve", By.xpath("//a[@id='approve']"));
    public static Element REVIEW_RECRUITER_SELECT = new Element ("select review recruiter", By.xpath("//button[@prof='Recruiter']"));
    public static Element REVIEW_RECRUITER = new Element ("check review recruiter", By.xpath("//label[text()='Соколов Роман']"));
    public static Element REVIEW_RECRUITER_OK = new Element ("ok button", By.xpath("//button[text()='Ок']"));
    public static Element APPROVE_RECRUITER_SELECT = new Element ("select approve recruiter", By.xpath("//button[@prof='Recruiter']"));
    public static Element APPROVE_RECRUITER = new Element ("check approve recruiter", By.xpath("//label[text()='Соколов Роман']"));
    public static Element APPROVE_RECRUITER_OK = new Element ("ok button", By.xpath("//button[text()='Ок']"));
    public static Element SEND_APPROVE_BUTTON = new Element("send to approve", By.xpath("//a[@id='approveButton']"));
    public static Element LOGOUT = new Element("logout button", By.xpath("//a[contains(@href,'logout')]"));

    //sokolov
    public static Element NOTIFICATIONS = new Element ("notifications bell", By.xpath("//a[@class='dropdown-toggle user-notification-link']"));
    public static Element NOTIFICATION_TO_APPROVE = new Element ("notification to approve", By.xpath("//a[text()='Бухгалтер']"));
    public static Element REVIEW_NOW_BUTTON = new Element ("review now button", By.xpath("//a[@id='reviewButton']"));
    public static Element COMMENT = new Element ("review comment", By.xpath("//textarea[@placeholder='Введите комментарий']"));
    public static Element FINAL_REVIEW_BUTTON = new Element ("final review button", By.xpath("//button[text()='Рассмотреть']"));
    public static Element APPROVE_NOW_BUTTON = new Element ("approve now button", By.xpath("//a[@id='approveButton']"));
    public static Element CREATE_VACANCY_BUTTON = new Element ("create vacancy", By.xpath("//a[text()='Создать вакансию']"));
    public static Element SAVE_VACANCY_BUTTON = new Element ("save vacancy button", By.xpath("//a[@id='saveButton']"));
    public static Element OPEN_VACANCY_BUTTON = new Element ("open vacancy button", By.xpath("//a[@id='openButton']"));
    public static Element SAVE_AD_BUTTON = new Element ("save ad button", By.xpath("//a[@id='saveAdButton']"));
    public static Element PUBLISH_BUTTON = new Element ("publish button", By.xpath("//a[@id='publishButton']"));





}
