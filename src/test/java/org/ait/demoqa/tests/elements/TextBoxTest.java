package org.ait.demoqa.tests.elements;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.elements.TextBoxPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIframes();
    }

    @Test
    public void keyboardEventTest() {
        new TextBoxPage(driver).keyboardEvent("Simensdamm 20")
                .assertCopyPasteText();
    }
}
