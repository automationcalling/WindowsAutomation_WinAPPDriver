package com.automationcalling.testScripts;

import com.automationcalling.pagefactory.MSPaintPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by muthu on 6/23/2018.
 * MS Paint basic click and draw functionality test
 */
public class MSPaint_Sample_Test {
    private MSPaintPage msPaintPage;

    @BeforeClass
    public void init() {
        try {
            Assert.assertNotNull(msPaintPage = new MSPaintPage("MSPaintTool", "WinAPPDriverServer"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void basicPaintSelection() {
        try {
            msPaintPage.buttonclick(msPaintPage.getOvalShape());
            msPaintPage.buttonclick(msPaintPage.getLineSize());
        } catch (Exception e) {
            e.printStackTrace();
            tearDown();

        }
    }

    @Test
    public void moseMove() {
        try {
            msPaintPage.buttonclick(msPaintPage.getOvalShape());
            msPaintPage.mouseDrawPicture(137, 130, 137, 500);
            msPaintPage.clickOn(msPaintPage.getmspaintCloseButton());
            msPaintPage.clickOn(msPaintPage.getDontSaveButton());
        } catch (Exception e) {
            e.printStackTrace();
            tearDown();

        }
    }

    @AfterClass
    public void tearDown() {
        if (msPaintPage.getDriver() != null) {
            msPaintPage.quitDriver();
        }
    }

}
