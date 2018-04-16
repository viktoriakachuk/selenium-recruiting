package web.element;

import element.Element;
import org.openqa.selenium.By;

public class QuestionsElements {
    public static String URL="http://testing.cld.iba.by/web/guest/recruiting/questions";
    public static Element DB = new Element ("questions db", By.xpath("//a[text()='База вопросов']"));
    public static Element ADD_BUTTON = new Element("add question button",By.xpath("//a[@id='addBtn']"));
    public static Element QUESTION = new Element("textfield question",By.xpath("//textarea[@id='questionText']"));
    public static Element ANSWER = new Element("textfield answer",By.xpath("//textarea[@id='questionAnswer']"));
    public static Element COMPETENCE = new Element("competence", By.xpath("//input[@type='text']"));
    public static Element SAVE = new Element("save question button", By.xpath("//a[@id='saveQuestionButton']"));
    public static Element CANCEL = new Element("cancel question button", By.xpath("//a[@id='cancelQuestionButton']"));


    public static Element ADD_PERSONAL_BUTTON = new Element ("add personal question to db", By.xpath("//i[@class='add-question-icon fa fa-copy']"));

}
