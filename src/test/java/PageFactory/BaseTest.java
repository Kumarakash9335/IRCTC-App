package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @BeforeTest
    private static void captureCrashLog() {
        try {
            // Execute adb command to get crash logs
            Process process = Runtime.getRuntime().exec("adb logcat -d");

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line).append("\n");
            }

            // Print or save the crash log
            System.out.println("Crash Log:\n" + log.toString());
            // You can save this log to a file or add it to your test execution report
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDownAppium (){
        if (driver!= null){
            driver.quit();
        }
    }

}
