package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user_login")
    public WebElement userNameInput;

    @FindBy(id="user_password")
    public WebElement passwordInput;

    @FindBy(id="user_remember_me")
    public WebElement keepSignedIn;

    @FindBy(name = "submit")
    public WebElement signInBtn;
    
    @FindBy(linkText = "Forgot your password ?")
    public WebElement forgotPassword;

    public void login(){

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }

}
