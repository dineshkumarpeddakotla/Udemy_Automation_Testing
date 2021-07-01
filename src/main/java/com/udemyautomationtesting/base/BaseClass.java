/*
 *Purpose : Class is implemented to execute the methods before and after test
 *               @BeforeTest is used to execute the method before execute actual test
 *               @AfterTest is used to execute the method after execute actual test
 *               @Parameter is used to provide the value for browser name
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.udemyautomationtesting.base;

import com.udemyautomationtesting.utility.CrossBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseClass {

    //driver variable is declared
    public static WebDriver driver;

    /**
     * setUp method is used to open browser and navigate to url
     * browser is opened based on parameter value
     * @throws InterruptedException interrupts the execution for certain period
     */
    @Parameters("browserName")
    @BeforeTest //execute before test
    public void setUp(String browserName) throws InterruptedException {
        driver = CrossBrowser.selectDriver(browserName);
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
