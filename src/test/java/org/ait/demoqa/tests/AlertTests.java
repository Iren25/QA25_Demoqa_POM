package org.ait.demoqa.tests;

import org.ait.demoqa.pages.AlertsPage;
import org.ait.demoqa.pages.BasePage;
import org.ait.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{


    //click on link Alerts, Frame & Windows
    //click on link Alerts
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).getAlertsWindow();
        new AlertsPage(driver).getAlerts();
    }

    @Test
    public void seeAlert(){
        //click on the button to see alert
        //click on OK
        new AlertsPage(driver).clickOnSeeAlertBtn()
                .acceptAlert();
    }

    @Test
    public void seeAfterFiveSecAlert(){
        //click on the button to see alert after 5 sec
        //click on OK
       new AlertsPage(driver).clickOnSeeAfterFiveSecAlertBtn()
               .acceptAlert();
    }


    @Test
    public void confirmAlertTest(){
        //click on the button to confirm box alert
        //select ok / cancel
        //assert text result Ok/cancel
        new AlertsPage(driver).clickOnConfirmButton()
                .selectConfirm("Ok")
                .verifyResult("You selected Ok");
    }


    @Test
    public void sendMessageToAlertTest(){
        //click on the button Click for Promt box
        //enter 'Hello Irina'
        //click on OK
        //assert text result 'Hello Irina'
        new AlertsPage(driver).clickOnPromptButton()
                .enterMessageToAlert("Hello Irina")
                .acceptAlert()
                .verifyPromptResult("You entered Hello Irina");

    }







}
