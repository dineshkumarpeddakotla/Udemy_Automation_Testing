/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in User Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 26-06-2021
 */
package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.utility.EnterDataUsingRobotClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class User extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'View public profile')]")
    WebElement publicProfile;
    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement profile;
    @FindBy(xpath = "//a[@href = '/user/edit-photo/']")
    WebElement photo;
    @FindBy(xpath = "//a[@href = '/user/edit-account/']")
    WebElement account;
    @FindBy(xpath = "//div[@class = 'file-uploader--file-selector--SGCns']")
    WebElement uploadImage;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement cropImage;
    @FindBy(xpath = "//input[@id='submit-id-submit']")
    WebElement saveButton;

    //parameterized constructor is implemented
    public User(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * clickPublicProfile method is used to open public profile
     * @return current url of the page
     */
    public String clickPublicProfile() {
        publicProfile.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickEditProfile method is used to open edit profile page
     * @return current url of page
     */
    public String clickEditProfile() {
        profile.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickEditPhoto method is used to open edit photo
     * @return current url of page
     */
    public String clickEditPhoto() {
        photo.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickAccount method is used to open account page
     * @return current url
     */
    public String clickAccount() {
        account.click();

        return driver.getCurrentUrl();
    }

    //clickUploadImage method is used to click on upload image
    public void clickUploadImage() {
        uploadImage.click();
    }

    /**
     * uploadImage method is used to upload a image by using a EnterDataUsingRobotClass
     * @return boolean value for crop image button displayed
     * @throws AWTException for window toolkit
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public Boolean uploadImage() throws AWTException, InterruptedException {
        clickUploadImage();
        Thread.sleep(300);
        EnterDataUsingRobotClass.setClipboardData("C:\\Users\\dinnu\\Downloads\\download.jpg");
        Thread.sleep(300);
        Boolean displayed = cropImage.isDisplayed();
        cropImage.click();
        Thread.sleep(300);
        saveButton.sendKeys(Keys.ENTER);

        return displayed;
    }
}
