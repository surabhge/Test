package testpacktestng;


import org.testng.annotations.*;

public class DemoTest {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("this is the before suite");

    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("this is the after suite");

    }

    @BeforeTest
    public  void beforetest(){
        System.out.println("this is the before test");

    }

    @AfterTest
    public  void aftertest(){
        System.out.println("this is the after test");

    }

    @BeforeClass
    public  void beforeclass(){
        System.out.println("this is the before class");

    }

    @AfterClass
    public  void afterclass(){
        System.out.println("this is the after class");

    }

    @BeforeMethod
    public  void beforemethod(){
        System.out.println("this is the before method");

    }

    @AfterMethod
    public  void aftermethod(){
        System.out.println("this is the after method");


    }

    @Test
    public void testcase1(){
    System.out.println("this is the first case 1");
    }

    @Test
    public void testcase2(){
        System.out.println("this is the first case 2");
    }
}
