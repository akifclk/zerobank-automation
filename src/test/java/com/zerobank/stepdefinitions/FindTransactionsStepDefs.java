package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        accountActivityPage.fromDate.sendKeys(from);
        accountActivityPage.toDate.sendKeys(to);
    }

    @And("clicks search")
    public void clicks_search() {
        accountActivityPage.findBtn.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fDate, String tDate) throws ParseException {
        accountActivityPage.verifyDateRange("2012-09-01", "2012-09-06", accountActivityPage.datesList);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        accountActivityPage.isSorted();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.datesList);
        List<Date> actualDates = new ArrayList<>();
        Date unWantedDate = dateFormat.parse(date);
        for (String stringDate : datesString) {
            actualDates.add(dateFormat.parse(stringDate));
        }
        for (Date actualDate : actualDates) {
            Assert.assertNotEquals(actualDate, unWantedDate);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String input) {
        accountActivityPage.descriptionInput.sendKeys(input);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String input) {
        List<String> descriptions = BrowserUtils.getElementsText(accountActivityPage.descriptionList);
        for (String description : descriptions) {
            Assert.assertTrue(description.contains(input));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
