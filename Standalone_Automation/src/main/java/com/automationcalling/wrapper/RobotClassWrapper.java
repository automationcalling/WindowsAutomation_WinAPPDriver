package com.automationcalling.wrapper;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Muthu on 6/23/2018.
 * Robot Class Util
 */
public class RobotClassWrapper {
    Robot robot;
    StringSelection copiedText;

    public RobotClassWrapper() throws AWTException {
        robot = new Robot();
    }

    public RobotClassWrapper(String text) throws AWTException {
        robot = new Robot();
        copiedText = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copiedText, null);

    }

    public RobotClassWrapper keyPress(String text) {
        robot.keyPress(returnKey(text.trim()));
        return this;
    }

    public RobotClassWrapper keyRelease(String text) {
        robot.keyRelease(returnKey(text.trim()));
        return this;
    }

    public RobotClassWrapper setAutoDelay(int delay) {
        robot.setAutoDelay(delay);
        return this;
    }

    public int returnKey(String keyValue) {
        int returnKey = 0;
        switch (keyValue.toUpperCase()) {
            case "C":
                returnKey = KeyEvent.VK_C;
                break;
            case "V":
                returnKey = KeyEvent.VK_V;
                break;
            case "ENTER":
                returnKey = KeyEvent.VK_ENTER;
                break;
            case "CONTROL":
                returnKey = KeyEvent.VK_CONTROL;
                break;
            default:
                break;

        }
        return returnKey;
    }

}
