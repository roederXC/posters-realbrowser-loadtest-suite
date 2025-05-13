package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.components.cart.CartTable;

/**
 * Representation of the cart page.
 *
 * @author Xceptance Software Technologies
 */
public class CartPage extends GeneralPage
{
    CartTable cartTable = new CartTable();

    public static final String LOCATOR = "#cart-title";

    private final String CHECKOUTBUTTONLOCATOR = "#btn-start-checkout";

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

    public CheckoutPage goToCheckout()
    {
        final SelenideElement checkoutButton = $(CHECKOUTBUTTONLOCATOR);

        CheckoutPage checkoutPage = new CheckoutPage();

        // Click checkout button
        Context.startAction("ClickCheckoutButton");

        // Bring checkout button into view
        checkoutButton.should(exist).scrollIntoView(true).shouldBe(visible);
        // Click the checkout button
        checkoutButton.click();

        checkoutPage.validate();
        checkoutPage.progressIndicator.validateStep(2);
        checkoutPage.addressForm.validate();

        return checkoutPage;
    }
}
