package org.example.ta.utils;

import org.example.ta.Currency;

import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;
import java.util.Objects;

public class MoneyTransformer {
    private MoneyTransformer() {
        throw new AssertionError("This class was not designed to be instantiated.");
    }

    public static MonetaryAmount transform(String amount, Currency currency) {
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(currency, "Currency cannot be null");
        MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(Locale.GERMANY);
        return formatter.parse(amount + " " + currency.getCurrencyDescription());
    }
}
