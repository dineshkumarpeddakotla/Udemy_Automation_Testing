package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.pages.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserPage extends BaseClass {

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

    @Test
    public void openProfile() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickEditProfile();
        String expectedUrl = "https://www.udemy.com/user/edit-profile/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openPhoto() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickEditPhoto();
        String expectedUrl = "https://www.udemy.com/user/edit-photo/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openAccount() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        HomePage homePage = new HomePage(driver);
        homePage.openMyProfile();

        User user = new User(driver);
        String actualUrl = user.clickAccount();
        String expectedUrl = "https://www.udemy.com/user/edit-account/";

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
