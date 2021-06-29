/*
 *Purpose : Class is implemented for executing the different test cases for CoursePage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 25-06-2021
 */

package com.udemyautomationtesting;

import com.udemyautomationtesting.base.BaseClass;
import com.udemyautomationtesting.pages.Courses;
import com.udemyautomationtesting.pages.HomePage;
import com.udemyautomationtesting.pages.Login;
import com.udemyautomationtesting.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TestCoursesPage extends BaseClass {

    //checkFilterButton test is executed and assertion done for filter button displayed or not
    @Test
    public void checkFilterButton() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        Boolean filterDisplayed = courses.clickFilter();

        Assert.assertTrue(filterDisplayed);
    }

    //sort_Courses test method is executed and assertion is done for courses as per selected drop down list option
    @Test
    public void sort_Courses() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();

        Courses courses = new Courses(driver);
        String actualUrl = courses.sortCourses("Highest Rated");
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?sort=highest-rated";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //filterCourse_ByRatings test method is executed and assertion is done for filter courses are displayed as per rating
    @Test
    public void filterCourse_ByRatings() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search();
        Thread.sleep(500);

        Courses courses = new Courses(driver);
        String actualUrl = courses.selectRating("4.5 & up");
        String expectedUrl = "https://www.udemy.com/courses/development/software-testing/?ratings=4.5&sort=popularity";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //selectAll_VideoDuration_CheckBoxes test is executed and assertion is done for courses are displayed
    //as per the selected check boxes
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

    //checkCourse_AddedToCart test is executed and assertion is done for course is added to cart or not
    @Test
    public void checkCourse_AddedToCart() throws InterruptedException {
        Login login = new Login(driver);
        login.login("dineshkumar.icon.dk@gmail.com","Dinnu@247");

        HomePage homePage = new HomePage(driver);
        homePage.search();
        homePage.selectCourse();
        Thread.sleep(3000);

        Courses course = new Courses(driver);
        Boolean courseAdded = course.courseAddedToCart();

        Assert.assertTrue(courseAdded);
    }
}
