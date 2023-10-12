package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventWithRobot() {
        pause(1000);
        clickWithRectangle(uploadFile, 2, 4);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id="uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadedFilePath, path));
        return this;
    }

    public UploadPage performMouseEvent() {
        pause(1000);
        clickWithRectangle(uploadFile, 2, 4);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        Dimension dimension = driver.manage().window().getSize();

        System.out.println("Dimension x and y: " + dimension.getWidth() + " " + dimension.getHeight());
        int x = dimension.getWidth()/4 + 500;
        int y = dimension.getHeight()/2;
        robot.mouseMove(x,y);
        pause(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
