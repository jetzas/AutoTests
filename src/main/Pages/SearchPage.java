package Pages;

import core.Web.UI.SeleniumElement.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage {

    private Windows driver = new Windows();
    private Button button = new Button();
    private Fields fields = new Fields();
    private Windows navigate = new Windows();
    ElementProperties element = new ElementProperties();
    DropDown dropDown = new DropDown();

    public SearchPage openUrl() {
        navigate.navigate("https://www.tiketa.lt/EN/search");
        return this;
    }

    //URL
    private static String pageLink = "";

    //INPUT FIELDS,BUTTONS
    private static By inputCaption = By.name("sf_TextFilter");
    private static By clickDropDown = By.id("cityCaption");
    private static By chooseCity = By.xpath("//*[@id=\"search-city\"]/div[2]/div/div/div/div/ul/li[2]/a");
    private static By inputDate1 = By.name("sf_DateFrom");
    private static By inputDate2 = By.name("sf_DateTo");
    private static By buttonSearch = By.cssSelector("div[class='advanced-search-submit-btn col-xs-12 text-right'] button");
    private static By buttonBuy = By.cssSelector("button[id='btnBuy-23290']");
    private static By chooseTicket = By.xpath("//*[@id=\"main-container\"]/div/div/div/div[2]/div/div[1]/div/div[6]/div[2]/div/div[4]/div/div/a");
    private static By choosePrice = By.cssSelector("div[id='pricesList'] div:nth-child(1) label");
    private static By buttonFindTickets = By.cssSelector("div[id='divLogin'] a");
    private static By closeLoginPopup = By.cssSelector("li[class='close-button'] button");

    @Step("Input text to field caption")
    public SearchPage inputCaption(String text) {
        fields.sendValue(inputCaption,text);
        element.findElementByXpath(By.xpath("//body")).click();
        return this;
    }

    @Step("Select value Vilnius from dropdown city")
    public SearchPage selectCityByValue() {
        button.click(clickDropDown);
        driver.findElementByXpath(chooseCity).click();
        return this;
    }

    public SearchPage inputDateFrom(String text) {
        fields.type(inputDate1, text);
        return this;
    }

    public SearchPage inputDateTo(String text) {
        fields.type(inputDate2, text);
        return this;
    }

    public SearchPage clickButtonSearch() {
        button.waitUntilClickable(buttonSearch);
        button.click(buttonSearch);
        return this;
    }

    public SearchPage clickButtonBuy() {
        button.waitUntilClickable(buttonBuy);
        button.click(buttonBuy);
        return this;
    }

    public SearchPage chooseTicket() {
        button.click(chooseTicket);
        return this;
    }

    public SearchPage choosePrice() {
        button.click(choosePrice);
        return this;
    }

    public SearchPage pushButtonFindTickets() {
        button.waitUntilClickable(buttonFindTickets);
        button.click(buttonFindTickets);
        return this;
    }

    public SearchPage closeLoginPopup() {
        button.waitUntilClickable(closeLoginPopup);
        button.click(closeLoginPopup);
        return this;
    }

}