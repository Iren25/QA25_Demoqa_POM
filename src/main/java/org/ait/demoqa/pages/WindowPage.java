package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage{
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    WebElement browserWindows;
    public WindowPage getBrowserWindows() {
        clickWithJSExecutor(browserWindows, 0, 200);
        return new WindowPage(driver);
    }

    @FindBy(xpath = "//button[@id='tabButton']")
    WebElement newTab;

    public WindowPage switchToNewTab(int index) {
        clickWithJSExecutor(newTab, 0, 150);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement title;

    public WindowPage verifyNewTabText(String text) {
        Assert.assertTrue(isTextPresent(title, text));
        return this;
    }

    @FindBy(xpath = "//button[@id='windowButton']")
    WebElement newWindow;

    public WindowPage openNewWindow(int index) {
        clickWithJSExecutor(newWindow, 0, 150);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    public WindowPage verifyNewWindowText(String text) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(isTextPresent(title, text));
        return this;
    }
}
