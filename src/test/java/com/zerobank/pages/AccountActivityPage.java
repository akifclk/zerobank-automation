package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(tagName = "button")
    public WebElement findBtn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> datesList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> descriptionList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> depositList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> withdrawalList;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_type")
    public WebElement selectType;


    public void verifyAccountDropdown(String expectedValue){
        Select dropdown = new Select(accountDropdown);
        Assert.assertEquals("Verify selected dropdown",dropdown.getFirstSelectedOption().getText(),expectedValue);
    }

    public void verifyDateRange(String fromDate, String toDate,List<WebElement> dates) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fDate = sdf.parse(fromDate);
        Date tDate = sdf.parse(toDate);
        for (WebElement date : dates) {
            String dateText = date.getText();
            Date formattedDate = sdf.parse(dateText);
            Assert.assertTrue(formattedDate.compareTo(fDate)>=0 & formattedDate.compareTo(tDate)<=0);
        }

    }

    public void isSorted() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dates = new ArrayList<>();
        for (WebElement element : datesList) {
            dates.add(sdf.parse(element.getText()));
        }
        for (int i = 0; i < dates.size()-1; i++) {
            Assert.assertTrue(dates.get(i).compareTo(dates.get(i+1))>=0);
        }
    }

}
