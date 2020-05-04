package org.example.ta.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {
    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultsPage search(String searchQuery) {
        Objects.requireNonNull(searchQuery, "Search query cannot be null.");
        By searchTextFieldLocator = By.name("q");
        $(searchTextFieldLocator).shouldBe(Condition.visible);
        $(searchTextFieldLocator).val(searchQuery).pressEnter();
        return new GoogleSearchResultsPage();
    }
}
