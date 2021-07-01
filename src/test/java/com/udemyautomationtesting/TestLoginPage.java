/*
 *Purpose : Class is implemented for executing the different test cases for LoginPage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */
package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.utility.DataProvider;
import com.udemyautomationtesting.utility.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestLoginPage extends BaseClass {

    //Test case is executed and assertion is done for login
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void loginTo_Application_WithValid_Credentials(String email, String password) throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login(email,password);
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

    //test case is executed and assertion is done for invalid email and invalid password details
    @Test
    public void loginTo_Application_WithInvalidEmail_And_InvalidPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login("dineshkuma@gmail.com", "dinnu123");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }

    //test case is executed and assertion is done for invalid email and valid password details
    @Test
    public void loginTo_Application_WithInvalidEmail_And_ValidPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login("dineshkuma@gmail.com", "Dinnu@123");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }

    //test case is executed and assertion is done for valid email and invalid password details
    @Test
    public void loginTo_Application_WithValidEmail_And_InvalidPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login("dineshkumar@gmail.com", "dinnu123");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }

    //test case is executed and assertion is done for blank email and valid password details
    @Test
    public void loginTo_Application_WithBlankEmail_And_ValidPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login("", "Dinnu@247");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }

    //test case is executed and assertion is done for blank email and valid password details
    @Test
    public void loginTo_Application_WithValidEmail_And_BlankPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login("dineshkumar.icon.dk@gmail.com", "");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }

    //test case is executed and assertion is done for blank email and blank password details
    @Test
    public void loginTo_Application_WithBlankEmail_And_BlankPassword() throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.login(" ", " ");
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";

        Assert.assertNotEquals(actualTitle, expectedTitle);
    }
}
