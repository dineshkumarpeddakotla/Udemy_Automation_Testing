/*
 *Purpose : Class is implemented for handling javascript operations and
 *  scrollIntoView method is implemented to scroll the webpage
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */

package com.udemyautomationtesting.utility;

import com.udemyautomationtesting.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil extends BaseClass {

    /**
     * scrollIntoView method is used to scroll the web page until to find desired web element
     * @param element web element
     */
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
