package org.example.ta.pages;

import com.codeborne.selenide.Condition;
import org.example.ta.Currency;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class OtkritieBankHomePage {
    public String getCurrencyPurchaseRate(Currency currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        By currencyPurchaseRateLocator = By.xpath(String.format("(//tr[contains(@class, 'main-page-exchange__row') and"
                + " descendant::*[contains(text(), '%s')]]//*[contains(@class, 'main-page-exchange__rate')])[1]",
                currency.getCurrencyDescription()));
        $(currencyPurchaseRateLocator).shouldBe(Condition.visible);
        return $(currencyPurchaseRateLocator).text();
    }

    public String getCurrencySellingRate(Currency currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        By currencySellingRateLocator = By.xpath(String.format("(//tr[contains(@class, 'main-page-exchange__row') and"
                + " descendant::*[contains(text(), '%s')]]//*[contains(@class, 'main-page-exchange__rate')])[2]",
                currency.getCurrencyDescription()));
        $(currencySellingRateLocator).shouldBe(Condition.visible);
        return $(currencySellingRateLocator).text();
    }
}
