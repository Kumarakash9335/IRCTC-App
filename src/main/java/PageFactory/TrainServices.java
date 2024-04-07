package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TrainServices {
    AndroidDriver driver;
    public TrainServices(AndroidDriver driver) {
        super();
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "(cris.org.in.prs.ima:id/tv_title_name")
    private WebElement trainServiceScreen;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'Book Ticket']")
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
    @AndroidFindBy(xpath = "cris.org.in.prs.ima:id/fromStn_code")
    private WebElement stationFromPlaceholder;
    @AndroidFindBy(xpath = "cris.org.in.prs.ima:id/toStn_code")
    private WebElement stationToPlaceholder;

    public boolean isTrainServiceScreenVisible () {
        return trainServiceScreen.isDisplayed();
    }

    public void findTrains (){
        if(isTrainServiceScreenVisible()== true){
            bookTicketTab.click();
            searchTrainScreen.isDisplayed();
            System.out.println("Navigated to Search Train Screen");


        }
    }
}


