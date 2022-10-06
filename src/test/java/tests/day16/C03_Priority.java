package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClassMethod;

public class C03_Priority extends TestBaseBeforeClassAfterClassMethod {
    @Test(priority=2)
    public void testAmazon() {
        driver.get("https:/www.amazon.com");
    }
    @Test(priority=3)
    public void testiBestbuy() {
        driver.get("https:/www.bestbuy.com");
    }
    @Test (priority =1,groups="grup1")
    public void testYoutube() {
        driver.get("https:/www.youtube.com");
}}
