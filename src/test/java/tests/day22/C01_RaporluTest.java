package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.swing.*;

public class C01_RaporluTest extends TestBaseRapor{

    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */
@Test
public void Test() {
    extentTest=extentReports.createTest("Pozitif Test","Geçerli kullanıcı adı ve password ile giriş yapıldı");
    //https://www.bluerentalcars.com/ adresine git
    Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
    extentTest.info("Blue RentaCar sitesine gidildi");
    //-login butonuna bas
    BrcPage brcPage = new BrcPage();

    brcPage.brclogin.click();
    extentTest.info("login butonuna basıldı");
    //-test data user email: customer@bluerentalcars.com
    //-test data password : 12345 dataları girip login e basın
    //-login butonuna tiklayin
    brcPage.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
    extentTest.info("Doğru kullanıcı email ve password girildi ");

    String actualUserName=brcPage.basariliGiris.getText();
    String expecteUserName="ohn Walker";
    Assert.assertEquals(expecteUserName,actualUserName);
    extentTest.pass("Sayfaya başarılı bir şekilde giriş yapıldı");


}



}





