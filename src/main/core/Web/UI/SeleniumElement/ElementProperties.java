package core.Web.UI.SeleniumElement;

import java.io.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static core.Utility.Base.*;


public class ElementProperties extends Element {

    private WebElement getWebElementExisr(ExpectedCondition<WebElement> webElementExpectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, EXIST);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        wait.ignoring(UnknownError.class);
        wait.until(webElementExpectedCondition);
        return wait.until(webElementExpectedCondition);
    }

    public String getAttribute(By locator, String attribute) {
        return waitUntilClickable(locator).getAttribute(attribute);
    }

    public String getAttributeValue(By locator) {
        return waitUntilClickable(locator).getAttribute("value");
    }

    public boolean getAttributeDisabled(By locator) {
        return Boolean.parseBoolean(waitUntilExist(locator).getAttribute("disabled"));
    }

    public String getCssValueBackground(By locator) {
        return waitUntilVisible(locator).getCssValue("background");
    }

    public boolean isPresent(By locator) {
        try {
            return getWebElementExisr(ExpectedConditions.presenceOfElementLocated(locator)) != null;
        } catch (TimeoutException ex) {
            return false;
        }
    }
    public boolean isSelected(By locator) {
        return getWebElementExisr(ExpectedConditions.elementToBeClickable(locator)) .isSelected();
    }

    public boolean isDisplayed(By locator) {
        try {

            return getWebElementExisr(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        }
        catch (Exception ex)
        {
            return  false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {

            return getWebElementExisr(ExpectedConditions.visibilityOf(element)) != null;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        return getWebElementExisr(ExpectedConditions.elementToBeClickable(element)) != null;
    }

    public boolean isEnabled(By locator) {
        return getWebElementExisr(ExpectedConditions.elementToBeClickable(locator)) != null;
    }


    public List<WebElement> getElementsList(By locator) {
        waitUntilExist(locator);
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }


    public WebElement getElementFromList(By locator, int index) {
        waitUntilExist(locator);
        List<WebElement> elements = driver.findElements(locator);
        return elements.get(index);
    }

    public void uploadFile(By locator,String pathToFile)//D:\Project\GF_Project\src\resources
    {
        WebElement uploadElement = waitUntilClickable(locator);
        uploadElement.sendKeys(System.getProperty("user.dir")+ File.separator+"src" + File.separator+"resources"+File.separator+pathToFile);
        waitUntilClickable(locator);
    }

    public String getTxt(By locator) {
        return waitUntilVisible(locator).getText();
    }

    public String getTxt(WebElement element) {
        return waitUntilVisible(element).getText();
    }
}
