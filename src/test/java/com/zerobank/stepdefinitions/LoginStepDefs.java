package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.login("username","password");
    }

    @When("login with {string} and {string}")
    public void login_with_and(String uName, String pass) {
        loginPage.login(uName,pass);
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String tab) {
        Assert.assertTrue(mainPage.activeTab.getText().equals(tab));
        System.out.println(mainPage.activeTab.getText());
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String errMessage) {
        Assert.assertEquals(errMessage,loginPage.errorMessage.getText());
    }
}
