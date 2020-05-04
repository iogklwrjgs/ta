package org.example.ta.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import java.util.List;
import java.util.Objects;

public class GoogleSearchResultsPage {
    public List<String> getLinks() {
        return $$("a cite").texts();
    }

    public void clickLink(String link) {
        Objects.requireNonNull(link, "Link cannot be null.");
        By linkLocator = By.xpath(String.format("//a[descendant::cite[contains(text(), '%s')]]", link));
        $(linkLocator).shouldBe(Condition.visible);
        $(linkLocator).click();
    }
}
