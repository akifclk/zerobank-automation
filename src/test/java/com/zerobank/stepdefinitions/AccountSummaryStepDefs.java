package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.When;

public class AccountSummaryStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String element) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickElement(element);
    }


}
