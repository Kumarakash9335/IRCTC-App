package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class HomeScreen {
    AndroidDriver driver;
    public HomeScreen(AndroidDriver driver) {
        super();
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'IRCTC RAIL CONNECT']")
    private WebElement homeScreenText;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text= 'Train']")
    private WebElement trainTab;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/home_11")
    private WebElement HomeTab;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/my_account_image")
    private WebElement profileTab;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/transaction_imaqe")
    private WebElement transactionTab;
    @AndroidFindBy(id = "cris.org.in.prs.ima:id/more_image")
    private WebElement moreDrawerTab;

    public boolean isHomeScreenVisible() {
        return homeScreenText.isDisplayed();
    }

    public void gotoTrainService() {
        trainTab.click();
    }


}




