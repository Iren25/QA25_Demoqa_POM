package org.ait.demoqa.tests.bookStore;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.bookStore.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login("Funbanan","Qwerty!123")
                .verifyUserName("Funbanan");
    }
}
