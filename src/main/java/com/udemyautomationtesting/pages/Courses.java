/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Course Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 25-06-2021
 */
package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Courses extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(xpath = "//span[contains(text(), 'Filter')]")
    WebElement filter;
    @FindBy(xpath = "//div[@class = 'filter-panel--sidebar--L2lAU']")
    WebElement filterSideBar;
    @FindBy(xpath = "//span[contains(text(), '4.5 & up')]")
    WebElement radioButton1;
    @FindBy(xpath = "//span[contains(text(), '4.0 & up')]")
    WebElement radioButton2;
    @FindBy(xpath = "//span[contains(text(), '3.5 & up')]")
    WebElement radioButton3;
    @FindBy(xpath = "//span[contains(text(), '3.0 & up')]")
    WebElement radioButton4;
    @FindBy(xpath = "//label[1][contains(text(),'0-3')]")
    WebElement dur0To3hrs;
    @FindBy(xpath = "//label[2][contains(text(),'3-6')]")
    WebElement dur3To6hrs;
    @FindBy(xpath = "//label[3][contains(text(),'6-17')]")
    WebElement dur6To17hrs;
    @FindBy(xpath = "//label[4][contains(text(),'17+')]")
    WebElement durAbove17hrs;
    @FindBy(xpath = "//select[@name = 'sort']")
    WebElement sort;
    @FindBy(xpath = "//button[@class= 'udlite-btn udlite-btn-large udlite-btn-brand udlite-heading-md add-to-cart']")
    WebElement addToCart;
    @FindBy(xpath = "//button[@class = 'udlite-btn udlite-btn-medium udlite-btn-ghost udlite-heading-sm udlite-btn-icon" +
            " udlite-btn-icon-medium udlite-modal-close modal--close-button--28QM_']")
    WebElement cancelButton;
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCart;

    //parameterized constructor is created
    public Courses(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //clickOnAddCart is used to click on add to cart
    public void clickOnAddCart() {
        addToCart.click();
    }

    //clickRadioButton1 is used to click on rating above 4.5
    public void clickRadioButton1() {
        radioButton1.click();
    }

    //clickRadioButton2 is used to click on rating above 4.0
    public void clickRadioButton2() {
        radioButton2.click();
    }

    //clickRadioButton3 is used to click on rating above 3.5
    public void clickRadioButton3() {
        radioButton3.click();
    }

    //clickRadioButton4 is used to click on rating above 3.0
    public void clickRadioButton4() {
        radioButton4.click();
    }

    /**
     * courseAddedToCart is used to add the course into the cart
     * @return boolean value by checking go to cart displayed
     * @throws InterruptedException interrupted execution for certain given period of time
     */
    public Boolean courseAddedToCart() throws InterruptedException {
        clickOnAddCart();
        Thread.sleep(2000);
        driver.switchTo().activeElement();
        cancelButton.click();

        return goToCart.isDisplayed();
    }

    /**
     * clickFilter method is used to click filter button
     * @return boolean value for checking filterSideBar is displayed
     */
    public Boolean clickFilter() {
        filter.click();

        return filterSideBar.isDisplayed();
    }

    /**
     * clickDur0To3hrs is used to select check box
     * @return boolean value, whether check box is selected
     */
    public Boolean clickDur0To3hrs() {
        dur0To3hrs.click();

        return dur0To3hrs.isSelected();
    }

    /**
     * clickDur3To6hrs is used to select check box
     * @return boolean value, whether check box is selected
     */
    public Boolean clickDur3To6hrs() {
        dur3To6hrs.click();

        return dur3To6hrs.isSelected();
    }

    /**
     * clickDur6To17hrs is used to select check box
     * @return boolean value, whether check box is selected
     */
    public Boolean clickDur6To17hrs() {
        dur6To17hrs.click();

        return dur6To17hrs.isSelected();
    }

    /**
     * clickDurAbove17hrs is used to select check box
     * @return boolean value, whether check box is selected
     */
    public Boolean clickDurAbove17hrs() {
        durAbove17hrs.click();

        return durAbove17hrs.isSelected();
    }

    /**
     * selectRating method is used to select any of the rating radio button
     * @param rating rating value is given as a string
     * @return current url of page after selecting radio button
     */
    public String selectRating(String rating) {

        switch (rating) {
            case "4.5 & up":
                clickRadioButton1();
                break;
            case "4.0 & up":
                clickRadioButton2();
                break;
            case "3.5 & up":
                clickRadioButton3();
                break;
            case "3.0 & up":
                clickRadioButton4();
                break;
            default:
        }

        return driver.getCurrentUrl();
    }

    /**
     * selectAllVideoCheckBoxes is used to select all check boxes
     * @return current curl of page after selecting check boxes
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public String selectAllVideoCheckBoxes() throws InterruptedException {
        clickDur0To3hrs();
        Thread.sleep(1000);
        clickDur3To6hrs();
        Thread.sleep(1000);
        clickDur6To17hrs();
        Thread.sleep(1000);
        clickDurAbove17hrs();
        Thread.sleep(2000);

        return driver.getCurrentUrl();
    }

    /**
     * sortCourses method is used to select option from drop list
     * @param sortBy is a string from drop down list
     * @return current url of page
     */
    public String sortCourses(String sortBy) {
        Select select = new Select(sort);

        switch (sortBy) {
            case "Most Popular":
                select.selectByVisibleText("Most Popular");
                break;
            case "Highest Rated":
                select.selectByVisibleText("Highest Rated");
                break;
            case "Newest":
                select.selectByVisibleText("Newest");
                break;
            default:
        }

        return driver.getCurrentUrl();
    }
}
