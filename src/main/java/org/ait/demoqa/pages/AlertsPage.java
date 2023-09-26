package org.ait.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alertsLink;


    public AlertsPage getAlerts() {
        clickWithJSExecutor(alertsLink, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(css = "[id='alertButton']")
    WebElement alertButton;
    public AlertsPage clickOnSeeAlertBtn() {
        click(alertButton);
        return this;
    }

    public AlertsPage acceptAlert() {
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    } catch (NoAlertPresentException ex) {
        }
        return this;
    }

    @FindBy(css = "[id='timerAlertButton']")
    WebElement timerAlertButton;

    public AlertsPage clickOnSeeAfterFiveSecAlertBtn() {
        click(timerAlertButton);
        return this;
    }

    @FindBy(xpath = "//button[@id='confirmButton']") // css = "[id='confirmButton']"
    WebElement confirmAlertButton;
    
    public AlertsPage clickOnConfirmButton() {
        clickWithJSExecutor(confirmAlertButton, 0, 300);
        return this;
    }

    public AlertsPage selectConfirm(String confirm) {
        if (confirm != null && confirm.equalsIgnoreCase("Ok")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equalsIgnoreCase("cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement result;

    public AlertsPage verifyResult(String message) {
        Assert.assertTrue(shouldHaveText(result,message,5));
        return this;
    }

    @FindBy(xpath = "//button[@id='promtButton']")
    WebElement promptButton;

    public AlertsPage clickOnPromptButton() {
        clickWithJSExecutor(promptButton, 0, 100);
        return this;
    }

    public AlertsPage enterMessageToAlert(String message) {
        if(message != null) {
            driver.switchTo().alert().sendKeys(message);
        }
        return this;
    }

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement promptResult;

    public AlertsPage verifyPromptResult(String message) {
        Assert.assertTrue(shouldHaveText(promptResult,message,5));
        return this;
    }
}
