package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();

    }



    @Then("the	Account	Activity page	should	be	displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expextedTitle="Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expextedTitle,actualTitle);
    }



    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        if (string.equals("Savings")){
            new AccountSummaryPage().savings1.click();
        }else if (string.equals("Brokerage")){
            new AccountSummaryPage().brokerage.click();
        }else if (string.equals("Checking")){
            new AccountSummaryPage().checking.click();
        }else if (string.equals("Credit Card")){
            new AccountSummaryPage().creditCard.click();
        }else if (string.equals("Loan")){
            new AccountSummaryPage().loan.click();
        }

    }


    @And("Account	drop	down	should	have	{string}	selected")
    public void accountDropDownShouldHaveSelected(String selected) {
        WebElement account = new AccountActivityPage().Account;
        Select select = new Select(account);
        String actual = select.getFirstSelectedOption().getText();
        String expexted = selected;

    }
}
