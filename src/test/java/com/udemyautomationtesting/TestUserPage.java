/*
 *Purpose : Class is implemented for executing the different test cases for UserPage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 26-06-2021
 */
package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.pages.User;
import com.udemyautomationtesting.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(CustomListener.class)
public class TestUserPage extends BaseClass {

    //openPublicProfile test is executed and assertion is done whether the public profile is opened
    @Test
    public void openPublicProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickPublicProfile();
        String expectedUrl = "https://www.udemy.com/user/dinesh-kumar-peddakotla-2/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //openEdit_Profile test is executed and assertion is done whether the user is open edit profile
    @Test
    public void openEdit_Profile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickEditProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //openEdit_Photo test is executed and assertion is done whether the user is open edit photo
    @Test
    public void openEdit_Photo() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickEditPhoto();
        String expectedUrl = "https://www.udemy.com/user/edit-photo/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //openEdit_Account test is executed and assertion is done whether the user is open Edit_Account
    @Test
    public void openEdit_Account() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickAccount();
        String expectedUrl = "https://www.udemy.com/user/edit-account/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //upload_ImageToProfile test is executed and assertion is done whether the user is upload Image To Profile
    @Test
    public void upload_ImageToProfile() throws InterruptedException, AWTException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        user.clickEditPhoto();
        Thread.sleep(500);
        Boolean displayed = user.uploadImage();

        Assert.assertTrue(displayed);
    }
}
