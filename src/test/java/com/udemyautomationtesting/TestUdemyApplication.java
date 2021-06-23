package com.udemyautomationtesting;

import com.udemyautomationtesting.base.Base;
import com.udemyautomationtesting.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUdemyApplication extends Base {

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
}
