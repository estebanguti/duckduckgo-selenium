package com.duckduckgo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "searchbox_input")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String value) {
        searchInput.sendKeys(value + Keys.ENTER);
    }

}
