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

public class TCompleteOrder extends LoadTestCase
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
    	
        // The BrowsingFlow contains the actions for opening a category or top category page,
        // as well as the actions on these product list pages.
        new BrowsingFlow().run();

        // Opening a product detail page from a product listing page
        ProductDetailPage pdp = new CategoryPage().clickProduct();

        // Setting the, size, finish and quantity
        pdp.configureProduct();

        // Put the configured product into the cart
        pdp.addToCart();

        // Open the cart page
        CartPage cartPage = pdp.miniCart.openCartPage();

        // Go to the checkout
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        // Enter all necessary shipping and billing information
        checkoutPage.addressForm.fillContactInformation(account);
        checkoutPage.addressForm.submitAddress();

        checkoutPage.paymentForm.fillCreditCardInformation(account);
        checkoutPage.paymentForm.submitPayment();

        // Place the order and check if it was successful
        checkoutPage.orderOverview.placeOrder();
    }
}
