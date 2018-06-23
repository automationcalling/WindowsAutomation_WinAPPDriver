package com.automationcalling.wrapper;

import com.automationcalling.utils.CommonUtil;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static com.automationcalling.utils.Constant.*;

/**
 * Created by Muthu on 06/23.2018.
 * WinAppDriver Wrapper
 */

public class WinAPPDriverWrapper {
    private WindowsDriver driver;

    public WinAPPDriverWrapper() {

    }

    public WinAPPDriverWrapper(String applicationPathOrAppName, String winAPPDriverServer) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("app", new CommonUtil().getPropertyFileValue(applicationPathOrAppName));
            driver = new WindowsDriver(new URL(new CommonUtil().getPropertyFileValue(winAPPDriverServer)), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(WAITTIME, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(IMPLICITWAITTIME, TimeUnit.SECONDS);
    }

    public WindowsDriver getDriver() {
        return driver;
    }

    public void clickOn(WebElement element) {
        try {
            checkingElementClickable(element, IMPLICITWAITTIME).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            checkingVisibilityOfElement(element, IMPLICITWAITTIME).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String returnText(WebElement element) {
        String text = null;
        try {
            text = checkingVisibilityOfElement(element, IMPLICITWAITTIME).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public boolean isEnabledStatus(WebElement element) {
        boolean status = false;
        try {
            status = checkingVisibilityOfElement(element, IMPLICITWAITTIME).isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public WebElement checkingVisibilityOfElement(WebElement element, long waitTime) {
        return new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement checkingElementClickable(WebElement element, long waitTime) {
        return new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
    }


    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToLastWindow(Set<String> windowHandles) {
        for (String win : windowHandles) {
            driver.switchTo().window(win);
        }
    }

    public void mouseDrawPicture(int elementPositionX, int elementPostionY,
                                 int drawX, int drawY) {
        new Actions(driver).moveByOffset(elementPositionX, elementPostionY)
                .clickAndHold().moveByOffset(drawX, drawY)
                .click().build().perform();
    }


    public void quitDriver() {
        driver.quit();
    }

}
