package dataproviderarraydemo;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTestParameterisation_ios {
    IOSDriver driver;

    @BeforeMethod
    public  void start() throws MalformedURLException, InterruptedException {
        System.out.println("this is the before method");
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setAutoWebview(true);
//        options.setAppPushTimeout(Duration.ofMillis(50000));

        options.setBundleId("com.moataz.dailycheck");

         driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterMethod
    public  void teardown(){
        System.out.println("this is the after method");
        driver.quit();

    }
    @DataProvider(name = "AuthenticationData")
    public Object[][] credentials() {
        return new Object[][] { { "testuser_1", "Test@123" },{ "testuser_2", "Test@123" },{ "testuser_3", "Test@123" } };
    }

    @Test(dataProvider = "AuthenticationData")
    public void testcase1(String username , String password) throws InterruptedException {
    System.out.println("this is the first case 1");
    Thread.sleep(5000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]")).click();
        Thread.sleep(5000);


        driver.findElement(By.xpath("//XCUIElementTypeTextField[@value=\"Title\" and @type=\"XCUIElementTypeTextField\"]")).sendKeys(username+" - "+password);


    }


}
