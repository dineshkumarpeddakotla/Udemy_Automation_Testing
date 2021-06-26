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

    //multiple methods are created for multiple web elements actions
    public void clickSignUp() {
        signUp.click();
    }

    public void setFullName(String fName) {
        fullName.sendKeys(fName);
    }

    public void setEmail(String enterEmail) {
        email.sendKeys(enterEmail);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickSignUpButton() {
        submit.click();
    }

    public void clickLogin() {
        login.click();
    }

    /**
     * registration method is used to register in application for new users
     * @return Title of page
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String registration() throws InterruptedException {
        clickSignUp();
        Thread.sleep(2000);
        setFullName("dinesh");
        setEmail("dineshkumar.icon.dk@gmail.com");
        setPassword(" ");
        clickSignUpButton();

        return driver.getTitle();
    }

    /**
     * alreadyRegistered method is used, if a user is already registered
     * then user will directly click login button
     * @return page title
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String alreadyRegistered_User_ClickOnLogIn() throws InterruptedException {
        clickSignUp();
        Thread.sleep(3000);
        clickLogin();

        return driver.getTitle();
    }
}
