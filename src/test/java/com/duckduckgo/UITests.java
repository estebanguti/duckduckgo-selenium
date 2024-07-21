package com.duckduckgo;

import com.duckduckgo.pages.HomePage;
import com.duckduckgo.pages.ResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UITests {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://start.duckduckgo.com/");
    }

    @Test
    public void verifyAllResultsShouldContainTheSearchedWord() {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        homePage.search("android");

        Assert.assertListContains(resultsPage.getAllTitlesFromResults(), title -> title.contains("android"),
                "All the articles should contain the word: android");
    }

    @Test(priority = 1)
    public void verifyNumberOfRegionsIsMoreThan10() {
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.getNumberOfAllRegions() > 10);
    }

    @AfterClass
    public void turnDown() {
        driver.quit();
    }

}
