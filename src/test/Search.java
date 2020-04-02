import Pages.SearchPage;
import org.testng.annotations.Test;
import core.Web.AllListeners.*;

public class Search extends Listener {

    @Test(groups = "Regression")
    public void ticketBookingFunctionality() {
        new SearchPage()
                .openUrl()
                .inputCaption("Comic")
                .selectCityByValue()
                .inputDateFrom("2020-01-01")
                .inputDateTo("2021-07-05")
                .clickButtonSearch()
                .clickButtonBuy()
                .chooseTicket()
                .choosePrice()
                .pushButtonFindTickets()
                .closeLoginPopup();
    }
}
