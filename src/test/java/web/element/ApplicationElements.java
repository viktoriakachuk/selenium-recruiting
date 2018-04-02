package web.element;

import org.openqa.selenium.By;

public class ApplicationElements {
    public static String URL="http://testing.cld.iba.by/web/guest/recruiting/applications/-/applications/createApplication";
    public static By POSITION = By.xpath("//input[@id='name']");
    public static By CLOSING_DATE = By.xpath("//input[@id='plannedClosingDate']");
    public static By PRIORITY = By.xpath("//input[@id='priority-2']");
    public static By QUANTITY = By.xpath("//input[@id='quantity']");
    public static By REASON = By.xpath("//textarea[@id='creationReason']");
    public static By CONTRACT_TYPE = By.xpath("//input[@id='contractType-1']");
    public static By SALARY = By.xpath("//input[@id='salary']");
    public static By CURRENCY = By.xpath("//select[@id='currency']");
    public static By JOB_TYPE = By.xpath("//select[@id='jobType']");
    public static By EMPLOYEES = By.xpath("//input[@id='employees']");
    public static By BUSINESS_TRIP = By.xpath("//input[@id='businessTrip']");
    public static By TIMETABLE = By.xpath("//input[@id='timetable']");
    public static By PROBATION_PERIOD = By.xpath("//input[@id='probationPeriod']");
    public static By RESPONSIBILITIES = By.xpath("//textarea[@id='responsibilities']");
    public static By CANDIDATE_TYPE = By.xpath("//input[@id='candidateTypeInternal']");
    public static By EDUCATION = By.xpath("//select[@id='education']");
    public static By SPECIALIZATION = By.xpath("//textarea[@id='educationSpecialization']");
    public static By EXPERIENCE = By.xpath("//select[@id='experience']");
    public static By PRIORITY_EXPERIENCE = By.xpath("//textarea[@id='priority.working.experience']");
    public static By UNDESIRABLE_EXPERIENCE = By.xpath("//textarea[@id='undesirableWorkingExperience']");
    public static By COMPETENCE_ADD_BUTTON = By.xpath("//a[@id='editrequiredCompetence']");
    public static By COMPETENCE_LAYER = By.xpath("//*[@id=\"layer_2\"]");
    public static By COMPETENCE_GROUP = By.xpath("//*[@id=\"category_2476\"]");
    public static By COMPETENCE = By.xpath("//*[@id=\"competence_2477\"]");
    public static By COMPETENCE_OK_BUTTON = By.xpath("//button[text()='OK']");
    public static By COMMENT = By.xpath("//textarea[@id='comment']");
    public static By SAVE_BUTTON = By.xpath("//button[@id='save']");

    public static By REQUIRED_POSITION = By.xpath("//div[@class='required']");
}
