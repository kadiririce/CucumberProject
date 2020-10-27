package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class PayBillsStepDefs {

    @Given("user go to Pay Bills")
    public void user_go_to_Pay_Bills() {
        new AccountSummaryPage().PayBills.click();

    }

    @When("user completes a successfully Pay operation")
    public void user_completes_a_succesful_Pay_operation() {
        new PayBills().AmountTab.sendKeys("123");
        new PayBills().DateTab.sendKeys("1995-02-12");
        new PayBills().PayBtn.click();


    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expextedMessage) {
        String actualMessage = new PayBills().approvalMessage.getText();
        Assert.assertEquals(expextedMessage,actualMessage);
    }

    @When("user tries to make a payment without entering the amount or date")
    public void userTriesToMakeAPaymentWithoutEnteringTheAmountOrDate() {
        new PayBills().PayBtn.click();
    }

    @Then("{string} message should be displayed.")
    public void messageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = new PayBills().AmountTab.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @When("user enters some alphabetical character on Amount field")
    public void userEntersSomeAlphabeticalOrSpecialCharacterOnAmountField() {
            PayBills payBills = new PayBills();
            payBills.AmountTab.sendKeys("abc");
    }

    @Then("Amount field should be empty")
    public void amountFieldShouldBeEmpty() {
        PayBills payBills= new PayBills();
        String value = payBills.AmountTab.getAttribute("value");
       Assert.assertEquals("",value);

    }

    @When("user enters some special character on Amount field")
    public void userEntersSomeSpecialCharacterOnAmountField() {
        PayBills payBills = new PayBills();
        payBills.AmountTab.sendKeys("+%#");
    }

    @When("user enters some alphabetical chatacter on Date field")
    public void userEntersSomeAlphabeticalChatacterOnDateField() {
        new PayBills().DateTab.sendKeys("abc");
    }

    @Then("Date field should be empty")
    public void dateFieldShouldBeEmpty() {
        String value = new PayBills().DateTab.getAttribute("value");
        Assert.assertEquals("",value);
    }
}
