package com.xceptance.loadtest.posters.tests;

import com.xceptance.loadtest.api.tests.LoadTestCase;
import com.xceptance.loadtest.posters.model.flows.BrowsingFlow;
import com.xceptance.loadtest.posters.model.pages.CartPage;
import com.xceptance.loadtest.posters.model.pages.CategoryPage;
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
    	// loads the homepage, data needed is taking from the properties automatically
    	// using the Context as well as the attached configuration.
        Homepage homepage = new Homepage();
        homepage.open();
    	
        new BrowsingFlow(homepage).run();

        ProductDetailPage pdp = new CategoryPage().clickProduct();

        pdp.addToCart();

        CartPage cartPage = pdp.miniCart.openCartPage();

        cartPage.goToCheckout();
    }
}
