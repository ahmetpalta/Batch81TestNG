package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    /*Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu
    için her test metodu için yeni bir pencere açıyor.
    Eğer driver a bir değer atanmamışsa yani driver==null ise
    driver i çalıştır diyerek bir defaya mahsus çalıştıracak.
    ve driver artık bir kere çalıştığı için null olmayacak ve direkt return edecek
    ve diğer testlerimiz aynı pencere üzerinden çalışacak.

     */
    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")){
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
