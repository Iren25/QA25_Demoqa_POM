package org.ait.demoqa.tests;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.WindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsWindow();
        new WindowPage(driver).getBrowserWindows();
    }

    @Test
    public void switchToNewTabTest() {
        new WindowPage(driver).switchToNewTab(1)
                .verifyNewTabText("This is a sample page");
    }

    @Test
    public void openNewWindowTest() {
        new WindowPage(driver).openNewWindow(1)
                .verifyNewWindowText("This is a sample page");
    }



}
