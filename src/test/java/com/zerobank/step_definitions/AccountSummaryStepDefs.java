package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryStepDefs {
    @Then("the Page title should be {string}")
    public void the_Page_title_should_be(String expexted) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expexted,actualTitle);
    }
    @Then("Account summar page should have following account types")
    public void account_summar_page_should_have_following_account_types(List<String> expextedAccountsTypes) {
        List<String> actualAccTypes = BrowserUtils.getElementsText(new AccountSummaryPage().AccountTypes);
        Assert.assertEquals(expextedAccountsTypes,actualAccTypes);

    }
    @Then("Credit Account table must have following columns")
    public void credit_Account_table_must_have_following_columns(List<String> expectedColms) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("(//table)[3]//th"));
        List<String> actualColms = BrowserUtils.getElementsText(elements);
        Assert.assertEquals(expectedColms,actualColms);


    }

}
