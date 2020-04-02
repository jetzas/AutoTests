package core.Web.UI.SeleniumElement;

import org.openqa.selenium.*;

public class Button extends Element {
	public void click(By locator) {
		waitUntilClickable(locator).click();
	}

	public void click(WebElement element) {
		waitUntilClickable(element).click();
	}

	public void clickOnVisible(By locator) {
		waitUntilVisible(locator).click();
	}

	public void clickOnVisible(WebElement locator) {
		waitUntilVisible(locator).click();
	}

	ElementProperties elementProperties = new ElementProperties();

	public void clickRepeat(By locator) {
		int i = 0;
		while (elementProperties.isEnabled(locator) || i < 5) {

			waitUntilClickable(locator).click();
			i++;
		}

	}
}
