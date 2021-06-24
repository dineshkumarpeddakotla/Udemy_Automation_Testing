package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.listener.CustomListener;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.pages.Registration;
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
        String expectedTitle = "Software Testing – Beginner to Advanced Online Courses | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
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
}
