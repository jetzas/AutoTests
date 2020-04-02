package core.Web.UI.Events;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.*;

public class EventHandler extends JSWaiter implements WebDriverEventListener {


    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        waitUntilJSReady();
    }


    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        waitJQueryAngular();
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        waitJQueryAngular();
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        waitJQueryAngular();
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        waitJQueryAngular();
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
       // waitForAngularLoad();
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        waitJQueryAngular();
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        waitJQueryAngular();
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
    }


    @Override
    public void afterNavigateBack(WebDriver arg0) {
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
    }

    /***
     * Events for JS script
     * @param arg0 JS script
     * @param arg1 selenium driver
     */
    @Override
    public void afterScript(String arg0, WebDriver arg1) {
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {

    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        waitJQueryAngular();

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}