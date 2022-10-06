package tests.practice04;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class P1 extends TestBaseBeforeMethodAfterMethod {
    // ...Exercise3...
// go to url : https://www.techlistic.com/p/selenium-practice-form.html
//fill the firstname
//fill the lastname
//check the gender
//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button

    @Test
    public void test1() {
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Ali");
        driver.findElement(By.xpath("//*[@name='lastname']")).click();

    }
}
