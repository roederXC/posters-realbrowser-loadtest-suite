package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.CartPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Mini cart component.
 *
 * @author Xceptance Software Technologies
 */
public class MiniCart implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#header-cart-overview");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public void validateEmptyMiniCart()
    {
        locate().$(".header-cart-product-count").should(exactText("0"));
    }

    public void showPopUp()
    {
        Context.startAction("HoverMiniCart", "JS");
        locate().click();
    }

    public CartPage openCartPage()
    {
        showPopUp();

        Context.startAction("OpenCartPage");
        locate().$("a.go-to-cart[href*='/cart']").shouldBe(visible).click();

        CartPage cartPage = new CartPage();
        cartPage.validate();

        return cartPage;
    }
}
