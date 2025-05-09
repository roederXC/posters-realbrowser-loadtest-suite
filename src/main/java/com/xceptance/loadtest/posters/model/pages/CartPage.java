package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.xceptance.loadtest.posters.model.components.cart.CartTable;

/**
 * Representation of the cart page.
 *
 * @author Xceptance Software Technologies
 */
public class CartPage extends GeneralPage
{
    public static final String LOCATOR = "#cart-title";

    CartTable cartTable = new CartTable();

    @Override
    public void validate()
    {
        super.validate();
        Selenide.$(LOCATOR).should(Condition.exist);
    }

    @Override
    public boolean is()
    {
        return Selenide.$(LOCATOR).exists() && super.is();
    }
}
