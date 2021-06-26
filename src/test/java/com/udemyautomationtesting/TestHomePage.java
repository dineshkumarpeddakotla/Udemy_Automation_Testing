package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TestHomePage extends BaseClass {

    //Test case is executed and assertion is done for search results displayed or not
    @Test
    public void searchFor_Course() throws InterruptedException {
//        Login login = new Login(driver);
//        login.loginWithFacebook();
//        Thread.sleep(2000);

        HomePage search = new HomePage(driver);
        String actualTitle = search.search();
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?search-query=software+testing";

        Assert.assertEquals(actualTitle, expectedUrl);
    }

    //Test case is executed and assertion is done for MyLearning url of a page
    @Test
    public void checkMyLearning() throws InterruptedException {
        Login login = new Login(driver);
        login.login();
        Thread.sleep(2000);

        HomePage myLearning = new HomePage(driver);
        String actualUrl = myLearning.myLearning();
        String expectedUrl = "https://www.udemy.com/home/my-courses/learning/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //Test case is executed and assertion is done whether the selected course is displayed or not
    @Test
    public void checkCourse() throws InterruptedException {
        HomePage checkCourse = new HomePage(driver);
        checkCourse.search();
        Boolean courseDisplayed = checkCourse.openCourse();

        Assert.assertTrue(courseDisplayed);
    }

    @Test
    public void open_UserProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        String actualUrl = homePage.openMyProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

}
