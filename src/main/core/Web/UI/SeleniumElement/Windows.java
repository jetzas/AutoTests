package core.Web.UI.SeleniumElement;

import java.util.*;

public class Windows extends Element {

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchBetweenTabs(int tabIndex) {
        String parentHandle = new ArrayList<>(driver.getWindowHandles()).get(0);
        String anyTabName = new ArrayList<>(driver.getWindowHandles()).get(tabIndex);
        driver.switchTo().window(anyTabName);
        System.setProperty("current.window.handle", parentHandle);
    }

    public int checkPopUpIsClosed() {
        return driver.getWindowHandles().size();
    }


    public void closeChild() {
        selectChild();
        driver.close();
    }

    public void getText(){
        getText();
    }

    public void selectParent() {
        String parent = driver.getWindowHandle();
        for (String parentHandle : driver.getWindowHandles()) {
            if (parentHandle.equals(parent)) {
                driver.switchTo().window(parentHandle);
            }
        }
    }
    public void selectChild() {
        String parent = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parent)) {
                driver.switchTo().window(childHandle);
            }
        }
    }

    public void allertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void allertAccept() {
        driver.switchTo().alert().accept();
    }

    public void selectIframe() {
        String parent = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parent)) {
                driver.switchTo().frame(childHandle);
            }
        }
    }

    public void selectParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void waitWindows() {
        long startTime = System.currentTimeMillis(); //fetch starting time
        int windows;
        do {

            windows = driver.getWindowHandles().size();
        }
        while (windows > 1 || (System.currentTimeMillis() - startTime) < 10000);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String allertGetText() {
        return driver.switchTo().alert().getText();
    }
}
