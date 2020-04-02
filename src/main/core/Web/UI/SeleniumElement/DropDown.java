package core.Web.UI.SeleniumElement;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class DropDown extends Element{

    public String getSelected(By locator) {
        waitUntilClickable(locator);
        Select select = new Select(waitUntilClickable(locator));
        return select.getFirstSelectedOption().getText();
    }


    public int getlength(By locator) {
        Select select = new Select(waitUntilClickable(locator));
        return select.getOptions().size();
    }

    public void selectDropDownByIndex (By locator, int index) {
        Select select = new Select(waitUntilClickable(locator));
        sleep(1000);
        select.selectByIndex(index);
    }


    public void selectDropDownByValue (By locator, String value) {
        Select select = new Select(waitUntilClickable(locator));
        select.selectByValue(value);
    }

    public void selectDropDownByValue (WebElement locator, String value) {
        Select select = new Select(waitUntilClickable(locator));
        select.selectByValue(value);
    }


    public void selectItemFromDropDownByTest(By locator, String value) {
        Select select = new Select(waitUntilVisible(locator));
        select.selectByVisibleText(value);
    }
}
