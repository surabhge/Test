package testpacktestngdependsfeature;

import org.testng.annotations.Test;

public class groupstestng {
    @Test(groups = { "end2endtest" })
    public void e2e2() {
        System.out.println("end2endtest e2e2");
    }

    @Test(groups = { "smoketest" })
    public void smoke1() {
        System.out.println("smoketest smoke1");
    }

    @Test(groups = { "smoketest" })
    public void smoke2() {
        System.out.println("smoketest smoke2");
    }

    @Test(groups = { "smoketest" })
    public void smoke3() {
        System.out.println("smoketest smoke3");
    }

    @Test(groups = { "regressiontest" })
    public void reg1() {
        System.out.println("regressiontest reg1");
    }

    @Test(groups = { "regressiontest", "smoketest"})
    public void reg2() {
        System.out.println("regressiontest reg2");
    }

    @Test(groups = { "regressiontest" })
    public void reg3() {

        System.out.println("regressiontest reg3");
    }

    @Test(groups = { "end2endtest" })
    public void e2e1() {
        System.out.println("end2endtest e2e1");
    }
}
