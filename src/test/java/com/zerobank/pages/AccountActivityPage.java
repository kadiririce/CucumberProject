package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement AccountDropdown;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement FindTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "(//table)[2]/tbody//td[1]")
    public List<WebElement> datesInTable;


    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(xpath = "(//table)[2]/tbody//td[2]")
    public List<WebElement>  descInTable;


    public void enterDates(String from,String to){
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
    }
    @FindBy(xpath = "(//table)[2]/tbody//td[3]")
    public List<WebElement>  depositInTable;

    @FindBy(xpath = "(//table)[2]/tbody//td[4]")
    public List<WebElement>  withdrawInTable;


    @FindBy(id = "aa_type")
    public WebElement TypeDropDown;

    public int DepositSize(){
        List<String> elementsText1 = BrowserUtils.getElementsText(depositInTable);
        elementsText1.removeIf(s -> s.equals(""));
        return elementsText1.size();
    }

    public int WithdrawalSize(){
        List<String> elementsText2 = BrowserUtils.getElementsText(withdrawInTable);
        elementsText2.removeIf(s -> s.equals(""));
        return elementsText2.size();
    }
}
