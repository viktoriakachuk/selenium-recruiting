package web.element;

import element.Element;
import org.openqa.selenium.By;

public class LoginElements {

    public static String URL = "http://testing.cld.iba.by";
    public static Element LOGIN_FIELD = new Element("login",By.xpath("//*[@id=\"_58_login\"]"));
    public static Element PASSWORD_FIELD = new Element("password",By.xpath("//*[@id=\"_58_password\"]"));
    public static Element ENTER_BUTTON = new Element("enter button",By.xpath("//button[@class='btn btn-primary']"));
}
