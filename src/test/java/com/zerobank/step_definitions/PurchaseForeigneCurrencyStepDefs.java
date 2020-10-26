package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeigneCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new AccountSummaryPage().PayBills.click();
        new PayBills().PurchaseForeignCurrency.click();
        BrowserUtils.waitFor(1);
    }
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> infoCurrency) {
        List<String> expectedList = infoCurrency;
        Select select = new Select(new PayBills().CurrencyDrowpDown);
        List<String> actualList = BrowserUtils.getElementsText(select.getOptions());
        actualList.remove(0);
        Assert.assertEquals(expectedList,actualList);
    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBills().CalculateCostsBtn.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String errorMessage = alert.getText();

        Assert.assertTrue(errorMessage.length()>0);

    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        Select select = new Select(new PayBills().CurrencyDrowpDown);
        select.selectByIndex(5);
        new PayBills().CalculateCostsBtn.click();
    }
}
