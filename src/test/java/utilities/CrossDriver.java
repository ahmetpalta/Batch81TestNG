package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){}
    static WebDriver driver;
    /*Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu
    için her test metodu için yeni bir pencere açıyor.
    Eğer driver a bir değer atanmamışsa yani driver==null ise
    driver i çalıştır diyerek bir defaya mahsus çalıştıracak.
    ve driver artık bir kere çalıştığı için null olmayacak ve direkt return edecek
    ve diğer testlerimiz aynı pencere üzerinden çalışacak.

     */
    public static WebDriver getDriver(String browser){
        //Eğer browser bir değer atanmamışsa properties deki dosyasındaki  browserı çalıştırır
        browser=browser==null?ConfigReader.getProperty("browser"):browser;
        //Testlerimizi XML file'dan farklı browser ile çalıştırabilmek için
        // getDriver() methoduna parametre atamız gerekir
        if(driver==null) {
            switch (browser){
  //CrossBrowser için biizim gönderdiğimiz browser üzerinden
  // çalışması için buraya parametre olarak girdiğimiz değeri yaz
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public  static void closeDriver(){
        if(driver!=null) {
            driver.close();
            driver=null;
        }

    }
    public  static void quitDriver(){
        if (driver!=null){
            Driver.quitDriver();
            driver=null;
        }
    }
}
