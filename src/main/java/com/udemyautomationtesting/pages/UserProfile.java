package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfile extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'View public profile')]")
    WebElement publicProfile;
    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement profile;
    @FindBy(xpath = "//a[contains(text(),'Photo')]")
    WebElement photo;
    @FindBy(xpath = "//a[contains(text(),'Account')]")
    WebElement account;

    public UserProfile(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String clickPublicProfile() {
        publicProfile.click();

        return driver.getCurrentUrl();
    }

    public String clickEditProfile() {
        profile.click();

        return driver.getCurrentUrl();
    }

    public String clickEditPhoto() {
        photo.click();

        return driver.getCurrentUrl();
    }

    public String clickAccount() {
        account.click();

        return driver.getCurrentUrl();
    }
}
