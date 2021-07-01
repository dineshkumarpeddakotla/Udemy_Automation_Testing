/*
 *Purpose : Class is implemented for executing the different test cases for RegistrationPage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */
package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.*;
import com.udemyautomationtesting.utility.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class TestRegistrationPage extends BaseClass {

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
        String actualTitle = registration.alreadyRegistered_User_ClickOnLogIn();
        String expectedTitle = "Login | Udemy";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
