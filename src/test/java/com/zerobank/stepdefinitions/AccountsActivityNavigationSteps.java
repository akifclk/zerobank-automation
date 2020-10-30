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
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    MainPage mainPage = new MainPage();

    public void page_should_be_displayed(String tab) {
        Assert.assertTrue(mainPage.activeTab.getText().equals(tab));
    }

    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedValue) {

        accountActivityPage.verifyAccountDropdown(expectedValue);
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab(){
        MainPage mainPage = new MainPage();
        mainPage.navigateToModule("Account Activity","Find Transactions");
    }
}
