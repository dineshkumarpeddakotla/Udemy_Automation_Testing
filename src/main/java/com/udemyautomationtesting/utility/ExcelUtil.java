/*
 *Purpose : Class is implemented to read the data from excel sheet
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 1-07-2021
 */
package com.udemyautomationtesting.utility;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    /**
     * readData method is used to read the data from excel sheet
     * @param filePath path of the file taken as input
     * @param sheetName sheet name in a file
     * @return cell value
     * @throws IOException file or directory not found found
     */
    public String[][] readData(String filePath, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        System.out.println(rows);
        int columns = sheet.getRow(0).getLastCellNum();

        String[][] array = new String[rows][columns];

        for (int i = 1; i<rows; i++) {
            XSSFRow currentRow = sheet.getRow(i);
            for (int j = 0; j<columns; j++ ) {
                array[i][j] = currentRow.getCell(j).toString();
            }
        }

        return array;
    }
}
