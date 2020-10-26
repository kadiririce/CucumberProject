package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountSummaryPage().AccountActivities.click();
        new AccountActivityPage().FindTransactions.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {

        new AccountActivityPage().enterDates(from,to);


    }
    @And("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
        BrowserUtils.waitFor(1);


    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) throws ParseException {

        BrowserUtils.waitFor(1);
        List<WebElement> datesInTable = new AccountActivityPage().datesInTable;
        List<String> ListOfDates = BrowserUtils.getElementsText(datesInTable);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date fromExpected = sdf.parse(from);
        Date toExpexted = sdf.parse(to);

        Date toActual = sdf.parse(ListOfDates.get(0));
        Date fromActual = sdf.parse(ListOfDates.get(ListOfDates.size() - 1));

        Assert.assertTrue(fromActual.after(fromExpected)||fromActual.equals(fromExpected));
        Assert.assertTrue(toActual.before(toExpexted)||toActual.equals(toExpexted));

    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<WebElement> datesInTable = new AccountActivityPage().datesInTable;
        List<String> ListOfDates = BrowserUtils.getElementsText(datesInTable);
        for (int i = 0; i < ListOfDates.size()-2; i++) {
            Assert.assertTrue(Integer.parseInt(ListOfDates.get(i).substring(8))>Integer.parseInt(ListOfDates.get(i+1).substring(8)));

        }
    }

    @And("the user clear date boxes")
    public void theUserClearDateBoxes() {
        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().toDate.clear();
    }
    @Then("the results table should only not contains transactions dated {string}")
    public void the_results_table_should_only_not_contains_transactions_dated(String string) {

    }





    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.waitFor(1);
        new AccountActivityPage().descriptionBox.sendKeys(string);

    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        List<WebElement> descInTable = new AccountActivityPage().descInTable;
        List<String> elementsText = BrowserUtils.getElementsText(descInTable);

        for (String s : elementsText) {
            Assert.assertTrue(s.contains(string));
        }
    }

    @And("the user clear description box")
    public void theUserClearDescriptionBox() {
        new AccountActivityPage().descriptionBox.clear();
    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        List<WebElement> descInTable = new AccountActivityPage().descInTable;
        List<String> elementsText = BrowserUtils.getElementsText(descInTable);

        for (String s : elementsText) {
            Assert.assertFalse(s.contains(string));
        }

    }
    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int withdrawalsize = new AccountActivityPage().WithdrawalSize();
        int depositSize = accountActivityPage.DepositSize();
        System.out.println("depositSize = " + depositSize);
        System.out.println("withdrawalsize = " + withdrawalsize);

        if (type.equals("Deposit")){
            Assert.assertTrue(depositSize>=1);

        }else if (type.equals("Withdrawal")){

            Assert.assertTrue(withdrawalsize>=1);

        }
    }
    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select select = new Select(new AccountActivityPage().TypeDropDown);
        select.selectByVisibleText(string);
    }
    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        if (string.equals("Deposit")){
            Assert.assertTrue(accountActivityPage.DepositSize()==0);
        }else if (string.equals("Withdrawal")){
            Assert.assertTrue(accountActivityPage.WithdrawalSize()==0);
        }
    }






}
