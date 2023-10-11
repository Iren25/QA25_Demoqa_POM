package org.ait.demoqa.tests.bookStore;

import org.ait.demoqa.data.UserData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.bookStore.BookStorePage;
import org.ait.demoqa.pages.bookStore.LoginPage;
import org.ait.demoqa.pages.bookStore.ProfilePage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        new HomePage(driver).getBookStore();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookToCollectionTest() {
        //enter book name
        //click on book name
        //click on the Add to your collection button and accept alert
        //click on profile
        //verify the book is added
        new BookStorePage(driver).enterBookName(UserData.BOOK_NAME)
                .clickOnBookName()
                .addToCollection();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).verifyBookName(UserData.BOOK_NAME);
    }

    @AfterMethod
    public void deleteBookFromCollection() {
        new ProfilePage(driver).deleteBook();
    }
}
