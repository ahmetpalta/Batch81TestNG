package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClassMethod;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClassMethod {
    @Test
    public void testAmazon() {
        driver.get("https:/www.amazon.com");
    }
    @Test
    public void testiBestbuy() {
        driver.get("https:/www.bestbuy.com");
    }
    @Test
    public void testTechproeducatio() {
        driver.get("https:/www.techproeducation.com");
    }
}
