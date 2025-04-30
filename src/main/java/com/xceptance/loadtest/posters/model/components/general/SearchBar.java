package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Action;

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

    public void search(final String phrase, final String expectedCount)
    {
        Action.run("Search", () ->
        {
            // enter phrase
            $("#header-search-form .form-control").sendKeys(phrase);

            // send search, this is our page load
            $("#header-search-button").click();

            // verify count
            $("#total-product-count").should(Condition.exactText(expectedCount));
        });
    }
}
