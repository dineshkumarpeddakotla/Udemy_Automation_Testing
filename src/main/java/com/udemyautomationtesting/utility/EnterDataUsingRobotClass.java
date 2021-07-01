/*
 *Purpose : Class is implemented for entering the data in windows based application by using the robot class
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */

package com.udemyautomationtesting.utility;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class EnterDataUsingRobotClass {

    /**
     * setClipboardData method is used to enter the data into a windows based application using robot class
     * @param string input data
     * @throws AWTException for window toolkit
     */
    public static void setClipboardData(String string) throws AWTException {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();//robot object is created
        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
