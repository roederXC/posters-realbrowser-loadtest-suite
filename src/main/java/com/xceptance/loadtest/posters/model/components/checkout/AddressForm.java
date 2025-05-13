package com.xceptance.loadtest.posters.model.components.checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.data.Account;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.CheckoutPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Address Form component in Checkout with all related actions.
 *
 * @author Xceptance Software Technologies
 */
public class AddressForm implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#form-add-del-addr");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }
    
    public void fillContactInformation(Account account)
    {
        locate().$("#address-last-name").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.lastname);
        locate().$("#address-first-name").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.firstname);
        locate().$("#address-address-line").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.shippingAddress.addressLine1);
        locate().$("#address-city").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.shippingAddress.city);
        locate().$("#address-state").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.shippingAddress.state);
        locate().$("#address-zip").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.shippingAddress.zip);
        locate().$("#address-country").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .selectOptionContainingText(account.shippingAddress.country);

        // Screenshot
        Context.startAction("CheckoutFillShipping");
    }

    public CheckoutPage submitAddress()
    {
        Context.startAction("CheckoutSubmitShippingAddress");
        locate().$("#button-add-shipping-address").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.progressIndicator.validateStep(4);
        checkoutPage.paymentForm.validate();

        return checkoutPage;
    }
}
