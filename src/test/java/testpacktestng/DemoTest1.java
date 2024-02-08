package testpacktestng;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTest1 {
    AndroidDriver driver;

    @BeforeClass
    public  void start() throws MalformedURLException, InterruptedException {
        System.out.println("this is the before method");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterClass
    public  void teardown(){
        System.out.println("this is the after method");
        driver.quit();

    }

    // enabled= false -> testcasecan be skipped
    // bu default its true -> noneed to specifically meniton it
    @Test(dependsOnMethods = {"testcase2"})
    public void testcase1(){
    System.out.println("this is the first case 1");
    System.out.println("to chec kthe attribute vbalue :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).getAttribute("content-desc"));

    }

    @Test(priority = 1)
    public void testcase2(){
        System.out.println("this is the first case 2");
        System.out.println("to chec kthe attribute is displayed :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessiility\"]")).isDisplayed());

    }
}
