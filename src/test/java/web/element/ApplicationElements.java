package web.element;

import element.Element;
import org.openqa.selenium.By;

public class ApplicationElements {
    public static String URL="http://testing.cld.iba.by/web/guest/recruiting/applications/-/applications/createApplication";
    public static Element POSITION = new Element ("position(name)",By.xpath("//input[@id='name']"));
    public static Element CLOSING_DATE = new Element ("closing date",By.xpath("//input[@id='plannedClosingDate']"));
    public static Element PRIORITY = new Element("priority",By.xpath("//input[@id='priority-2']"));
    public static Element QUANTITY = new Element("quantity", By.xpath("//input[@id='quantity']"));
    public static Element REASON = new Element("reason",By.xpath("//textarea[@id='creationReason']"));
    public static Element CONTRACT_TYPE = new Element("contract type",By.xpath("//input[@id='contractType-1']"));
    public static Element SALARY = new Element("salary",By.xpath("//input[@id='salary']"));
    public static Element CURRENCY = new Element("salary currency",By.xpath("//select[@id='currency']"));
    public static Element JOB_TYPE = new Element("job type",By.xpath("//select[@id='jobType']"));
    public static Element EMPLOYEES = new Element("has employees",By.xpath("//input[@id='employees']"));
    public static Element BUSINESS_TRIP = new Element("business trips", By.xpath("//input[@id='businessTrip']"));
    public static Element TIMETABLE = new Element("work timetible",By.xpath("//input[@id='timetable']"));
    public static Element PROBATION_PERIOD = new Element("probabition period",By.xpath("//input[@id='probationPeriod']"));
    public static Element RESPONSIBILITIES = new Element("responsibilities", By.xpath("//textarea[@id='responsibilities']"));
    public static Element CANDIDATE_TYPE = new Element("candidate type",By.xpath("//input[@id='candidateTypeInternal']"));
    public static Element EDUCATION = new Element("education",By.xpath("//select[@id='education']"));
    public static Element SPECIALIZATION = new Element("needed specialization",By.xpath("//textarea[@id='educationSpecialization']"));
    public static Element EXPERIENCE = new Element("experience",By.xpath("//select[@id='experience']"));
    public static Element PRIORITY_EXPERIENCE = new Element("companies priority experience",By.xpath("//textarea[@id='priority.working.experience']"));
    public static Element UNDESIRABLE_EXPERIENCE = new Element("companies undesirable experience",By.xpath("//textarea[@id='undesirableWorkingExperience']"));
    public static Element COMPETENCE_ADD_BUTTON = new Element("competence add button",By.xpath("//a[@id='editrequiredCompetence']"));
    public static Element COMPETENCE_LAYER = new Element("competence layer",By.xpath("//*[@id=\"layer_2\"]"));
    public static Element COMPETENCE_GROUP = new Element("competence group",By.xpath("//*[@id=\"category_2476\"]"));
    public static Element COMPETENCE = new Element("competence",By.xpath("//*[@id=\"competence_2477\"]"));
    public static Element COMPETENCE_OK_BUTTON = new Element("competence ok button",By.xpath("//button[text()='OK']"));
    public static Element COMMENT = new Element("comment",By.xpath("//textarea[@id='comment']"));
    public static Element SAVE_BUTTON = new Element("save button",By.xpath("//button[@id='save']"));

    public static By REQUIRED_POSITION = By.xpath("//div[@class='required']");
}
