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

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used from PageFactory class
    }

    //multiple methods are created for multiple web elements actions
    public void clickLoginLink() {
        loginLink.click();
    }

    public void setEmail(String inputEmail) {
        email.sendKeys(inputEmail);
    }

    public void setPassword(String inputPassword) {
        password.sendKeys(inputPassword);
    }

    public void clickLogin() {
        login.click();
    }

    public void clickContinueWithGoogle() {
        continueWithGoogle.click();
    }

    public void setGoogleEmail(String inputGoogleEmail) {
        googleEmail.sendKeys(inputGoogleEmail);
    }

    public void clickNext() {
        next.click();
    }

    public void setGooglePassword(String inputGooglePassword) {
        googlePassword.sendKeys(inputGooglePassword);
    }

    public void clickContinueWithFacebook() {
        continueWithFacebook.click();
    }

    public void setFacebookPassword(String inFacebookPassword) {
        facebookPassword.sendKeys(inFacebookPassword);
    }

    public void clickFLogin() {
        fLogin.click();
    }

    /**
     * login method is used to login into application
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String login() throws InterruptedException {
        clickLoginLink();
        setEmail("dineshkumar.icon.dk@gmail.com");
        setPassword(" ");
        clickLogin();

        Thread.sleep(2000);
        return driver.getTitle();
    }

    /**
     * loginWithGoogle method is used to login into application with google account
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String loginWithGoogle() throws InterruptedException {
        clickLoginLink();
        clickContinueWithGoogle();
        Thread.sleep(1000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for (String winHandle : windowHandles) {
            driver.switchTo().window(winHandle);
            System.out.println(winHandle);
            String actual = driver.getTitle();
            System.out.println(actual);
        }

        setGoogleEmail("dineshkumar.icon.dk@gmail.com");
        clickNext();
        Thread.sleep(1000);
        setGooglePassword("  ");
        clickNext();
        Thread.sleep(3000);

        return driver.getTitle();
    }

    /**
     * loginWithFacebook method is used to login into application with facebook
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String loginWithFacebook() throws InterruptedException {
        clickLoginLink();
        clickContinueWithFacebook();
        Thread.sleep(3000);
        setEmail("dineshkumar.icon@gmail.com");
        setFacebookPassword("  ");
        clickFLogin();
        Thread.sleep(1000);

        return driver.getTitle();
    }
}
