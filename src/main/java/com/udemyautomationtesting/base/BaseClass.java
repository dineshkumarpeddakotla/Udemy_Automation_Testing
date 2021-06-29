/*
 *Purpose : Class is implemented to execute the methods before and after test
 *               @BeforeTest is used to execute the method before execute actual test
 *               @AfterTest is used to execute the method after execute actual test
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.udemyautomationtesting.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    //driver variable is declared
    public static WebDriver driver;

    /**
     * setUp method is used to open chrome and navigate to url
     *
     * @throws InterruptedException interrupts the execution for certain period
     */
    @BeforeTest //execute before test
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    //tearDown method closes all connections
    @AfterTest //execute after test
    public void tearDown() {
        driver.quit();
    }
}
