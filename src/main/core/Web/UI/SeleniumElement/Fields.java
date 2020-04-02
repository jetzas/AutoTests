package core.Web.UI.SeleniumElement;

import core.Utility.*;
import java.util.*;
import org.openqa.selenium.*;

public class Fields extends Element {

    /***************Get All Elements Settings*******************/

    public String getTxt(By locator) {
        return waitUntilVisible(locator).getText();
    }

    public String getTxt(WebElement element) {
        return waitUntilVisible(element).getText();
    }

    /*****************************/

    public void typeOnExist(By locator, String text) {
        waitUntilExist(locator).clear();
        waitUntilExist(locator).sendKeys(text);
    }

    public void type(By locator, String text) {
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(text);
    }


    public String getValueFromField(By  locator) {
      return   waitUntilClickable(locator).getAttribute("value");
    }

    public String getValueFromNotClicableField(By  locator) {
        return   waitUntilVisible(locator).getAttribute("value");
    }

    public String getValueFromField(WebElement element) {
        return  waitUntilClickable(element).getAttribute("value");
    }

    public String getPlaceholder(By locator) {
        return waitUntilVisible(locator).getAttribute("placeholder");
    }

    public void type(By locator, Keys key) {
        waitUntilClickable(locator).sendKeys(key);
    }

    public void type(WebElement element, String text) {
        waitUntilClickable(element).clear();
        waitUntilClickable(element).sendKeys(text);
    }

    public void sendValue(By locator, String text) {

        cleanByBackSpace(locator);
        waitUntilClickable(locator).sendKeys(text);
    }

    public void sendValue(WebElement element, String text) {

        cleanByBackSpace(element);
        waitUntilClickable(element).sendKeys(text);
        element.sendKeys(Keys.TAB);
    }

    public void cleanField(WebElement element) {

        waitUntilClickable(element).clear();
    }

    public void cleanField(By locator) {

        waitUntilClickable(locator).clear();
    }

    public void cleanByBackSpace(By locator) {

        for (int i = 0; i < 5; i++) {
            waitUntilClickable(locator).sendKeys(Keys.BACK_SPACE);
        }
    }

    public void cleanByBackSpace(WebElement element) {
        for (int i = 0; i < 5; i++) {
            waitUntilClickable(element).sendKeys(Keys.BACK_SPACE);
        }
    }
    public void sendKey(By locator, Keys key) {
        waitUntilClickable(locator).sendKeys(key);
    }


    public void sendKey(WebElement element, Keys key) {
        waitUntilClickable(element).sendKeys(key);
    }

    public boolean checkElementsOnText(String text, By messagesList) {
        List<WebElement> elements = getElementsList(messagesList);
        for (WebElement element : elements) {
            String str = getTxt(element);
            if (getTxt(element).contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void typeAndCheckValue(By element, String text) {
        String actual;
        int tries = 5;
        do {
            waitUntilClickable(element).clear();
            waitUntilClickable(element).sendKeys(text);
            actual = getValueFromField(element);
            tries--;
        }
        while (!text.equals(actual) && tries > 0);

    }

    public boolean isEmpty(By element) {
        return waitUntilVisible(element).getText().isEmpty();
    }
}
