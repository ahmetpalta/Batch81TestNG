package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;  //properties değişkeni tanımlanıyor
    static{  //ilk önce bu bloğun çalışması için static blok içerisine alınıyor
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


public static  String getProperty(String key){

    /*test metodundan yolladığımız string key değerini alıp Properties sınıfından
    getProperty() metodunu kullanarak bu key'e ait value'yi bize getirir.
     */


    return properties.getProperty(key);
}

    

}
