package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.CartPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


/**
 * Mini cart component.
 *
 * @author Xceptance Software Technologies
 */
public class ViewCartButton implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#mini-cart-menu a.go-to-cart");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public CartPage openCartPage()
    {
        Context.startAction("OpenCartPage");
        locate().shouldBe(visible).click();

        CartPage cartPage = new CartPage();
        cartPage.validate();

        return cartPage;
    }
}
