package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class LoginStepDefs {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("user logs in with following valid credentials")
    public void user_logs_in_with_following_valid_credentials(Map<String,String> info) {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(info.get("username"));
        loginPage.password.sendKeys(info.get("password"));
        loginPage.SignIn.click();
    }

    @Then("the Account summary page should be displayed")
    public void the_Account_summary_page_should_be_displayed() {
        String expextedTitle="Zero - Account Summary";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expextedTitle,actualTitle);
    }

    @When("user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys("naber123");
        loginPage.password.sendKeys("sanane123");
        loginPage.SignIn.click();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expexted) {
        String actual = Driver.get().findElement(By.xpath("//div[@class='alert alert-error']")).getText();
        Assert.assertEquals(expexted,actual);
    }

    @When("user clicks Sign in without enter username and password")
    public void userClicksSignInWithoutEnterUsernameAndPassword() {
        new LoginPage().SignIn.click();


    }
}
