package org.example.ta.services.ui;

import org.example.ta.Currency;
import org.example.ta.pages.OtkritieBankHomePage;
import org.example.ta.utils.MoneyTransformer;
import javax.money.MonetaryAmount;
import java.util.Objects;

public class CurrencyExchangeRateService {
    private final OtkritieBankHomePage otkritieBankHomePage = new OtkritieBankHomePage();

    public MonetaryAmount getCurrencyPurchaseRate(Currency currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        String purchaseRate = otkritieBankHomePage.getCurrencyPurchaseRate(currency);
        return MoneyTransformer.transform(purchaseRate, currency);
    }

    public MonetaryAmount getCurrencySellingRate(Currency currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        String sellingRate = otkritieBankHomePage.getCurrencySellingRate(currency);
        return MoneyTransformer.transform(sellingRate, currency);
    }
}
