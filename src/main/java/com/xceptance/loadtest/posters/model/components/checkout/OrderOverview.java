package com.xceptance.loadtest.posters.model.components.checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.OrderConfirmationPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Address Form component in Checkout with all related actions.
 *
 * @author Xceptance Software Technologies
 */
public class OrderOverview implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("div.checkout-overview");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public OrderConfirmationPage placeOrder()
    {
        Context.startAction("CheckoutPlaceOrder");
        locate().$("#btn-order").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .click();

        OrderConfirmationPage confirmationPage = new OrderConfirmationPage();
        confirmationPage.validate();
        confirmationPage.progressIndicator.validateStep(6);

        return confirmationPage;
    }
}
