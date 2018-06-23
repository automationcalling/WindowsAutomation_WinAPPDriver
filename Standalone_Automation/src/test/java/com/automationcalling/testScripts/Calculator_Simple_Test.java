package com.automationcalling.testScripts;

import com.automationcalling.pagefactory.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by muthu on 6/23/2018.
 * Simple Calculator test
 */
public class Calculator_Simple_Test {
    private CalculatorPage calculatorPage;

    /**
     * Sample test for how to invoke windows based application
     */

    @BeforeClass
    public void init() {
        try {
            Assert.assertNotNull(calculatorPage = new CalculatorPage("CalculatorName", "WinAPPDriverServer"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void additionCalculation() {
        calculatorPage.clickOn(calculatorPage.getButton9());
        calculatorPage.clickOn(calculatorPage.getMultiplyButton());
        calculatorPage.clickOn(calculatorPage.getButton7());
        calculatorPage.clickOn(calculatorPage.getEqualButton());
        Assert.assertEquals(Integer.parseInt(calculatorPage.getCalculationResults())
                , 63);
    }

    @AfterClass
    public void tearDown() {
        if (calculatorPage.getDriver() != null) {
            calculatorPage.quitDriver();
        }
    }
}
