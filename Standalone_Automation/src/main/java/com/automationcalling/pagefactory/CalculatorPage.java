package com.automationcalling.pagefactory;
import com.automationcalling.wrapper.WinAPPDriverWrapper;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Muthu on 6/23/2018.
 * Page Factory for Calculator App
 */
public class CalculatorPage extends WinAPPDriverWrapper {
    private WindowsDriver driver;

    @FindBy(name = "One")
    private WebElement button1;

    @FindBy(name = "Two")
    private WebElement button2;

    @FindBy(name = "Three")
    private WebElement button3;

    @FindBy(name = "Four")
    private WebElement button4;

    @FindBy(name = "Five")
    private WebElement button5;

    @FindBy(name = "Six")
    private WebElement button6;

    @FindBy(name = "Seven")
    private WebElement button7;

    @FindBy(name = "Eight")
    private WebElement button8;

    @FindBy(name = "Nine")
    private WebElement button9;

    @FindBy(name = "Multiply by")
    private WebElement multiplyButton;

    @FindBy(name = "Equals")
    private WebElement equalButton;

    @FindBy(name = "Clear")
    private WebElement clearButton;

    @FindBy(name = "Minus")
    private WebElement minusButton;

    @FindBy(name = "Plus")
    private WebElement plusButton;


    public CalculatorPage(String applicationPathOrAppName, String winAPPDriverServer) {
        super(applicationPathOrAppName, winAPPDriverServer);
        this.driver = getDriver();
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public WebElement getButton1() {
        return button1;
    }

    public WebElement getButton2() {
        return button2;
    }

    public WebElement getButton3() {
        return button3;
    }

    public WebElement getButton4() {
        return button4;
    }

    public WebElement getButton5() {
        return button5;
    }

    public WebElement getButton6() {
        return button6;
    }

    public WebElement getButton7() {
        return button7;
    }

    public WebElement getButton8() {
        return button8;
    }

    public WebElement getButton9() {
        return button9;
    }

    public WebElement getMultiplyButton() {
        return multiplyButton;
    }

    public WebElement getEqualButton() {
        return equalButton;
    }

    public WebElement getResultTextBox() {
        return driver.findElementByAccessibilityId("CalculatorResults");
    }

    public WebElement getPlusButton() {
        return plusButton;
    }

    public WebElement getClearButton() {
        return clearButton;
    }

    public WebElement getMinusButton() {
        return minusButton;
    }

    public WebElement returnCalculatorButton(String getKeyValue) {
        WebElement element=null;
        switch (getKeyValue) {
            case "1":
                element=getButton1();
                break;
            case "2":
                element=getButton2();
                break;
            case "3":
                element=getButton3();
                break;
            case "4":
                element=getButton4();
                break;
            case "5":
                element=getButton5();
                break;
            case "6":
                element=getButton6();
                break;
            case "7":
                element=getButton7();
                break;
            case "8":
                element=getButton8();
                break;
            case "9":
                element=getButton9();
                break;
            case "X":
                element=getMultiplyButton();
                break;
            case "=":
                element=getEqualButton();
                break;
            case "+":
                element=getPlusButton();
                break;
            case "-":
                element=getMinusButton();
                break;
            case "clear":
                element=getClearButton();
                break;
            case "Result":
                element=getResultTextBox();
                break;

            default:
                break;

        }
        return element;
    }

    public String getCalculationResults() {
        String results = null;
        results = returnText(getResultTextBox()).replace("Display is ", "").trim();
        return results;
    }

}
