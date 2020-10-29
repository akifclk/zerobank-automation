package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountsActivityNavigationSteps {
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String element) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickElement(element);
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("account-activity"));
    }

    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedValue) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.verifyAccountDropdown(expectedValue);
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab(){
        MainPage mainPage = new MainPage();
        mainPage.navigateToModule("Account Activity","Find Transactions");
    }
}
