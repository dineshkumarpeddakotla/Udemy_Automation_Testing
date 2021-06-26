package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(xpath = "//input[@name = 'q']")
    WebElement searchBar;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement searchButton;
    @FindBy(linkText = "My learning")
    WebElement myLearning;
    @FindBy(xpath = "//a[@href = '/course/selenium-real-time-examplesinterview-questions/']")
    WebElement course;
    @FindBy(xpath = "//a[@href = '/cart/']")
    WebElement cart;
    @FindBy(xpath = "//a[@href='/user/edit-profile/']")
    WebElement myProfile;

    //parameterized constructor is used
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //multiple methods are created for multiple web elements actions
    public void setSearchBar(String search) {
        searchBar.sendKeys(search);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMyLearning() {
        myLearning.click();
    }

    public void clickCourse() {
        course.click();
    }

    public void clickCart() {
        cart.click();
    }

    /**
     * search method is used to search courses or authors etc.,
     * @return title of the page
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String search() throws InterruptedException {
        setSearchBar("Software Testing");
        clickSearchButton();
        Thread.sleep(2000);

        return driver.getCurrentUrl();
    }

    /**
     * myLearning method is used to go into the my learning page
     * @return title of the page
     */
    public String myLearning() {
        clickMyLearning();

        return driver.getCurrentUrl();
    }

    public Boolean openCourse() throws InterruptedException {
        clickCourse();
        Thread.sleep(3000);
        return course.isDisplayed();
    }

    public String openMyProfile() {
        myProfile.click();

        return driver.getCurrentUrl();
    }
}