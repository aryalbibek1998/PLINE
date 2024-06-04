package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Main {
    @Test(priority = 2)
   static void Login(){
        try {
            WebDriverManager.chromedriver().setup();

            // Create an instance of ChromeOptions
            ChromeOptions options = new ChromeOptions();

            // Specify the path to the extension file
            options.addExtensions(new File("D:\\test\\Plline_ext\\src\\main/pline.crx"));


            // Initialize ChromeDriver with the options
            WebDriver driver = new ChromeDriver(options);

            // Example usage of driver
            driver.get("https://platform.pline.io/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.findElement(By.xpath("/html/body/main/div/div/div/a/span")).click();
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ram@yopmail.com");
            driver.findElement(By.id("password")).sendKeys("Test@123");

            // Click the login button
            driver.findElement(By.xpath("//button[@class='c91192a5a c50deed59 cdb4306d0 c9ec81755 c18d716b8']"))
                    .click();
            Thread.sleep(2000);

            // Maximize the window
            driver.manage().window().maximize();

            driver.findElement(By.xpath("/html/body/main/div/div[1]/aside/div/ul/li[2]/span[2]"))
                    .click();
            String expectedresult = "https://platform.pline.io/datasets";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
           // ChromeDriver driver = new ChromeDriver(capabilities);
            String actualtitle1 = driver.getCurrentUrl();
            Assert.assertEquals(actualtitle1, expectedresult, "Testing passed for URL");
            //WebDriver driver = new ChromeDriver(options);
            //WebDriver driver = new ChromeDriver(options);
            driver.findElement(By.xpath("//*[@id=\"project-io--root-popup\"]/div/div[1]/div[2]/div/div[3]/button/span"))
                    .click();
            driver.findElement(By.xpath("///*[@id=\"project-io--root-popup\"]/div/div[1]/div[1]/div[2]/button[1]/span"))
                    .click();


            //driver.findElement(By.xpath("//a[@class=ant-btn css-1snt5c8 ant-btn-link ant-btn-lg ant-btn-block button-signin platform-primary-btn-link")).click();
            //driver.findElement(By.xpath("//a[@class=ant-btn css-1snt5c8 ant-btn-link ant-btn-lg ant-btn-block button-signin platform-primary-btn-link")).click();

            // Perform your tasks here
        }catch (Exception e) {
            // e.printStackTrace();
        }// Use finall if any expection is find out

   }
    public static void main(String[] args) {
        // Setup WebDriverManager
        Login();

    }}

