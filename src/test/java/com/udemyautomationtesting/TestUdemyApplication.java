package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.*;
import com.udemyautomationtesting.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class TestUdemyApplication extends BaseClass {

    //Test case is executed and assertion is done for Sign Up
    @Test
    public void signUpTo_Application() throws InterruptedException {
        Registration registration = new Registration(driver);
        String actualTitle = registration.registration();
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Test case is executed and assertion is done for already registered user when click on login
    @Test
    public void alreadyRegisteredUser_ClickLogIn() throws InterruptedException {
        Registration registration = new Registration(driver);
        String actualTitle = registration.alreadyRegistered();
        String expectedTitle = "Login | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Test case is executed and assertion is done for login
    @Test
    public void loginTo_Application() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login();
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Test case is executed and assertion is done for login with google
    @Test
    public void loginTo_Application_WithGoogle() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.loginWithGoogle();
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Test case is executed and assertion is done for login with facebook
    @Test
    public void loginTo_Application_WithFacebook() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.loginWithFacebook();
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Test case is executed and assertion is done for search results displayed or not
    @Test
    public void searchFor_Course() throws InterruptedException {
        Login login = new Login(driver);
        login.loginWithFacebook();
        Thread.sleep(2000);

        HomePage search = new HomePage(driver);
        String actualTitle = search.search();
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?search-query=software+testing";

        Assert.assertEquals(actualTitle, expectedUrl);
    }

    //Test case is executed and assertion is done for MyLearning url of a page
    @Test
    public void checkMyLearning() throws InterruptedException {
        Login login = new Login(driver);
        login.loginWithFacebook();
        Thread.sleep(2000);

        HomePage myLearning = new HomePage(driver);
        String actualUrl = myLearning.myLearning();
        String expectedUrl = "https://www.udemy.com/home/my-courses/learning/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //Test case is executed and assertion is done whether the selected course is done or not
    @Test
    public void checkCourse() throws InterruptedException {
        HomePage checkCourse = new HomePage(driver);
        checkCourse.search();
        Boolean courseDisplayed = checkCourse.openCourse();

        Assert.assertTrue(courseDisplayed);
    }

    @Test
    public void checkCourse_AddedToCart() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.search();
        homePage.clickCourse();
        Thread.sleep(3000);

        Courses course = new Courses(driver);
        Boolean courseAdded = course.courseAddedToCart();

        Assert.assertTrue(courseAdded);
    }

    @Test
    public void filterCourse_ByRatings() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        String actualUrl = courses.selectRating("4.5 & up");
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?ratings=4.5&sort=popularity";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void checkFilterButton() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        Boolean filterDisplayed = courses.filter();

        Assert.assertTrue(filterDisplayed);
    }

    @Test
    public void selectAll_VideoDuration_CheckBoxes() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        String actualUrl = courses.selectAllVideoCheckBoxes();
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?duration=short&" +
                             "duration=medium&duration=long&duration=extraLong&sort=popularity";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void sort_Courses() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        String actualUrl = courses.sortCourses("Highest Rated");
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?sort=highest-rated";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void open_MyProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        String actualUrl = homePage.openMyProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openPublicProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        UserProfile userProfile = new UserProfile(driver);
        String actualUrl = userProfile.clickPublicProfile();
        String expectedUrl = "https://www.udemy.com/user/dinesh-kumar-peddakotla-2/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        UserProfile userProfile = new UserProfile(driver);
        String actualUrl = userProfile.clickEditProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openPhoto() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        UserProfile userProfile = new UserProfile(driver);
        String actualUrl = userProfile.clickEditPhoto();
        String expectedUrl = "https://www.udemy.com/user/edit-photo/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openAccount() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();
        Thread.sleep(1000);

        UserProfile userProfile = new UserProfile(driver);
        String actualUrl = userProfile.clickAccount();
        String expectedUrl = "https://www.udemy.com/user/edit-account/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
