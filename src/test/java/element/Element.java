package element;

import driver.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class Element {
    String name;
    By by;

    public Element(String name, By by) {
        this.name = name;
        this.by = by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public Boolean isElementPresent(){
        try{
            getWebElement();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public WebElement getWebElement() {
        return WebDriverSingleton.getInstance().findElement(by);
    }

    public void assertPresence() {
        Assert.assertTrue("Элемент " + name + " не существует на странице", isElementPresent());
    }

    public void click() {
        assertPresence();
        getWebElement().click();
    }

    public String getText() {
        assertPresence();
        return getWebElement().getText();
    }

    public void fillinText(String text) {
        assertPresence();
        WebElement element = getWebElement();
        element.clear();
        element.sendKeys(text);
    }
    public void selectByText(String option){
        assertPresence();
        Select select = new Select(getWebElement());
        select.selectByVisibleText(option);
    }
    public void checkboxOptionClassAndValue(String value){
        assertPresence();
        String checkboxClass;
        checkboxClass = getWebElement().getAttribute("class");
        WebElement element = WebDriverSingleton.getInstance().findElement(By.xpath("//input[@class='" + checkboxClass + "' and @value='" + value + "']"));
        element.click();
    }
    public void checkboxOptionValue(String value){
        assertPresence();
        WebElement element = WebDriverSingleton.getInstance().findElement(By.xpath("//input[@value='" + value + "']"));
        element.click();
    }
    public void liOptionValue(String value, int click){
        assertPresence();
        WebElement element = WebDriverSingleton.getInstance().findElement(By.xpath("//li[@id='" + value + "']"));
        if (click==1){element.click();}
        else if(click==2){
            Actions action = new Actions(WebDriverSingleton.getInstance());
            action.doubleClick(element);
            action.perform();
        }

    }
    public void levelValue(String value){
        assertPresence();
        WebElement element = WebDriverSingleton.getInstance().findElement(By.xpath("//div[@data-value='" + value + "']"));
        element.click();
    }
}
