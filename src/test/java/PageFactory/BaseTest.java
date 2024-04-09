package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static AndroidDriver driver;
    public AppiumDriverLocalService service;
    public UiAutomator2Options options;

@BeforeSuite
    public void startAppium() throws MalformedURLException, InterruptedException {
//        String npmPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//        service = new AppiumServiceBuilder().withAppiumJS(new File(npmPath)).withIPAddress("127.0.0.1").usingPort(4723).build();  // Start appium server through program
//        service.start();   // To start appium server
        options = new UiAutomator2Options();
        options.setDeviceName("ConnectDevice");
//        options.setAppPackage("cris.org.in.prs.ima");
//        options.setAppActivity("android.service.smartspace.SmartspaceService");
        options.setApp("/home/sc-234-user/Downloads/cris-org-in-prs-ima-259-67354462-0c0fdb12697a57521c78f357ddd9470c.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
    @AfterTest
    public void tearDownAppium (){
        if (driver!= null){
            driver.quit();
        }
    }

}
