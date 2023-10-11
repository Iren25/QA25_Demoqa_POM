package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage keyboardEvent(String text) {
        typeWithJSExecutor(currentAddress, text, 0, 300);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        click(submit);
        return this;
    }

    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement provedCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement permanentAddress;


    public TextBoxPage assertCopyPasteText() {
        String text1 = permanentAddress.getText().replace("Permananet Address :", "");
        String text2 = provedCurrentAddress.getText().replace("Current Address :", "");
        Assert.assertEquals(text1, text2);
        return this;
    }
}
