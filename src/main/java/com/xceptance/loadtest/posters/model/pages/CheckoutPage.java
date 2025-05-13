package com.xceptance.loadtest.posters.model.pages;

import com.xceptance.loadtest.api.pages.PageInterface;
import com.xceptance.loadtest.posters.model.components.checkout.AddressForm;
import com.xceptance.loadtest.posters.model.components.checkout.OrderOverview;
import com.xceptance.loadtest.posters.model.components.checkout.PaymentForm;
import com.xceptance.loadtest.posters.model.components.checkout.ProgressIndicator;


/**
 * Representation of the checkout page.
 *
 * @author Xceptance Software Technologies
 */
public class CheckoutPage implements PageInterface
{
    public ProgressIndicator progressIndicator = new ProgressIndicator();

    public AddressForm addressForm = new AddressForm();
    public PaymentForm paymentForm = new PaymentForm();
    public OrderOverview orderOverview = new OrderOverview();

    public static final String LOCATOR = "#checkout-progress-indicator";

    @Override
    public void validate()
    {
        progressIndicator.validate();
    }

    @Override
    public boolean is()
    {
        return progressIndicator.exists();
    }

//    public void selectShippingAddress()
//    {
//        Session.getCurrent().getValueLog().put("shippingAddressSelection", "Trying to select shipping address");
//
//        $x(SHIPPING_PICKUP_APP_LOCATOR).should(exist);
//
//        SelenideElement shippingAddressButton = $x(SHIPPING_ADDRESS_LIST_LOCATOR)
//                .$x("./button[contains(@class, 'radio-container')][1]").as("Shipping address radio button").should(exist);
//
//        Context.get().startAction("ClickSelectShippingAddress", "JS");
//        shippingAddressButton.scrollTo().shouldBe(visible).click();
//
//        Session.getCurrent().getValueLog().put("shippingAddressSelection", "Selected shipping address");
//    }

//    public void clickSubmitCustomerButton()
//    {
//        clickNextButton("Submit Customer");
//    }
//
//    public void clickSubmitShippingButton()
//    {
//        clickNextButton("Submit Shipping");
//    }
//
//    public void clickSubmitPaymentButton()
//    {
//        clickNextButton("Submit Payment");
//    }
//
//    public void clickPlaceOrderButton()
//    {
//        clickNextButton("Place Order");
//    }

//    private void clickNextButton(String buttonClassSubstring)
//    {
//        SelenideElement button = $(".js-next-step-button button." + buttonClassSubstring.toLowerCase().replace(" ", "-"))
//                .should(exist)
//                .shouldNotBe(disabled)
//                .scrollTo();
//
//        // Explicit wait because we want to see the button
//        Selenide.sleep(3000);
//
//        button.shouldBe(visible);
//
//        Context.get().startAction("CheckoutClick" + buttonClassSubstring.replace(" ", "") + "Button");
//        button.click();
//    }

//    public void validateNoErrorAfterPlaceOrder()
//    {
//        final String ERROR_LOCATOR = ".c-checkout__main-row .error-message[style='display: block;'] > .error-message-text";
//
//        // Either we see the order confirmation page (with order number) or an error
//        $(new ByAll(By.cssSelector(ORDER_NUMBER_LOCATOR), By.cssSelector(ERROR_LOCATOR))).should(exist);
//
//        SelenideElement error = $(ERROR_LOCATOR);
//        if (error.exists())
//        {
//            // Add a debug action, so we get a separate screenshot for this
//            Context.get().startAction("ScrollToPlaceOrderErrorMessage", "JS");
//            error.scrollTo();
//        }
//    }

//    public void validateOrderSuccessful()
//    {
//        $(ORDER_NUMBER_LOCATOR).as("Order Number").should(exist).shouldBe(visible);
//    }
}
