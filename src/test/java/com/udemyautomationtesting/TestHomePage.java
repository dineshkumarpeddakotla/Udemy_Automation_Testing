/*
 *Purpose : Class is implemented for executing the different test cases for HomePage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */

package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.utility.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
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
        login.login("dineshkumar.icon.dk@gmail.com","Dinnu@247");
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

    //open_UserProfile test is executed and assertion is done for user profile page is opened
    @Test
    public void open_UserProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login("dineshkumar.icon.dk@gmail.com","Dinnu@247");

        HomePage homePage = new HomePage(driver);
        String actualUrl = homePage.openMyProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //open_UdemyCredits test is executed and assertion is done for Udemy Credits page is opened
    @Test
    public void open_UdemyCredits() throws InterruptedException {
        Login login = new Login(driver);
        login.login("dineshkumar.icon.dk@gmail.com","Dinnu@247");

        HomePage homePage = new HomePage(driver);
        String actualUrl = homePage.openUdemyCredits();
        String expectedUrl = "https://www.udemy.com/dashboard/credit-history/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //logoutFromApplication test is executed and assertion is done for whether the user is successfully logout
    @Test
    public void logoutFromApplication() throws InterruptedException {
//        Login login = new Login(driver);
//        login.login("dineshkumar.icon.dk@gmail.com","Dinnu@247");

        HomePage homePage = new HomePage(driver);
        Boolean logout = homePage.applicationLogout();

        Assert.assertTrue(logout);
    }
}
