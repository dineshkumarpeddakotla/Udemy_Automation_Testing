/*
 *Purpose : Class is implemented to provide multiple data for test cases from excel sheet
 *                @DataProvider is provides the data to test cases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 1-07-2021
 */
package com.udemyautomationtesting.utility;

import java.io.IOException;

public class DataProvider {

    /**
     * getDataFromProvider is used get the from excel sheet
     * @return data from excel sheet
     * @throws IOException directory not found exception
     */
    @org.testng.annotations.DataProvider(name = "LoginDetails")
    public static Object[][] getDataFromProvider() throws IOException {
        ExcelUtil readExcel = new ExcelUtil();

        return readExcel.readData(".\\src\\test\\resources\\UdemyData.xlsx", "LoginValidCredentials");
    }
}
