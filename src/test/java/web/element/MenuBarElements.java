package web.element;

import element.Element;
import org.openqa.selenium.By;

public class MenuBarElements {

    public static Element HOME_BUTTON = new Element("home button",By.xpath("//a[contains(@href,'guest/home')]"));
    public static Element RECRUITING_BUTTON = new Element("recruiting button",By.xpath("//a[contains(@href,'recruiting')]"));
    public static Element DIRECTORIES_BUTTON = new Element("directories button",By.xpath("//a[contains(@href,'directories')]"));
}
