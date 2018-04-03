package element;

import driver.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
