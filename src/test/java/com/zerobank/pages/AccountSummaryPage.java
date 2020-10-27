package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement savings1;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerage;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement checking;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCard;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=4']")
    public WebElement loan;


    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement>  AccountTypes;


}
