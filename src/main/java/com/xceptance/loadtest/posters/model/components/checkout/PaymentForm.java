package com.xceptance.loadtest.posters.model.components.checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.data.Account;
import com.xceptance.loadtest.api.data.CreditCard;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.CheckoutPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Address Form component in Checkout with all related actions.
 *
 * @author Xceptance Software Technologies
 */
public class PaymentForm implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#form-add-payment");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }
    
    public void fillCreditCardInformation(Account account)
    {
        CreditCard cc = account.creditCards.get(0);
        locate().$("#creditcard-number").should(Condition.exist).scrollTo().shouldBe(Condition.visible).sendKeys(cc.number);
        locate().$("#name").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .sendKeys(account.firstname + " " + account.firstname);

        locate().$("#expiration-date-month").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .selectOptionContainingText(cc.expirationMonth);
        locate().$("#expiration-date-year").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .selectOptionContainingText(cc.expirationYear);

        // Screenshot
        Context.startAction("CheckoutEnterCreditCard");
    }

    public CheckoutPage submitPayment()
    {
        Context.startAction("CheckoutSubmitPayment");
        locate().$("#btn-add-payment").should(Condition.exist).scrollTo().shouldBe(Condition.visible)
                .click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.progressIndicator.validateStep(5);
        checkoutPage.orderOverview.validate();

        return checkoutPage;
    }
}
