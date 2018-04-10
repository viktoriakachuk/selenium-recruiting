package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import web.element.CandidateFormElements;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Thread.sleep;

public class CandidateFormPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterCandidateFormPage(){
        driver.get(CandidateFormElements.URL);
    }
    public void fillinSurname(String surname){
        CandidateFormElements.SURNAME.fillinText(surname);
    }
    public void fillinName(String name){
        CandidateFormElements.NAME.fillinText(name);
    }
    public void fillinSecondname(String secondname){
        CandidateFormElements.SECOND_NAME.fillinText(secondname);
    }
    public void fillinTelephone(String telephone){
        CandidateFormElements.TELEPHONE.fillinText(telephone);
    }
    public void fillinEmail(String email){
        CandidateFormElements.EMAIL.fillinText(email);
    }
    public void fillinSkype(String skype){
        CandidateFormElements.SKYPE.fillinText(skype);
    }
    public void fillinCountry(String country){
        CandidateFormElements.COUNTRY.fillinText(country);
    }
    public void fillinCity(String city){
        CandidateFormElements.CITY.fillinText(city);
    }
    public void checkRelocation(){
        CandidateFormElements.RELOCATION.click();
    }
    public void fillinBDDateDay(String day){
        CandidateFormElements.BD_DATE_DAY.fillinText(day);
    }
    public void fillinBDDateMonth(String month){
        CandidateFormElements.BD_DATE_MONTH.fillinText(month);
    }
    public void fillinBDDateYear(String year){
        CandidateFormElements.BD_DATE_YEAR.fillinText(year);
    }
    public void selectEducation(String education){
        CandidateFormElements.EDUCATION.selectByText(education);
    }
    public void fillinPosition(String position){
        CandidateFormElements.POSITION.fillinText(position);
    }
    public void clickSave(){
        CandidateFormElements.SAVE.click();
    }
    public void clickCancel(){
        CandidateFormElements.CANCEL.click();
    }
    public void clickBackToList(){
        CandidateFormElements.BACK_TO_LIST.click();
    }
    public void fillinCompetence(String layer, String category, String competence, String level) throws InterruptedException {
        CandidateFormElements.COMPETENCE_ADD_BUTTON.click();
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(layer,1);
        sleep(2000);
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(category,1);
        sleep(2000);
        CandidateFormElements.COMPETENCE_TREE.liOptionValue(competence,2);
        sleep(2000);
        CandidateFormElements.COMPETENCE_OK_BUTTON.click();
        sleep(4000);
        CandidateFormElements.COMPETENCE_LEVEL_BUTTON.click();
        CandidateFormElements.COMPETENCE_LEVEL.levelValue(level);

    }
    public void delete(){
        CandidateFormElements.DELETE_BUTTON.click();
        CandidateFormElements.DELETE_CONFIRM_BUTTON.click();
    }

    public void loadProfilePic(String picpath) {
        CandidateFormElements.PROFILE_PIC.click();
        sendFile(getAbsolutePath(picpath));

    }
    public void loadAttachment(String attachment, String filepath, String openbutton) throws FindFailed {
        Pattern filePath = new Pattern(filepath);
        Pattern openButton = new Pattern(openbutton);
        CandidateFormElements.ADD_ATTACHMENT.click();
        Screen screen = new Screen();
        screen.wait(filePath, 20);
        screen.type(filePath, getAbsolutePath(attachment));
        screen.click(openButton);

    }

    public void loadCV(String cvpath){
        CandidateFormElements.LOAD_CV_BUTTON.click();
        CandidateFormElements.LOAD_CV_CONFIRM.click();
        sendFile(getAbsolutePath(cvpath));
    }
    private String getAbsolutePath(String file) {
        Path path = Paths.get(file);
        return path.toAbsolutePath().toString();
    }
    private void sendFile(String path) {
        try {
            setClipboardData(path);
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }




}
