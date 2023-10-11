package org.ait.demoqa.pages;

import org.ait.demoqa.pages.alertsFrameWindows.FramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = "div.body-height:nth-child(2)")
    WebElement alertsWindowLink;

    public AlertsPage getAlertsWindow() {
        clickWithJSExecutor(alertsWindowLink, 0, 400);
        return new AlertsPage(driver);
    }

    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;

    public SidePanel getElements() {
        clickWithJSExecutor(elements, 0, 200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFramesWindows;

    public SidePanel getAlertsFramesWindows() {
        clickWithJSExecutor(alertsFramesWindows, 0, 200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets, 0, 200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJSExecutor(forms, 0, 200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(5)")
    WebElement interactions;

    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions, 0, 300);
        return new SidePanel(driver);
    }
}
