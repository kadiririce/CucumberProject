package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add new payee")
    public void add_new_payee() {
        new AccountSummaryPage().PayBills.click();
        new PayBills().AddNewPayee.click();
        BrowserUtils.waitFor(1);
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> info){
        PayBills payBills = new PayBills();
        payBills.payeeName.sendKeys(info.get("Payee Name"));
        payBills.payeeAddress.sendKeys(info.get("Payee Address"));
        payBills.payeeAccount.sendKeys(info.get("Account"));
        payBills.payeeDetails.sendKeys(info.get("Payee details"));
        Driver.get().findElement(By.id("add_new_payee")).click();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        String expexted = string;
        String actual = Driver.get().findElement(By.xpath("//div[@id='alert_content']")).getText();

        Assert.assertEquals(expexted,actual);


    }
}
