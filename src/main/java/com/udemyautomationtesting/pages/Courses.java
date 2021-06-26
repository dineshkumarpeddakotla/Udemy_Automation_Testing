package com.udemyautomationtesting.pages;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Courses extends BaseClass {

    @FindBy(xpath = "//button[@class= 'udlite-btn udlite-btn-large udlite-btn-brand udlite-heading-md add-to-cart']")
    WebElement addToCart;
    @FindBy(xpath = "//button[@class = 'udlite-btn udlite-btn-medium udlite-btn-ghost udlite-heading-sm udlite-btn-icon" +
            " udlite-btn-icon-medium udlite-modal-close modal--close-button--28QM_']")
    WebElement cancelButton;
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCart;
    @FindBy(xpath = "//span[contains(text(), '4.5 & up')]")
    WebElement radioButton1;
    @FindBy(xpath = "//span[contains(text(), '4.0 & up')]")
    WebElement radioButton2;
    @FindBy(xpath = "//span[contains(text(), '3.5 & up')]")
    WebElement radioButton3;
    @FindBy(xpath = "//span[contains(text(), '3.0 & up')]")
    WebElement radioButton4;
    @FindBy(xpath = "//span[contains(text(), 'Filter')]")
    WebElement filter;
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

    public Courses(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddCart() {
        addToCart.click();
    }

    public void clickRadioButton1() {
        radioButton1.click();
    }

    public void clickRadioButton2() {
        radioButton2.click();
    }

    public void clickRadioButton3() {
        radioButton3.click();
    }

    public void clickRadioButton4() {
        radioButton4.click();
    }

    public Boolean courseAddedToCart() throws InterruptedException {
        clickOnAddCart();
        Thread.sleep(1000);
        driver.switchTo().activeElement();
        cancelButton.click();

        return goToCart.isDisplayed();
    }

    public Boolean filter() {
        filter.click();

        return filter.isDisplayed();
    }

    public Boolean clickDur0To3hrs() {
        dur0To3hrs.click();

        return dur0To3hrs.isSelected();
    }

    public Boolean clickDur3To6hrs() {
        dur3To6hrs.click();

        return dur3To6hrs.isSelected();
    }

    public Boolean clickDur6To17hrs() {
        dur6To17hrs.click();

        return dur6To17hrs.isSelected();
    }

    public Boolean clickDurAbove17hrs() {
        durAbove17hrs.click();

        return durAbove17hrs.isSelected();
    }

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
