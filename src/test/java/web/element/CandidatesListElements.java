package web.element;

import element.Element;
import org.openqa.selenium.By;

public class CandidatesListElements {
    public static String URL="http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/";

    //filter elements
    public static Element CLEAR = new Element ("clear filter", By.xpath("//a[@id='filter-clear-link']"));
    public static Element EXPERIENCE = new Element ("work experience", By.xpath("//select[@id='experience']"));
    public static Element STATUS = new Element ("candidate status", By.xpath("//input[@class='statusFilter']"));
    public static Element VACANCY_BUTTON = new Element ("vacancy button", By.xpath("//div[@id='vacancy_filter']//span[@class='multiselect-selected-caret caret']"));
    public static Element VACANCY = new Element ("vacancy", By.xpath("//div[@id='vacancy_filter']//input"));
    public static Element RELOCATION = new Element ("relocation", By.xpath("//input[@class='relocationFilter']"));
    public static Element EDUCATION_BUTTON = new Element ("education button", By.xpath("//div[@id='education_filter']//span[@class='multiselect-selected-caret caret']"));
    public static Element EDUCATION = new Element ("education", By.xpath("//div[@id='education_filter']//input"));
    public static Element UNIVERSITY_BUTTON = new Element ("university button", By.xpath("//div[@id='universities_filter']//span[@class='multiselect-selected-caret caret']"));
    public static Element UNIVERSITY = new Element ("university", By.xpath("//div[@id='universities_filter']//input"));
    public static Element COMPETENCE_BUTTON = new Element ("competence button", By.xpath("//div[@id='competencies_filter']//span[@class='multiselect-selected-caret caret']"));
    public static Element COMPETENCE = new Element ("competence", By.xpath("//div[@id='competencies_filter']//input"));

    //search elements
    public static Element SEARCH = new Element ("search", By.xpath("//input[@placeholder='Поиск...']"));
    public static Element CLEAR_SEARCH = new Element ("clear search", By.xpath("//a[@id='filter-clear-link']"));

    //create element
    public static Element CREATE_BUTTON = new Element ("create button", By.xpath("//a[@id='createProfileButton']"));

    //pagination elements

}
