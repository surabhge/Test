package parameterisationdemo;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTestParameterisation {
    AndroidDriver driver;

    @BeforeSuite
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

    @AfterSuite
    public  void teardown(){
        System.out.println("this is the after method");
        driver.quit();

    }


    @Test
    @Parameters({ "data" })
    public void testcase1(String valuetiinput) throws InterruptedException {
    System.out.println("this is the first case 1");
    Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(5000);
//     WebElement item =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
        Thread.sleep(5000);
        System.out.println("the value form xml : " +valuetiinput);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(valuetiinput);

    }

//    @Test(priority = 1)
//    public void testcase2(){
//        System.out.println("this is the first case 2");
//        System.out.println("to chec kthe attribute is displayed :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessiility\"]")).isDisplayed());
//
//    }
}
