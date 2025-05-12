package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Search bar component
 *
 * @author Xceptance Software Technologies
 */
public class SearchBar implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#header-search-form");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public SearchResultPage search(final String phrase, final String expectedCount)
    {
        SearchResultPage searchResultPage = new SearchResultPage();

        Context.startAction("Search");
        // enter phrase
        $("#header-search-form .form-control").sendKeys(phrase);

        // send search, this is our page load
        $("#header-search-button").click();

        searchResultPage.validate();

        // verify count
        $("#total-product-count").should(Condition.exactText(expectedCount));

        return searchResultPage;
    }
}
