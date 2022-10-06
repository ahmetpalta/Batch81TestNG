package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClassMethod;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DepensOfMethod extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test1() {
        //amazon sayfasına gitsin
        driver.get("https:/www.amazon.com");
    }

    @Test(dependsOnMethods ="test1")
    public void test2() {
        //Nutella araması yapılsın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nuttela", Keys.ENTER);

    }

    @Test(dependsOnMethods ="test2")
    public void test3() {

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
}
