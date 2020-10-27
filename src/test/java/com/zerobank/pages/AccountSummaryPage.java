package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    //@FindBy(xpath = "(//a[(text() = 'Savings')])[1]")
    @FindBy(linkText = "Savings")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;

    public void clickElement(String element){
        if(element.equals("Savings")){
            savings.click();
        }else if(element.equals("Brokerage")){
            brokerage.click();
        }else if(element.equals("Checking")){
            checking.click();
        }else if(element.equals("Credit Card")){
            creditCard.click();
        }else if(element.equals("Loan")){
            loan.click();
        }
    }


}
