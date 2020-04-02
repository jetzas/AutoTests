package core.Web.UI.SeleniumElement;

import core.Web.UI.InitialDriver.*;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static core.Utility.Base.*;

public class Element {

    protected WebDriver driver=InitialDriver.getInstance().getDriver();


    void sleep(int ms)
    {

	    try {
            Thread.sleep(ms);
        }
	    catch (InterruptedException e) {
		    e.printStackTrace();
	    }
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

    /**
     * Status of element
     * Get status of element
     *
     * @param webElementExpectedCondition WebElement element,By locator
     * @return getWebElement(ExpectedConditions.elementToBeClickable ( element));
     */
    public WebElement getWebElement(ExpectedCondition<WebElement> webElementExpectedCondition) {
        return waitElement().until(webElementExpectedCondition);
    }
    public WebElement getWebElementIsPresent(ExpectedCondition<WebElement> webElementExpectedCondition) {
        return waitElementIsPresent().until(webElementExpectedCondition);
    }
///waitElementIsPresent
    /**
     * Status of element
     * Get status of element
     *
     * @param stateElementExpectedCondition WebElement element,By locator
     * @return getWebStateOfElement(ExpectedConditions.elementToBeSelected ( element));
     */
    public boolean getWebStateOfElement(ExpectedCondition<Boolean> stateElementExpectedCondition) {
        return waitElement().until(stateElementExpectedCondition);
    }
    private WebDriverWait waitElementIsPresent()
    {
        return    waitElementTime(EXIST);
    }
    private WebDriverWait waitElement()
    {
        return    waitElementTime(TIME_OUT);
    }
    /**
     * It webDriver wait for all element
     *
     * @return
     */
    private WebDriverWait waitElementTime(long delai) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(ElementClickInterceptedException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        wait.ignoring(ElementClickInterceptedException.class);
        return wait;
    }


    public WebElement waitUntilClickable(By locator) {
        return getWebElement(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilClickable(WebElement element) {
        return getWebElement(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilVisible(WebElement element) {
        return getWebElement(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisible(By locator) {
        return getWebElement(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilExist(By locator) {
        return getWebElement(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isPresent(By locator) {
        try {
            getWebElementIsPresent(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }
      catch (Exception ex)
      {
          return false;
      }
    }

    public boolean isSelected(WebElement element) {
        return getWebStateOfElement(ExpectedConditions.elementToBeSelected(element));
    }

    public boolean isSelected(By locator) {
        return getWebStateOfElement(ExpectedConditions.elementToBeSelected(locator));
    }
    public boolean isClickable(By locator) {
//        waitUntilVisible(locator);
        return  waitUntilVisible(locator).isEnabled();
//        return getWebElement(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }

    public boolean isClickable(WebElement element) {
        return getWebElement(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }
    public boolean isVisibility(By locator) {

        return getWebElement(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public boolean isVisibility(WebElement element) {
        return getWebElement(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean waitUntilClassEquals(By locator, String className) {
        return getWebStateOfElement(ExpectedConditions.attributeToBe(locator, "class", className));
    }

    public boolean waitUntilInvisible(By locator) {
        return getWebStateOfElement(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitUntilInvisible(WebElement element) {
        return getWebStateOfElement(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitUntilTextIsContained(By locator, String text) {
        return getWebStateOfElement(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean waitUntilTextPresent(By locator, String text) {
        return getWebStateOfElement(ExpectedConditions.textToBe(locator, text));
    }

    public boolean waitUntilTextPresent(WebElement element, String text) {
        return getWebStateOfElement(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean waitUntilTextNotPresent(By locator, String text) {
        return getWebStateOfElement(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public List<WebElement> selectFromList(By locator) {
        waitUntilClickable(locator);
        return driver.findElements(locator);
    }

    public WebElement findElementByXpath(By by) {
        return driver.findElement(by);
    }


}
