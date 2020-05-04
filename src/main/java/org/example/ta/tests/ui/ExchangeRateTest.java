package org.example.ta.tests.ui;

import com.codeborne.selenide.Configuration;
import org.example.ta.Currency;
import org.example.ta.pages.GoogleHomePage;
import org.example.ta.pages.GoogleSearchResultsPage;
import org.example.ta.services.ui.CurrencyExchangeRateService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.money.MonetaryAmount;
import java.util.List;

public class ExchangeRateTest {
    private final GoogleHomePage googleHomePage = new GoogleHomePage();
    private final CurrencyExchangeRateService currencyExchangeRateService = new CurrencyExchangeRateService();

    @BeforeClass
    public void configureBrowser() {
        Configuration.browser = "chrome";
    }

    @Test(description = "Check that selling rate is greater than purchase rate")
    public void checkExchangeRates() {
        googleHomePage.open();
        GoogleSearchResultsPage googleSearchResultsPage = googleHomePage.search("Открытие");
        List<String> links = googleSearchResultsPage.getLinks();
        SoftAssert softAssert = new SoftAssert();
        String targetLink = "www.open.ru";
        softAssert.assertTrue(links.contains(targetLink), String.format("No %s link found.", targetLink));
        googleSearchResultsPage.clickLink(targetLink);
        MonetaryAmount usdPurchaseRate = currencyExchangeRateService.getCurrencyPurchaseRate(Currency.USD);
        MonetaryAmount usdSellingRate = currencyExchangeRateService.getCurrencySellingRate(Currency.USD);
        MonetaryAmount eurPurchaseRate = currencyExchangeRateService.getCurrencyPurchaseRate(Currency.EUR);
        MonetaryAmount eurSellingRate = currencyExchangeRateService.getCurrencySellingRate(Currency.EUR);
        softAssert.assertTrue(usdPurchaseRate.isLessThan(usdSellingRate), "Selling rate cannot be less than purchase rate.");
        softAssert.assertTrue(eurPurchaseRate.isLessThan(eurSellingRate), "Selling rate cannot be less than purchase rate.");
        softAssert.assertAll();
    }
}
