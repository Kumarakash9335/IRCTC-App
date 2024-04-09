package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrainServices {
    AndroidDriver driver;

    public TrainServices(AndroidDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "I R CTC Rail Connect")
    private WebElement trainServiceScreen;
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
    private WebElement bookTicketTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'My Bookings']")
    private WebElement myBookingsTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'PNR Enquiry']")
    private WebElement pnrEnquiryTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'Last Transaction']")
    private WebElement lastTransactionTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'Upcoming Journey']")
    private WebElement upcomingJourneyTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'Cancel Ticket']")
    private WebElement cancelTicketTab;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'TRAIN SEARCH']")
    private WebElement searchTrainScreen;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'STN' and @resource-id = 'cris.org.in.prs.ima:id/fromStn_code']")
    private WebElement stationFromPlaceholder;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'STN' and @resource-id = 'cris.org.in.prs.ima:id/toStn_code']")
    private WebElement stationToPlaceholder;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/tv_search_text")
    private WebElement stationFromSearchBar;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[@text= 'Enter Destination city/station name or code']")
    private WebElement stationToSearchBar;
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> searchSuggestion;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/fromStn_code")
    private WebElement stationFromUserSelected;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/toStn_code")
    private WebElement stationToUserSelected;


    public boolean isTrainServiceScreenVisible() {
        if(trainServiceScreen.isDisplayed()){
            return true;
        }
        return false;
    }



    public void findTrains(String fromStation, String toStation) throws InterruptedException {
        bookTicketTab.click();
        searchTrainScreen.isDisplayed();
        System.out.println("Navigated to Search Train Screen");
        stationFromPlaceholder.click();
        stationFromSearchBar.click();
        stationFromSearchBar.sendKeys(fromStation);
        List<WebElement> searchSuggestionsForSource = driver.findElements(By.xpath("//android.widget.TextView[starts-with(@text," + fromStation + ")]"));
        if (!searchSuggestionsForSource.isEmpty()) {
            System.out.println(fromStation+" station found");
            searchSuggestionsForSource.get(0).click(); // Assuming to click the first suggestion
            Thread.sleep(2000);
        } else {
            System.out.println(fromStation+" station not found");
        }
        stationToPlaceholder.click();
        stationToSearchBar.click();
        stationToSearchBar.sendKeys(toStation);
        List<WebElement> searchSuggestionsForDestination = driver.findElements(By.xpath("//android.widget.TextView[starts-with(@text," + toStation + ")]"));
        if (!searchSuggestionsForDestination.isEmpty()) {
            System.out.println(toStation+" station found");
            searchSuggestionsForDestination.get(0).click(); // Assuming to click the first suggestion
            Thread.sleep(2000);
        } else {
            System.out.println(toStation+" station not found");
        }


    }
    public WebElement getUserSelectedStationFromName(){
        return stationFromUserSelected;
    }
    public WebElement getUserSelectedStationToName(){
        return stationToUserSelected;
    }
}


