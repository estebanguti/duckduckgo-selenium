package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends BasePage {

    @FindBy(css = "[data-testid='result'] [data-testid='result-title-a']")
    private List<WebElement> articles;
    @FindBy(css = "[data-testid='region-filter-label']")
    private WebElement regionFilterDropdown;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllTitlesFromResults() {
        wait.until(ExpectedConditions.visibilityOfAllElements(articles));
        return articles.stream()
                .map(article -> article.findElement(By.tagName("span")).getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public int getNumberOfAllRegions() {
        regionFilterDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal--dropdown--region")));
        return driver.findElements(By.cssSelector(".modal--dropdown--region .modal__list__item")).size();
    }

}
