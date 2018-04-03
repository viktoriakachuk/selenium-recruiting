package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.element.MenuBarElements;

public class MenuBarPage {
    WebDriver driver = WebDriverSingleton.getInstance();


    public void clickHomeButton(){
        WebDriverWait element = new WebDriverWait(driver, 120);
        element.until(ExpectedConditions.visibilityOfElementLocated(MenuBarElements.HOME_BUTTON.getBy())).click();
    }
    public void clickRecruitingButton(){
        WebDriverWait element = new WebDriverWait(driver, 120);
        element.until(ExpectedConditions.visibilityOfElementLocated(MenuBarElements.RECRUITING_BUTTON.getBy())).click();
    }
    public void clickDirectoriesButton(){
        WebDriverWait element = new WebDriverWait(driver, 120);
        element.until(ExpectedConditions.visibilityOfElementLocated(MenuBarElements.DIRECTORIES_BUTTON.getBy())).click();
    }
}
