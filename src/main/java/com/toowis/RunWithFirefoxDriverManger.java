package com.toowis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunWithFirefoxDriverManger {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("10.49.7.185:9010");
        proxy.setSslProxy (proxy.getHttpProxy());
        
        System.out.println(proxy.getHttpProxy());
        
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("proxy", proxy);
        
        // 브라우저 보이지 않기
        // options.addArguments("headless");
        
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com/");
        
        driver.findElement(By.name("q")).sendKeys("java");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        
        // 브라우저 닫기
        //if (driver != null) {
        //    sleep(3);
        //    driver.quit();
        //}
    }
    
    public static void sleep(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
