package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBills extends BasePage{

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement AddNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement PurchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement CurrencyDrowpDown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement CalculateCostsBtn;








}
