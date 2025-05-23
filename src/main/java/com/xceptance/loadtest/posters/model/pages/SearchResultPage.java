package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Condition.exist;

import com.codeborne.selenide.Selenide;

/**
 * Does things on a search result page
 * 
 * @author rschwietzke
 *
 */
public class SearchResultPage extends ProductListingPage
{
    public static final String LOCATOR = "#main #title-search-text";

    @Override
    public void validate()
    {
        super.validate();
        Selenide.$(LOCATOR).should(exist);
    }
}
