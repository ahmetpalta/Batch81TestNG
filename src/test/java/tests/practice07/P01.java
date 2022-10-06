package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUnivercityPage;
import utilities.Driver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
    // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
    //Tüm yapılacakların üzerini çiz.
    //Tüm yapılacakları sil.
    //Tüm yapılacakların silindiğini doğrulayın.
    //EXPLORATORY testing:Keşif testi ,Test yapılacak sayfanın tanınması işlemi
    //Test te uygulanması gereken mouse ve klavye operasyonlarının belirlenmesi


    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle
        WebUnivercityPage webUnivercityPage = new WebUnivercityPage();
        //Buradaki listeyi yapılacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak gönderebilmek
        //amacı ile biz olusturduk
        List<String> worklist = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));        Actions actions=new Actions(Driver.getDriver());
        for (String w: worklist) {
            actions.click(webUnivercityPage.adNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
        Thread.sleep(2000);
            List<WebElement> todosWebElement=webUnivercityPage.todos;
            for (WebElement a:todosWebElement) {
                a.click();


            }
            Thread.sleep(2000   );
            List<WebElement>deleteButtonsList=webUnivercityPage.deleteButtons;
        for (WebElement w:deleteButtonsList) {
            w.click();

                        }
        Thread.sleep(3000   );
        List<WebElement>ListeBosMu=webUnivercityPage.deleteButtons;
        Assert.assertTrue(deleteButtonsList.size()==0);

        }

    }

