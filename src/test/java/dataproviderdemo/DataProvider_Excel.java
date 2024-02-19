package dataproviderdemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Excel {

    private String sTestCaseName;
    private int iTestCaseRow;
    AppiumDriver driver;
    static final String Path_TestData = "C:\\Users\\aravind\\Selenium_HITS_Sessions\\TestNG_DataProvider_ApachePOI\\src\\DataSheet\\TestData_Copy.xlsx";
    private static String result = "Pass";
    private static final int col_result =4;

    @BeforeMethod
    public void OpenBrowser() throws Exception {
        //Need to put code
        driver.manage().window().maximize();
    }

//Driver
    @Test(dataProvider = "Authentication")
    public void testcase(String sUserName, String sPassword, String search, String result) throws Exception {
        driver.findElement(AppiumBy.xpath(".//*[@id='account']/a")).click();
        driver.findElement(AppiumBy.id("log")).sendKeys(sUserName);
        System.out.println(sUserName);
        driver.findElement(AppiumBy.id("pwd")).sendKeys(sPassword);
        System.out.println(sPassword);
        driver.findElement(AppiumBy.id("login")).click();
        WebElement logo = driver.findElement(AppiumBy.xpath("//img[@alt='home']"));
        if(logo.isDisplayed() == true){
            for(int i =1 ;i< ExcelUtilReadWrite.getRowUsed();i++){
                ExcelUtilReadWrite.setCellData("Pass", i, col_result, "BasicData");
            }
        }else{
            for(int i =1 ;i< ExcelUtilReadWrite.getRowUsed();i++){
                ExcelUtilReadWrite.setCellData("Fail", i, col_result, "BasicData");
            }
        }
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.close();
    }

    @DataProvider(name = "Authentication")
    public Object[][] Authentication() throws Exception {
        ExcelUtilReadWrite.setExcelFile(
                "C:\\Users\\aravind\\Selenium_HITS_Sessions\\TestNG_DataProvider_ApachePOI\\src\\DataSheet\\TestData_Copy.xlsx",
                "BasicData");
        // sTestCaseName = this.toString();
        // From above method we get long test case name including package and
        // class name etc.
        // The below method will refine your test case name, exactly the name
        // use have used
        // sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data
        // Excel sheet
        iTestCaseRow = ExcelUtilReadWrite.getRowContains("DataProvider_Excel_Test", 1);
        Object[][] testObjArray = ExcelUtilReadWrite.getTableArray(
                "C:\\Users\\aravind\\Selenium_HITS_Sessions\\TestNG_DataProvider_ApachePOI\\src\\DataSheet\\TestData_Copy.xlsx",
                "BasicData");
        return (testObjArray);

    }

}
