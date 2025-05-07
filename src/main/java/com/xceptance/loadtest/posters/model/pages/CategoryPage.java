package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Condition.exist;

import com.codeborne.selenide.Selenide;

/**
 * Does things on a search result page
 * 
 * @author Xceptance Software Technologies
 *
 */
public class CategoryPage extends ProductListingPage
{
    public static final String LOCATOR = "#title-category-name";

    @Override
    public void validate()
    {
        super.validate();
        Selenide.$(LOCATOR).should(exist);
    }
}
