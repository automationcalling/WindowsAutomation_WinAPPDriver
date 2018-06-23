package com.automationcalling.pagefactory;

import com.automationcalling.wrapper.WinAPPDriverWrapper;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.automationcalling.utils.Constant.IMPLICITWAITTIME;

/**
 * Created by Muthu on 6/23/2018.
 * Page Factory for MS-Paint application
 */
public class MSPaintPage extends WinAPPDriverWrapper {
    private WindowsDriver driver;

    @FindBy(name = "Oval")
    private WebElement ovalShape;

    @FindBy(name = "Size")
    private WebElement lineSize;

    @FindBy(className = "Afx:00007FF6E9C10000:8")
    private WebElement paintArea;

    @FindBy(name = "8px")
    private WebElement line8pixel;

    @FindBy(name = "Don't Save")
    private WebElement dontSaveButton;


    public MSPaintPage(String applicationPathOrAppName, String winAPPDriverServer) {
        super(applicationPathOrAppName, winAPPDriverServer);
        this.driver = getDriver();
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public WebElement getOvalShape() {
        return ovalShape;
    }

    public WebElement getPaintArea() {
        return paintArea;
    }

    public WebElement getLineSize() {
        return lineSize;
    }

    public WebElement select8px() {
        return line8pixel;
    }

    public WebElement getmspaintCloseButton() {
        return driver.findElementByAccessibilityId("Close");
    }


    public void buttonclick(WebElement element) {
        checkingElementClickable(element, IMPLICITWAITTIME).click();
    }

    public WebElement getDontSaveButton() {
        return dontSaveButton;
    }


}
