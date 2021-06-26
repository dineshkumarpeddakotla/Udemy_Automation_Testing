package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TestLoginPage extends BaseClass {

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
