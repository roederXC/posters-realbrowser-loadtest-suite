package com.xceptance.loadtest.posters.tests;

import com.xceptance.loadtest.api.data.Account;
import com.xceptance.loadtest.api.tests.LoadTestCase;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.flows.BrowsingFlow;
import com.xceptance.loadtest.posters.model.pages.CartPage;
import com.xceptance.loadtest.posters.model.pages.CategoryPage;
import com.xceptance.loadtest.posters.model.pages.CheckoutPage;
import com.xceptance.loadtest.posters.model.pages.Homepage;
import com.xceptance.loadtest.posters.model.pages.ProductDetailPage;

public class TGuestOrder extends LoadTestCase
{
	/**
     * This test case will simulate a user browsing, adding one or more products to
     * cart and place the order.
     */
    public void test()
    {
        // For test cases in which we need user data, we have to prepare an account.
        Account account = Context.get().data.attachAccount().get();

    	// loads the homepage, data needed is taking from the properties automatically
    	// using the Context as well as the attached configuration.
        new Homepage().open();
    	
        new BrowsingFlow().run();

        ProductDetailPage pdp = new CategoryPage().clickProduct();

        pdp.addToCart();

        CartPage cartPage = pdp.miniCart.openCartPage();

        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.addressForm.fillContactInformation(account);
        checkoutPage.addressForm.submitAddress();

        checkoutPage.paymentForm.fillCreditCardInformation(account);
        checkoutPage.paymentForm.submitPayment();

        checkoutPage.orderOverview.placeOrder();
    }
}
