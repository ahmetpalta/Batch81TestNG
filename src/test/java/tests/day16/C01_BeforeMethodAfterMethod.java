package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void amazonTesti() {
driver.get("https:/www.amazon.com");
    }

    @Test (groups="grup1")
    public void bestbuyTesti() {
        driver.get("https:/www.bestbuy.com");
    }
    @Test
    public void techproeducationTesti() {
        driver.get("https:/www.techproeducation.com");
    }
}
