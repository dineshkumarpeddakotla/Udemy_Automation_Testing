/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Login Page and different methods are implemented to execute operations
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

import java.util.Set;

public class Login extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//INPUT[@id='submit-id-submit']")
    WebElement login;
    @FindBy(linkText = "Continue with Google")
    WebElement continueWithGoogle;
    @FindBy(id = "identifierId")
    WebElement googleEmail;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement next;
    @FindBy(name = "password")
    WebElement googlePassword;
    @FindBy(linkText = "Continue with Facebook")
    WebElement continueWithFacebook;
    @FindBy(name = "pass")
    WebElement facebookPassword;
    @FindBy(id = "loginbutton")
    WebElement fLogin;
    @FindBy(xpath = "//div[@class='alert alert-danger js-error-alert']")
    WebElement alertMessage;

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used from PageFactory class
    }

    /**
     * login method is used to login into application
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String login(String emailId, String pass) throws InterruptedException {
        loginLink.click();
        email.sendKeys(emailId);
        password.sendKeys(pass);
        login.click();
        Thread.sleep(2000);

        return driver.getTitle();
    }

    /**
     * loginWithGoogle method is used to login into application with google account
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String loginWithGoogle() throws InterruptedException {
        loginLink.click();
        continueWithGoogle.click();
        Thread.sleep(1000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for (String winHandle : windowHandles) {
            driver.switchTo().window(winHandle);
            System.out.println(winHandle);
            String actual = driver.getTitle();
            System.out.println(actual);
        }

        googleEmail.sendKeys(" ");
        next.click();
        Thread.sleep(1000);
        googlePassword.sendKeys(" ");
        next.click();
        Thread.sleep(3000);

        return driver.getTitle();
    }

    /**
     * loginWithFacebook method is used to login into application with facebook
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String loginWithFacebook() throws InterruptedException {
        loginLink.click();
        continueWithFacebook.click();
        Thread.sleep(3000);
        email.sendKeys("dineshkumar.icon@gmail.com");
        facebookPassword.sendKeys(" ");
        fLogin.click();
        Thread.sleep(1000);

        return driver.getTitle();
    }
}
