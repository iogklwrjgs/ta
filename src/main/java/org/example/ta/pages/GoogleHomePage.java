package org.example.ta.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {
    private final By searchTextFieldLocator = By.name("q");

    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleHomePage typeSearchQuery(String searchQuery) {
        Objects.requireNonNull(searchQuery, "Search query cannot be null.");
        $(searchTextFieldLocator).shouldBe(Condition.visible);
        $(searchTextFieldLocator).clear();
        $(searchTextFieldLocator).val(searchQuery);
        return this;
    }

    public GoogleHomePage closeHintDropDownListByPressingEscapeKey() {
        By listOfHintsLocator = By.xpath("//div[@jsname and not(contains(@style, 'display: none'))]/div/ul[contains(@role, 'listbox')]");
        $(listOfHintsLocator).shouldBe(Condition.visible);
        $(searchTextFieldLocator).pressEscape();
        return this;
    }

    public GoogleSearchResultsPage clickSearchButton() {
        By searchButtonLocator = By.xpath("//div[contains(@id, 'searchform')]//div[@jsmodel and @jscontroller]"
                + "/div[not(@jscontroller)]//input[@name='btnK' and @type='submit']");
        $(searchButtonLocator).shouldBe(Condition.visible);
        $(searchButtonLocator).click();
        return new GoogleSearchResultsPage();
    }
}
