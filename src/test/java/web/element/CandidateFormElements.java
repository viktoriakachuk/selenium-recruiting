package web.element;

import element.Element;
import org.openqa.selenium.By;

public class CandidateFormElements {
    public static String URL="http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile";
    public static Element SURNAME = new Element ("surname", By.xpath("//input[@id='surname']"));
    public static Element NAME = new Element ("name", By.xpath("//input[@id='name']"));
    public static Element SECOND_NAME = new Element ("second name", By.xpath("//input[@id='secondName']"));
    public static Element TELEPHONE = new Element ("primary telephone", By.xpath("//input[@id='primaryTelephone']"));
    public static Element EMAIL = new Element ("primary email", By.xpath("//input[@id='primaryEmail']"));
    public static Element SKYPE = new Element ("skype", By.xpath("//input[@id='skype']"));
    public static Element COUNTRY = new Element ("country", By.xpath("//input[@id='country']"));
    public static Element CITY = new Element ("city", By.xpath("//input[@id='city']"));
    public static Element RELOCATION = new Element ("relocation is able", By.xpath("//input[@id='relocation']"));
    public static Element BD_DATE_DAY = new Element ("date of birth day", By.xpath("//input[@id='dateOfBirthDay']"));
    public static Element BD_DATE_MONTH = new Element ("date of birth month", By.xpath("//input[@id='dateOfBirthMonth']"));
    public static Element BD_DATE_YEAR = new Element ("date of birth year", By.xpath("//input[@id='dateOfBirthYear']"));
    public static Element EDUCATION = new Element ("education", By.xpath("//select[@id='education']"));
    public static Element POSITION = new Element ("desired position", By.xpath("//input[@id='desiredPosition']"));
    public static Element COMPETENCE_ADD_BUTTON = new Element("add/edit competence button", By.xpath("//a[@id='editCompetence']"));
    public static Element COMPETENCE_TREE = new Element ("competencies tree", By.xpath("//div[@id='competenciesTree']"));
    public static Element COMPETENCE_LEVEL = new Element("competence level", By.xpath("//div[@class='scale-level-row']"));
    public static Element COMPETENCE_LEVEL_BUTTON = new Element ("competence level button", By.xpath("//td[@class='competence-level']//span[@class='caret dropdown-caret pull-right']"));
    public static Element COMPETENCE_OK_BUTTON = new Element("competence ok button",By.xpath("//button[text()='OK']"));
    public static Element SAVE = new Element("save button", By.xpath("//a[@id='saveButton']"));
    public static Element CANCEL = new Element("cancel button", By.xpath("//a[@id='cancelButton']"));
    public static Element LOAD_CV_BUTTON = new Element ("load cv button", By.xpath("//span[@id='loadCVLink']"));
    public static Element LOAD_CV_CONFIRM = new Element("load cv confirm button", By.xpath("//button[text()='OK']"));
    public static Element BACK_TO_LIST = new Element("back to the candidates list", By.xpath("//a[contains(@href,'recruiting/candidates/-/candidates')]"));
    public static Element ADD_ATTACHMENT = new Element("add attachment", By.xpath("//i[@class='fa fa-plus add-attachment']"));
    public static Element DELETE_BUTTON = new Element("delete candidate button",By.xpath("//a[@id='removeButton']"));
    public static Element DELETE_CONFIRM_BUTTON = new Element("delete candidate confirm button",By.xpath("//button[text()='Удалить']"));
    public static Element PROFILE_PIC = new Element("load profile picture button", By.id("changeImgLink"));

}
