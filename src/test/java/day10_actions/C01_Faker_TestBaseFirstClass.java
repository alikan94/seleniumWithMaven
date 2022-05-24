package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_Faker_TestBaseFirstClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
    }
}
