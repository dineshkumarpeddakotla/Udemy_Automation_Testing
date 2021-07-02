/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Registration Page and different methods are implemented
 *          to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(linkText = "Sign up")
    WebElement signUp;
    @FindBy(xpath = "//input[@id = 'id_fullname']")
    WebElement fullName;
    @FindBy(xpath = "//input[@name = 'email']")
    WebElement email;
    @FindBy(xpath = "//input[@type = 'password']")
    WebElement password;
    @FindBy(xpath = "//input[@name = 'submit']")
    WebElement submit;
    @FindBy(xpath = "//a[contains(text(),'Log In')]")
    WebElement login;

    //parameterized constructor is used
    public Registration(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used from PageFactory class
    }

    /**
     * registration method is used to register in application for new users
     * @return Title of page
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String registration() throws InterruptedException {
        signUp.click();
        Thread.sleep(2000);
        fullName.sendKeys("dinesh");
        email.sendKeys("dineshkumar.icon.dk@gmail.com");
        password.sendKeys("");
        submit.click();

        return driver.getTitle();
    }

    /**
     * alreadyRegistered method is used, if a user is already registered
     * then user will directly click login button and directed to login page
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String alreadyRegistered_User_ClickOnLogIn() throws InterruptedException {
        signUp.click();
        Thread.sleep(3000);
        login.click();

        return driver.getTitle();
    }
}
