package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

/**
 * Representation of the cart page.
 *
 * @author Xceptance Software Technologies
 */
public class CartPage extends GeneralPage
{
    public static final String LOCATOR = "#titleCart";

    // TODO Components associated with the cart page

    public void validate()
    {
        Selenide.$(LOCATOR).should(Condition.exist);
    }

    public boolean is()
    {
        return Selenide.$(LOCATOR).exists();
    }
}
