package kibernum.clinica.hooks;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static void set(WebDriver webdriver) {
        driver.set(webdriver);
    }

    public static WebDriver get() {
        WebDriver webDriver = driver.get();
        if(webDriver==null){
            throw new IllegalStateException("No WebDriver was set");
        }
        return webDriver;
    }

    public static void remove(){  
        driver.remove();
      }
        
    
}