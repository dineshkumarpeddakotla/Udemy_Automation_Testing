/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Home Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */
package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.utility.JavaScriptUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath = "//a[@aria-label='My profile']")
    WebElement myProfile;
    @FindBy(xpath = "//div[contains(text(),'Udemy credits')]")
    WebElement udemyCredits;
    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    WebElement logOut;
    @FindBy(xpath = "//div[contains(text(),\"You've successfully logged out of Udemy. Come back soon!\")]")
    WebElement alertMessage;

    //parameterized constructor is used
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //clickMyLearning method is used to click my learning
    public void clickMyLearning() {
        myLearning.click();
    }

    //selectCourse method is used to click course
    public void selectCourse() {
        course.click();
    }

    //clickCart method is used to click cart
    public void clickCart() {
        cart.click();
    }

    /**
     * search method is used to search courses or authors etc.,
     * @return title of the page
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String search() throws InterruptedException {
        searchBar.sendKeys("Software Testing");
        searchButton.click();
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

    /**
     * openCourse method is used to open the course
     * @return boolean value for course displayed
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public Boolean openCourse() throws InterruptedException {
        JavaScriptUtil.scrollIntoView(course);
        course.click();
        Thread.sleep(3000);

        return course.isDisplayed();
    }

    /**
     * openMyProfile method is used to open my profile for user
     * @return current curl of the page
     */
    public String openMyProfile() {
        myProfile.click();

        return driver.getCurrentUrl();
    }

    /**
     * openUdemyCredits method is used to go into udemy credits and uses actions method
     * @return current url of page after the all steps executed
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public String openUdemyCredits() throws InterruptedException {
        actions(udemyCredits);
        udemyCredits.click();
        Thread.sleep(2000);

        return driver.getCurrentUrl();
    }

    /**
     * applicationLogout method is used to logout the user from application and uses action method in it
     * @return boolean value for alert message displayed or not
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public Boolean applicationLogout() throws InterruptedException {
        actions(logOut);
        logOut.click();

        return alertMessage.isDisplayed();
    }

    /**
     * actions method is used to perform certain action by using action class
     * @param element web element is used
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public void actions(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(myProfile).perform();
        Thread.sleep(1000);
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
    }
}
