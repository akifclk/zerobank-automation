package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public abstract class  BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * This method will navigate user to the specific module in zerobank application.
     * For example: if tab is equals to Account Activities,
     * Then method will navigate user to this page: http://zero.webappsecurity.com/bank/account-activity.html
     *
     * @param tab
     */
    public void navigateToModule(String tab) {
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(tab), 5);
            BrowserUtils.waitForVisibility(By.linkText(tab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(tab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(tab)),  5);
        }
    }

    public void navigateToModule(String tab, String subTab) {
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(tab), 5);
            BrowserUtils.waitForVisibility(By.linkText(tab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(tab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(tab)),  5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(subTab), 5);
            BrowserUtils.waitForVisibility(By.linkText(subTab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(subTab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(subTab)),  5);
        }
    }


}