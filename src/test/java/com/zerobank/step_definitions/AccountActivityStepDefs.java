package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class AccountActivityStepDefs {

    @When("user go to Account Activity page")
    public void user_go_to_Account_Activity_page() {
        new AccountSummaryPage().AccountActivities.click();

    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        WebElement accountDropdown = new AccountActivityPage().AccountDropdown;
        Select select = new Select(accountDropdown);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());

        Assert.assertEquals(expectedOptions,actualOptions);

    }
    @Then("Transactions table should have following column names")
    public void transactions_table_should_have_following_column_names(List<String> expectedColumns) {

        List<WebElement> elements = Driver.get().findElements(By.xpath("//table//th"));
        List<String> actualColumns = BrowserUtils.getElementsText(elements);
        Assert.assertEquals(expectedColumns,actualColumns);


    }

}
