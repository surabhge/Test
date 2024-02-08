package testpacktestngdependsfeature;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dependsonmethoddemo {

    @BeforeMethod
    public void teststart(){
        System.out.println("this is from before method");
    }


    @AfterMethod
    public void testend(){
        System.out.println("this is from after method");
    }

    @Test
    public void testcase1(){
        System.out.println("this is from testcase1");
    }
    @Test(dependsOnMethods = {"testcase1"})
    public void testcase2(){
        System.out.println("this is from testcase2");

    }
    @Test
    public void testcase3(){
        System.out.println("this is from testcase3");

    }
    @Test
    public void testcase4(){
        System.out.println("this is from testcase4");

    }

}
